package com.example.battleship;

import java.util.Arrays;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

@SuppressLint("NewApi")
public class GameActivity extends Activity {
  
/** Called when the activity is first created. */
	int attackType = 0;
	int houseCount = 0;
	int[] houses = new int[10];
	int attackCount = 0;
	int[] attackLocations = { -1, -1, -1, -1, -1, -1, -1, -1, -1};
	boolean[] pastAttacks = new boolean[64];
	int[] opponentGrid = new int[64];
	int opponentHousesLeft = 25;
	int[] attacksLeft = { 3, 3, 3, 3, 2, 1, 1};
	String mapAsString = "";
	final int GRID_WIDTH = 8;
	final int GRID_HEIGHT = 8;
	final int MAX_HOUSES = 25;
	
	int yourHits = 0;
	int yourMisses = 0;
	int opHits = 0;
	int opMisses = 0;
	int numTurns = 0;
	
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    setContentView(R.layout.activity_game);
	TextView housesLeftTextView = (TextView) findViewById(R.id.housesLeft);
	housesLeftTextView.setText(25 - houseCount + " houses left to place.");
	Arrays.fill(pastAttacks, false);
	Arrays.fill(opponentGrid, -1);
	populateAttackCountTextViews();
	disableBoard();
    Communications.setActivity(this);
  }
  
  public void onGridToggleButtonClick(View view)
  {
	  TextView housesLeftTextView = (TextView) findViewById(R.id.housesLeft);
	  housesLeftTextView.setText(25 - houseCount + " houses left to place.");
	  if(((ToggleButton) view).isChecked())
	  {
		  if(checkNumberOfHouses() <= MAX_HOUSES)
		  {
			  ((ToggleButton) view).setBackgroundResource(R.drawable.house);
			  housesLeftTextView.setText(25 - houseCount + " houses left to place.");
		  }
		  else
		  {
			  ((ToggleButton) view).setChecked(false);
		  }
	  }
	  else
	  {
		  ((ToggleButton) view).setBackgroundResource(R.drawable.shape);
	  }
  }
  
  private int checkNumberOfHouses()
  {
	  int count = 0;
	  GridLayout grid =(GridLayout) findViewById(R.id.mainGrid);
	  for(int i = 0; i < grid.getChildCount(); i++)
	  {
		  if(((ToggleButton) grid.getChildAt(i)).isChecked())
			  count++;
	  }
	  houseCount = count;
	  if(houseCount > MAX_HOUSES)
		  houseCount = MAX_HOUSES;
	  return count;
  }
  
  public void populateOpponentGrid(String receivedMessage)
  {
	  String houseLocations = receivedMessage.substring(1);
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  for(int i = 0; i < grid.getChildCount(); i++)
	  {
		  if(houseLocations.indexOf(0) == 'B')
			  ((ToggleButton) grid.getChildAt(i)).setChecked(true);
		  if(houseLocations.length() == 1)
			  break;
		  houseLocations = houseLocations.substring(1);
	  }
  }
  
  public void updateOpponentGrid(String receivedMessage)
  {
	  String opponentMap = receivedMessage;
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  for(int i = 0; i< grid.getChildCount(); i++)
	  {
		  if(opponentMap.indexOf(1) == 'B')
		  {
			  ((ToggleButton) grid.getChildAt(i)).setBackgroundResource(R.drawable.house);
		  }
	  }
  }
  
  public void onOpponentHouseToggleButtonClick(View view)
  {
	  boolean isChecked = false;
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  ToggleButton opponentHouse = (ToggleButton) view;
	  if(opponentHouse.isChecked())
		  isChecked = true;
	  removePreviousBasicAttackSelection();
	  if(isChecked)
	  {
		  addAttackLocations(opponentHouse);
		  for(int i = 0; i < attackCount; i++)
		  {
			  if(attackLocations[i] >= 0 && attackLocations[i] < 64)
			  {
				  ToggleButton thisHouse = (ToggleButton) grid.getChildAt(attackLocations[i]);
				  if(opponentGrid[attackLocations[i]] == 1)
					  thisHouse.setBackgroundResource(R.drawable.target_hit_location);
				  else if(opponentGrid[attackLocations[i]] == 0)
					  thisHouse.setBackgroundResource(R.drawable.target_miss_location);
				  else
					  thisHouse.setBackgroundResource(R.drawable.attack_location);
			  }
		  }
	  }
	  else
	  {
		  if(opponentGrid[getIndexInParent(opponentHouse)] == 0)
			  opponentHouse.setBackgroundResource(R.drawable.attack_miss);
		  else if(opponentGrid[getIndexInParent(opponentHouse)] == 1)
			  opponentHouse.setBackgroundResource(R.drawable.attack_hit);
		  else
			  opponentHouse.setBackgroundResource(R.drawable.shape);
	  }
  }
  
  void addAttackLocations(ToggleButton location)
  {
	  int attackLocation = getIndexInParent(location);
	  switch(attackType)
	  {
		  case 0:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  break;
		  }
		  case 1:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  if(attackLocation % 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation + 1;
				  attackCount++;
			  }
			  if(attackLocation % 8 != 0)
			  {
				  attackLocations[attackCount] = attackLocation - 1;
				  attackCount++;
			  }
			  break; 
		  }
		  case 2:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  if(attackLocation % 8 != 0 && attackLocation / 8 != 0)
			  {
				  attackLocations[attackCount] = attackLocation + 7;
				  attackCount++;
			  }
			  if(attackLocation % 8 != 7 && attackLocation / 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation - 7;
				  attackCount++;
			  }
			  break;
		  }
		  case 3:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  if(attackLocation % 8 != 7 && attackLocation / 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation + 9;
				  attackCount++;
			  }
			  if(attackLocation % 8 != 0 && attackLocation / 8 != 0)
			  {
				  attackLocations[attackCount] = attackLocation - 9;
				  attackCount++;
			  }
			  break;
		  }
		  case 4:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  if(attackLocation / 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation + 8;
				  attackCount++;
			  }
			  if(attackLocation / 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation - 8;
				  attackCount++;
			  }
			  break;
		  }
		  case 5:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  if(attackLocation % 8 != 0)
			  {
				  if(attackLocation / 8 != 0)
				  {
					  attackLocations[attackCount] = attackLocation - 9;
					  attackCount++;
				  }
				  if(attackLocation / 8 != 7)
				  {
					  attackLocations[attackCount] = attackLocation + 7;
					  attackCount++;
				  }
			  }
			  if(attackLocation % 8 != 7)
			  {
				  if(attackLocation / 8 != 7)
				  {
					  attackLocations[attackCount] = attackLocation + 9;
					  attackCount++;
				  }
				  if(attackLocation / 8 != 0)
				  {
					  attackLocations[attackCount] = attackLocation - 7;
					  attackCount++;
				  }
			  }
			  break;
		  }
		  case 6:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  if(attackLocation % 8 != 0)
			  {
				  attackLocations[attackCount] = attackLocation - 1;
				  attackCount++;
			  }
			  if(attackLocation % 8 > 1)
			  {
				  attackLocations[attackCount] = attackLocation - 2;
				  attackCount++;
			  }
			  if(attackLocation % 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation + 1;
				  attackCount++;
			  }
			  if(attackLocation % 8 < 6)
			  {
				  attackLocations[attackCount] = attackLocation + 2;
				  attackCount++;
			  }
			  if(attackLocation / 8 != 0)
			  {
				  attackLocations[attackCount] = attackLocation - 8;
				  attackCount++;
			  }
			  if(attackLocation / 8 >= 1)
			  {
				  attackLocations[attackCount] = attackLocation - 16;
				  attackCount++;
			  }
			  if(attackLocation / 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation + 8;
				  attackCount++;
			  }
			  if(attackLocation / 8 <= 6)
			  {
			  attackLocations[attackCount] = attackLocation + 16;
			  attackCount++;
			  }
			  break;
		  }
		  case 7:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  if(attackLocation % 8 != 0)
			  {
				  attackLocations[attackCount] = attackLocation - 1;
				  attackCount++;
				  if(attackLocation / 8 != 0)
				  {
					  attackLocations[attackCount] = attackLocation - 9;
					  attackCount++;
				  }
				  if(attackLocation / 8 != 7)
				  {
					  attackLocations[attackCount] = attackLocation + 7;
					  attackCount++;
				  }
			  }
			  if(attackLocation % 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation + 1;
				  attackCount++;
				  if(attackLocation / 8 != 0)
				  {
					  attackLocations[attackCount] = attackLocation - 7;
					  attackCount++;
				  }
				  if(attackLocation / 8 != 7)
				  {
					  attackLocations[attackCount] = attackLocation + 9;
					  attackCount++;
				  }
			  }
			  if(attackLocation / 8 != 0)
			  {
				  attackLocations[attackCount] = attackLocation - 8;
				  attackCount++;
			  }
			  if(attackLocation / 8 != 7)
			  {
				  attackLocations[attackCount] = attackLocation + 8;
				  attackCount++;
			  }
			  break;
		  }
		  default:
		  {
			  attackLocations[attackCount] = attackLocation;
			  attackCount++;
			  break;
		  }
	  }
  }
  
  int getIndexInParent(ToggleButton view)
  {
	  int index = -1;
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  for(int i = 0; i < grid.getChildCount(); i++)
	  {
		  if(grid.getChildAt(i).getId() == view.getId())
		  {
			  index = i;
			  break;
		  }
	  }
	  return index;
  }
  
  void removePreviousBasicAttackSelection()
  {
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  for(int i = 0; i < attackCount; i++)
	  {
		  if(attackLocations[i] >= 0 && attackLocations[i] < 64)
		  {
			  if(opponentGrid[attackLocations[i]] == 0)
			  {
				  ((ToggleButton) grid.getChildAt(attackLocations[i])).setChecked(false);
				  ((ToggleButton) grid.getChildAt(attackLocations[i])).setBackgroundResource(R.drawable.attack_miss);
			  }
			  else if(opponentGrid[attackLocations[i]] == 1)
			  {
				  ((ToggleButton) grid.getChildAt(attackLocations[i])).setChecked(false);
				  ((ToggleButton) grid.getChildAt(attackLocations[i])).setBackgroundResource(R.drawable.attack_hit);
			  }
			  else
			  {
				  ((ToggleButton) grid.getChildAt(attackLocations[i])).setChecked(false);
				  ((ToggleButton) grid.getChildAt(attackLocations[i])).setBackgroundResource(R.drawable.shape);
			  }
		  }
	  }
	  Arrays.fill(attackLocations, -1);
	  attackCount = 0;
  }
  
  void updateAttackPlacement(GridLayout grid)
  {
	  for(int i = 0; i < attackCount; i++)
	  {
		  ((ToggleButton) grid.getChildAt(i)).setChecked(false);
		  ((ToggleButton) grid.getChildAt(i)).setBackgroundResource(R.drawable.shape);
	  }
	  for(int i = 0; i < attackCount; i++)
	  {
		  if(attackLocations[i] >= 0)
		  {
			  ((ToggleButton) grid.getChildAt(attackLocations[i])).setChecked(true);
			  ((ToggleButton) grid.getChildAt(attackLocations[i])).setBackgroundResource(R.drawable.attack_location);
		  }
	  }
  }
  
  public void onResetAttackButtonClick(View view)
  {
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  for(int i = 0; i< grid.getChildCount(); i++)
	  {
		  if(((ToggleButton) grid.getChildAt(i)).isChecked())
		  {
			  ((ToggleButton) grid.getChildAt(i)).setChecked(false);
			  ((ToggleButton) grid.getChildAt(i)).setBackgroundResource(R.drawable.shape);
		  }
	  }
  }
  
  public void onHit(int x, int y)
  {
	  MediaPlayer sound = MediaPlayer.create(this, R.raw.boom);
	  int shiftedX = x - 'A';
	  int shiftedY = y - 'A';
	  
	  yourHits++;
	  
	  int hitIndex = shiftedX + (8 * shiftedY);
			  
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  ((ToggleButton) grid.getChildAt(hitIndex)).setChecked(false);
	  ((ToggleButton) grid.getChildAt(hitIndex)).setClickable(false);
	  ((ToggleButton) grid.getChildAt(hitIndex)).setBackgroundResource(R.drawable.attack_hit);
	  sound.start();
	  
	  opponentGrid[hitIndex] = 1;
	  opponentHousesLeft--;
	  ((TextView) findViewById(R.id.opponentHousesLeft)).setText("Opponent has " + opponentHousesLeft + " left.");
  }
  
  public void onMiss(int x, int y)
  {
	  int shiftedX = x - 'A';
	  int shiftedY = y - 'A';
	  
	  yourMisses++;
	  
	  int hitIndex = shiftedX + (8 * shiftedY);
			  
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  if(opponentGrid[hitIndex] == 1)
	  {
		  ((ToggleButton) grid.getChildAt(hitIndex)).setChecked(false);
		  ((ToggleButton) grid.getChildAt(hitIndex)).setClickable(false);
		  ((ToggleButton) grid.getChildAt(hitIndex)).setBackgroundResource(R.drawable.attack_hit);
	  }
	  else
	  {
		  ((ToggleButton) grid.getChildAt(hitIndex)).setChecked(false);
		  ((ToggleButton) grid.getChildAt(hitIndex)).setClickable(false);
		  ((ToggleButton) grid.getChildAt(hitIndex)).setBackgroundResource(R.drawable.attack_miss);
		  opponentGrid[hitIndex] = 0;
	  }
  }
  
  public void onSelfMiss(int x, int y)
  {
	  int shiftedX = x - 'A';
	  int shiftedY = y - 'A';
	  
	  opMisses++;
	  
	  int hitIndex = shiftedX + (8 * shiftedY);
			  
	  GridLayout grid = (GridLayout) findViewById(R.id.mainGrid);
	  
	  ((ToggleButton) grid.getChildAt(hitIndex)).setChecked(false);
	  ((ToggleButton) grid.getChildAt(hitIndex)).setClickable(false);
	  ((ToggleButton) grid.getChildAt(hitIndex)).setBackgroundResource(R.drawable.attack_miss);
  }
  
  public void onSelfHit(int x, int y)
  {
	  MediaPlayer sound = MediaPlayer.create(this, R.raw.boom);
	  int shiftedX = x - 'A';
	  int shiftedY = y - 'A';
	  
	  opHits++;
	  
	  int hitIndex = shiftedX + (8 * shiftedY);
			  
	  GridLayout grid = (GridLayout) findViewById(R.id.mainGrid);
	  
	  ((ToggleButton) grid.getChildAt(hitIndex)).setChecked(false);
	  ((ToggleButton) grid.getChildAt(hitIndex)).setClickable(false);
	  ((ToggleButton) grid.getChildAt(hitIndex)).setBackgroundResource(R.drawable.attack_hit);
	  sound.start();
  }
  
  public void onConfirmAttackButtonClick(View view)
  {
	  RadioGroup attackRG = (RadioGroup) findViewById(R.id.attackSelectionGrid);
	  placeAttack();
	  String attackMessage = makeAttackMessage();
	  sendMessage(attackMessage);
	  if(attackType != 0)
	  {
		  attacksLeft[attackType - 1]--;
	  }
	  for(int i = 0; i < 7; i++)
	  {
		  if(attacksLeft[i] <= 0)
		  {
			  ((RadioButton) attackRG.getChildAt(i + 1)).setEnabled(false);
			  ((RadioButton) attackRG.getChildAt(0)).setChecked(true);
			  attackType = 0;
		  }
	  }
	  populateAttackCountTextViews();
	  numTurns++;
  }
  
  public void placeAttack()
  {
	  GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
	  for(int i = 0; i< attackCount; i++)
	  {
		  ((ToggleButton) grid.getChildAt(attackLocations[i])).setClickable(false);
		  pastAttacks[attackLocations[i]] = true;
	  }
  }
  
  public String makeAttackMessage()
  {
	  int attackLocation;
	  int column;
	  int row;
	  String attackMessage = "EB" + (char)attackCount;
	  // translate to b/w AA and EE
	  for(int i = 0; i < attackCount; i++)
	  {
		  attackLocation = attackLocations[i];
		  column = attackLocation / GRID_WIDTH;
		  row = attackLocation % GRID_HEIGHT;
		  switch (row)
		  {
			  case 0:
				  attackMessage += 'A';
				  break;
			  case 1:
				  attackMessage += 'B';
				  break;
			  case 2:
				  attackMessage += 'C';
				  break;
			  case 3:
				  attackMessage += 'D';
				  break;
			  case 4:
				  attackMessage += 'E';
				  break;
			  case 5:
				  attackMessage += 'F';
				  break;
			  case 6:
				  attackMessage += 'G';
				  break;
			  case 7:
				  attackMessage += 'H';
				  break;
			  default:
				  break;			 
		  }
		  
		  switch (column)
		  {
			  case 0:
				  attackMessage += 'A';
				  break;
			  case 1:
				  attackMessage += 'B';
				  break;
			  case 2:
				  attackMessage += 'C';
				  break;
			  case 3:
				  attackMessage += 'D';
				  break;
			  case 4:
				  attackMessage += 'E';
				  break;
			  case 5:
				  attackMessage += 'F';
				  break;
			  case 6:
				  attackMessage += 'G';
				  break;
			  case 7:
				  attackMessage += 'H';
				  break;
			  default:
				  break;			 
		  }
	  }
	  return attackMessage;
  }
  
  /*private int checkAdjacent(View view)
  {
	  GridLayout grid = (GridLayout) findViewById(R.id.mainGrid);
	  int numViewInGrid = grid.getChildCount();
	  int viewNumber = -1;
	  int numAdjacent = 0;
	  for(int i = 0; i < numViewInGrid; i++)
	  {
		  if(grid.getChildAt(i).getId() == view.getId())
		  {
			  viewNumber = i;
			  break;
		  }
	  }
	  if(viewNumber >= 0)
	  {
		  for(int i = viewNumber+1; (i%5 > 0) && (!grid.getChildAt(i).isClickable()); i++)
		  {
			  numAdjacent++;
		  }
		  if(viewNumber%5 > 0)
		  {
			  for(int i = viewNumber - 1;(i%5 >= 0) && (!grid.getChildAt(i).isClickable()); i++)
			  {
				  numAdjacent++;
			  }
		  }
	  }
	  
	  return numAdjacent;
  }*/
  
  public void onConfirmButtonClick(View view)
  {
	  findViewById(R.id.housesLeft).setVisibility(View.INVISIBLE);
	  findViewById(R.id.messageText).setVisibility(View.INVISIBLE);
	  mapAsString = "";
	  if(checkNumberOfHouses() == MAX_HOUSES)
	  {
		  mapAsString += 'C';
		  GridLayout grid = (GridLayout) findViewById(R.id.mainGrid);
		  for(int i = 0; i < grid.getChildCount(); i++)
		  {
			  ToggleButton house = (ToggleButton) grid.getChildAt(i);
			  if(house.isChecked())
			  {
				  mapAsString += 'B';
				  house.setClickable(false);
			  }
			  else
			  {
				  mapAsString += 'A';
				  house.setClickable(false);
			  }
		  }
		  findViewById(R.id.resetButton).setClickable(false);
		  findViewById(R.id.resetButton).setVisibility(View.GONE);
		  findViewById(R.id.confirmButton).setClickable(false);
		  findViewById(R.id.confirmButton).setVisibility(View.GONE);
		  sendMessage(mapAsString);
		  setWaitingForPlayersToBeReady();
	  }
	  else
	  {
		  String toPrint = "Need to place " + MAX_HOUSES + " houses.";
		  ((TextView) findViewById(R.id.messageText)).setText(toPrint);
	  }
  }
  
  private void setWaitingForPlayersToBeReady()
  {
	  /*Intent intent = new Intent(this, OverlayService.class);
	  intent.putExtra("ALERT_TEXT", "Waiting for all players to be ready.");
	  startService(intent);*/
	  findViewById(R.id.overlay).setVisibility(View.VISIBLE);
	  disableBoard();
  }
  
  public void setAllPlayersNowReady()
  {
	  /*Intent intent = new Intent(this, OverlayService.class);
	  stopService(intent);*/
	  findViewById(R.id.overlay).setVisibility(View.GONE);
	  enableBoard();
  }
  
  public void setOpponentsTurn()
  {
	  /*Intent intent = new Intent(this, OverlayService.class);
	  intent.putExtra("ALERT_TEXT", "Opponnent's turn!");
	  startService(intent);*/
	  findViewById(R.id.overlay).setVisibility(View.VISIBLE);
	  disableBoard();
  }
  
  public void setYourTurn()
  {
	  /*Intent intent = new Intent(this, OverlayService.class);
	  stopService(intent);*/
	  findViewById(R.id.overlay).setVisibility(View.GONE);
	  enableBoard();
  }
  
  public void onResetButtonClick(View view)
  {
	  GridLayout grid = (GridLayout) findViewById(R.id.mainGrid);
	  for(int i = 0; i < grid.getChildCount(); i++)
	  {
		  ToggleButton house = (ToggleButton) grid.getChildAt(i);
		  if(house.isChecked())
		  {
			  house.setBackgroundResource(R.drawable.shape);
			  house.setChecked(false);
			  houseCount--;
		  }
	  }
  }
  
	//  Called when the user wants to send a message
	public void sendMessage(String message)
	{
		Communications.getCommunications().sendMessage(message);
	}
	
	public void updatePlayerHouse(String receivedMessage)
	{
		GridLayout grid = (GridLayout) findViewById(R.id.mainGrid);
		int column;
		int row;
		int index;
		String houseToUpdate = receivedMessage; //change
		switch (houseToUpdate.charAt(0))
		{
		case 'A':
			row = 0;
			break;
		case 'B':
			row = 1;
			break;
		case 'C':
			row = 2;
			break;
		case 'D':
			row = 3;
			break;
		case 'E':
			row = 4;
			break;
		case 'F':
			row = 5;
			break;
		case 'G':
			row = 6;
			break;
		case 'H':
			row = 7;
			break;
		default:
			row = -1;
		}
		
		switch (houseToUpdate.charAt(1))
		{
		case 'A':
			column = 0;
			break;
		case 'B':
			column = 1;
			break;
		case 'C':
			column = 2;
			break;
		case 'D':
			column = 3;
			break;
		case 'E':
			column = 4;
			break;
		case 'F':
			column = 5;
			break;
		case 'G':
			column = 6;
			break;
		case 'H':
			column = 7;
			break;
		default:
			column= -1;
			break;
		}
		if(row >= 0 && column >= 0)
		{
			index = (column * 7) + row;
			ToggleButton house = (ToggleButton) grid.getChildAt(index);
			Canvas canvas = new Canvas();
			Paint paint = new Paint(); 
			int max_x = house.getWidth()-1; 
			int max_y = house.getHeight()-1;  
			paint.setColor(Color.RED); 
			paint.setStrokeWidth(1); 
			canvas.drawLine(0, 0, max_x, max_y, paint); 
			canvas.drawLine(0, max_y, max_x, 0, paint); 
			house.draw(canvas);
		}
	}
	
	void disableBoard()
	{
		GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
		for(int i = 0; i < grid.getChildCount(); i++)
		{
			((ToggleButton) grid.getChildAt(i)).setClickable(false);
		}
		((Button) findViewById(R.id.attackConfirmButton)).setEnabled(false);
		((Button) findViewById(R.id.attackResetButton)).setEnabled(false);

		RadioGroup attackGrid = (RadioGroup) findViewById(R.id.attackSelectionGrid);
		for(int i = 0; i < attackGrid.getChildCount(); i++)
		{
			attackGrid.getChildAt(i).setClickable(false);
		}
	}
	
	void enableBoard()
	{
		GridLayout grid = (GridLayout) findViewById(R.id.rightGrid);
		for(int i = 0; i < grid.getChildCount(); i++)
		{
			if(!pastAttacks[i])
			{
				((ToggleButton) grid.getChildAt(i)).setClickable(true);
			}
		}
		
		((Button) findViewById(R.id.attackConfirmButton)).setEnabled(true);
		((Button) findViewById(R.id.attackResetButton)).setEnabled(true);
		
		RadioGroup attackGrid = (RadioGroup) findViewById(R.id.attackSelectionGrid);
		for(int i = 0; i < attackGrid.getChildCount(); i++)
		{
			if(i > 0)
			{
				if(attacksLeft[i - 1] > 1)
					attackGrid.getChildAt(i).setClickable(true);
			}
			attackGrid.getChildAt(i).setClickable(true);
		}
	}
	
	public void onAttackSelection(View view)
	{
		boolean checked = ((RadioButton) view).isChecked();
		switch(view.getId())
		{
		case (R.id.basicAttackRadioButton):
		{
			if (checked)
			{
				attackType = 0;
			}
			break;
		}
		case (R.id.verticalAttackRadioButton):
		{
			if (checked)
				attackType = 1;
			break;
		}
		case (R.id.diagonalAttackBLTRRadioButton):
		{
			if (checked)
				attackType = 2;
			break;
		}
		case (R.id.diagonalAttackTLBR):
		{
			if (checked)
				attackType = 3;
			break;
		}
		case (R.id.horizontalAttackRadioButton):
		{
			if (checked)
				attackType = 4;
			break;
		}
		case (R.id.xAttackRadioButton):
		{
			if (checked)
				attackType = 5;
			break;
		}
		case (R.id.plusAttackRadioButton):
		{
			if (checked)
				attackType = 6;
			break;
		}
		case (R.id.squareAttackRadioButton):
		{
			if (checked)
				attackType = 7;
			break;
		}
		default:
			attackType = 0;
		}
	}
	
	void populateAttackCountTextViews()
	{
		LinearLayout attackCountLayout = (LinearLayout) findViewById(R.id.attackCount);
		for(int i = 0; i < attackCountLayout.getChildCount(); i++)
		{
			if(i > 0)
			{
				((TextView) attackCountLayout.getChildAt(i)).setText("" + attacksLeft[i-1]);
			}
		}
	}
	
	public void GameOver(boolean isWinner)
	  {
		  Intent intent = new Intent(this, Stats.class);
		  
		  Bundle extras = new Bundle();
		  
		  extras.putInt("YOUR_HITS", yourHits);
		  extras.putInt("YOUR_MISSES", yourMisses);
		  extras.putInt("OP_HITS", opHits);
		  extras.putInt("OP_MISSES", opMisses);
		  extras.putInt("NUM_TURNS", numTurns);
		  
		  if(isWinner)
		  {
			  extras.putInt("WINNER", 1);
		  }
		  else
		  {
			  extras.putInt("WINNER", 0);
		  }
		  
		  intent.putExtras(extras);
		  
		  startActivity(intent);
	  }
	
  /*public void onRotateButtonClick(View view)
  {
	  try
	  {
	  ImageView imageView = selectedImageView;

	    //Decode Image using Bitmap factory.
	    Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

	    //Create object of new Matrix.
	    Matrix matrix = new Matrix();

	    //set image rotation value to 90 degrees in matrix.
	    matrix.postRotate(90);

	    //Create bitmap with new values.
	    Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

	    //put rotated image in ImageView.
	    imageView.setImageBitmap(rotatedBitmap);
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  */

  /*private final class MyTouchListener implements OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
      if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
    	  selectedImageView = (ImageView) view;
    	  ClipData data = ClipData.newPlainText("", "");
    	  DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
    	  view.startDrag(data, shadowBuilder, view, 0);
    	  view.setVisibility(View.INVISIBLE);
    	  return true;
      } else {
    	  return false;
      }
    }
  }*/
}