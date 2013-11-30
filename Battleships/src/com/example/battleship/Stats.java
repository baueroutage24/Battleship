package com.example.battleship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Stats extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle myExtras = this.getIntent().getExtras();
		
		setContentView(R.layout.activity_stats);
		
		int winner = myExtras.getInt("WINNER");
				
		Integer p1_numdestroyed = myExtras.getInt("YOUR_HITS");
		Integer p2_numdestroyed = myExtras.getInt("OP_HITS");;
		
		Integer p1_accuracy = (int)((double)myExtras.getInt("YOUR_HITS")/((double)myExtras.getInt("YOUR_HITS") + (double)myExtras.getInt("YOUR_MISSES")))*100;
		Integer p2_accuracy = (int)((double)myExtras.getInt("OP_HITS")/((double)myExtras.getInt("OP_HITS") + (double)myExtras.getInt("OP_MISSES")))*100;
		
		if(winner == 1)
		{
			((TextView)findViewById(R.id.player1_state)).setText("WINNER");
			((TextView)findViewById(R.id.player1_state)).setText("LOSER");
		}
		else
		{
			((TextView)findViewById(R.id.player1_state)).setText("LOSER");
			((TextView)findViewById(R.id.player1_state)).setText("WINNER");
		}
		
		Integer num_turns = myExtras.getInt("NUM_TURNS");
			
		((TextView)findViewById(R.id.player1_num_destruction)).setText(p1_numdestroyed.toString());
		((TextView)findViewById(R.id.player2_num_destruction)).setText(p2_numdestroyed.toString());
		((TextView)findViewById(R.id.accuracy_rate1)).setText(p1_accuracy.toString());
		((TextView)findViewById(R.id.accuracy_rate2)).setText(p2_accuracy.toString());
		((TextView)findViewById(R.id.tot_time)).setText(num_turns.toString());
	}
	
	public void onNewGameButtonClick(View view)
	{
		Intent intent = new Intent(this, ConnectActivity.class);
		startActivity(intent);
	}
	
	public void onMainButtonClick(View view)
	{
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
