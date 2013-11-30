package com.example.battleship;
import android.app.Activity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.PorterDuff;


import android.widget.LinearLayout.LayoutParams;

import android.view.LayoutInflater;
import android.widget.PopupWindow;

public class StoreActivity extends Activity {
  
private static final Object someTag0 = Integer.valueOf(0);
private static final Object someTag1 = Integer.valueOf(1);
private static final Object someTag2 = Integer.valueOf(2);
private static final Object someTag3 = Integer.valueOf(3);
private static final Object someTag4 = Integer.valueOf(4);
private static final Object someTag5 = Integer.valueOf(5);
private static final Object someTag6 = Integer.valueOf(6);
private static final Object someTag7 = Integer.valueOf(7);
private static final Object someTag8 = Integer.valueOf(8);
private static final Object someTag9 = Integer.valueOf(9);
private static final Object someTag10 = Integer.valueOf(10);

private static final Object someTag11 = Integer.valueOf(11);
private static final Object someTag12 = Integer.valueOf(12);
private static final Object someTag13 = Integer.valueOf(13);
private static final Object someTag14 = Integer.valueOf(14);
private static final Object someTag15 = Integer.valueOf(15);
private static final Object someTag16 = Integer.valueOf(16);


private static final Object someTag21 = Integer.valueOf(21);
private static final Object someTag22 = Integer.valueOf(22);
private static final Object someTag23 = Integer.valueOf(23);
private static final Object someTag24 = Integer.valueOf(24);
private static final Object someTag25 = Integer.valueOf(25);
private static final Object someTag26 = Integer.valueOf(26);

private static final Object someTag31= Integer.valueOf(31);
private static final Object someTag32 = Integer.valueOf(32);
private static final Object someTag33 = Integer.valueOf(33);
private static final Object someTag34 = Integer.valueOf(34);
private static final Object someTag35 = Integer.valueOf(35);
private static final Object someTag36 = Integer.valueOf(36);

private static final Object someTag41 = Integer.valueOf(41);
private static final Object someTag42 = Integer.valueOf(42);
private static final Object someTag43 = Integer.valueOf(43);
private static final Object someTag44 = Integer.valueOf(44);
private static final Object someTag45 = Integer.valueOf(45);
private static final Object someTag46 = Integer.valueOf(46);

private static final Object someTag51= Integer.valueOf(51);
private static final Object someTag52 = Integer.valueOf(52);
private static final Object someTag53 = Integer.valueOf(53);
private static final Object someTag54 = Integer.valueOf(54);


private static final Object someTag61 = Integer.valueOf(61);
private static final Object someTag62 = Integer.valueOf(61);
private static final Object someTag63 = Integer.valueOf(61);

private static final Object someTag71= Integer.valueOf(71);
private static final Object someTag81 = Integer.valueOf(81);
private static final Object someTag91= Integer.valueOf(91);

private static final Object someTag101 = Integer.valueOf(101);
private static final Object someTag102 = Integer.valueOf(102);
private static final Object someTag103 = Integer.valueOf(103);
private static final Object someTag104 = Integer.valueOf(104);

private static final Object someTag95 = Integer.valueOf(95);
private static final Object someTag96 = Integer.valueOf(96);
private static final Object someTag97 = Integer.valueOf(97);
private static final Object someTag98 = Integer.valueOf(98);
private static final Object someTag99 = Integer.valueOf(99);


private static final Object someTag105 = Integer.valueOf(105);
private static final Object someTag106 = Integer.valueOf(106);
private static final Object someTag107 = Integer.valueOf(107);
private static final Object someTag108 = Integer.valueOf(108);
private static final Object someTag109 = Integer.valueOf(109);

/** Called when the activity is first created. */
	TextView myTextView;
	TextView myTextView1;
	
	int money=0;
	int okay=0;
	int already1=0;
	int already2=0;
	int already3=0;
	int already4=0;
	int already5=0;
	int already6=0;
	
	int weapon1_bought=0;
	int weapon2_bought=0;
	int weapon3_bought=0;
	int weapon4_bought=0;
	int weapon5_bought=0;
	int weapon6_bought=0;
	int weapon7_bought=0;
	int weapon8_bought=0;
	int weapon9_bought=0;
	int weapon10_bought=0;
	
	
	int can_flagon=0;
	int us_flagon=0;
	int japan_flagon=0;
	int rus_flagon=0;
	
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("Weapon Store");
    restartactivity();
  }
  
  public void finish_activity()
  {
	  System.out.println(weapon1_bought);
	  System.out.println(weapon2_bought);
	  System.out.println(weapon3_bought);
	  System.out.println(weapon4_bought);
	  System.out.println(weapon5_bought);
	  System.out.println(weapon6_bought);
	  System.out.println(weapon7_bought);
	  System.out.println(weapon8_bought);
	  System.out.println(weapon9_bought);
	  System.out.println(weapon10_bought);
	  
	  Intent intent = new Intent(this, ConnectActivity.class);
	  Bundle extras = new Bundle();
  	  extras.putInt("EXTRA_weapon1", weapon1_bought);
  	  extras.putInt("EXTRA_weapon2",weapon2_bought);
  	  extras.putInt("EXTRA_weapon3",weapon3_bought);
  	  extras.putInt("EXTRA_weapon4",weapon4_bought);
  	  extras.putInt("EXTRA_weapon5",weapon5_bought);
  	  extras.putInt("EXTRA_weapon6",weapon6_bought);
  	  extras.putInt("EXTRA_weapon7",weapon7_bought);
	  extras.putInt("EXTRA_weapon8",weapon8_bought);
	  extras.putInt("EXTRA_weapon9",weapon9_bought);
	  extras.putInt("EXTRA_weapon10",weapon10_bought);
	  
	 
  	  intent.putExtras(extras);
  	  startActivity(intent);
 	  finish();
  }
  
  public void restartactivity()
  {
	  	money =0;
	  	already1=0;
	  	already2=0;
	  	already3=0;
	  	already4=0;
	  	already5=0;
	  	already6=0;
	  	
	  	weapon1_bought=0;
		weapon2_bought=0;
		weapon3_bought=0;
		weapon4_bought=0;
		weapon5_bought=0;
		weapon6_bought=0;
		weapon7_bought=0;
		weapon8_bought=0;
		weapon9_bought=0;
		weapon10_bought=0;
	 
		can_flagon=0;
		us_flagon=0;
		japan_flagon=0;
		rus_flagon=0;
             
	  	setContentView(R.layout.activity_store);
	  	
	  	Button button = (Button)findViewById(R.id.btn_login);
	  	button.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
	  	 button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click   
           	 restartactivity();
            }
        });
	  	 
	  	final Button button1 = (Button)findViewById(R.id.btn_login1);
	  	button1.getBackground().setColorFilter(0xF0651E00, PorterDuff.Mode.MULTIPLY);
	  	 button1.setOnClickListener(new View.OnClickListener() {
	
            public void onClick(View v) {
                // Perform action on click
            	 if(money>12000)
            	 {
            	LayoutInflater layoutInflater 
                 = (LayoutInflater)getBaseContext()
                  .getSystemService(LAYOUT_INFLATER_SERVICE);  
                View popupView = layoutInflater.inflate(R.layout.thepopup, null); 
                final PopupWindow popupWindow = new PopupWindow(
                        popupView, 
                        LayoutParams.WRAP_CONTENT,  
                              LayoutParams.WRAP_CONTENT);
            	
                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                
                btnDismiss.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                     // TODO Auto-generated method stub
                     popupWindow.dismiss();
                    }
                });
                
                popupWindow.showAsDropDown(button1,50,-600);
            }
            else
            	finish_activity();
            	
            }
        });
	  	 
	    findViewById(R.id.myimage11).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage12).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage13).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage14).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage15).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage16).setOnTouchListener(new MyTouchListener());
	    
	    findViewById(R.id.myimage21).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage22).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage23).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage24).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage25).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage26).setOnTouchListener(new MyTouchListener());
	    
	    findViewById(R.id.myimage31).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage32).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage33).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage34).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage35).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage36).setOnTouchListener(new MyTouchListener());
	    
	    findViewById(R.id.myimage41).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage42).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage43).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage44).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage45).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage46).setOnTouchListener(new MyTouchListener());
	    
	    findViewById(R.id.myimage51).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage52).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage53).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage54).setOnTouchListener(new MyTouchListener());
	    
	    findViewById(R.id.myimage61).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage62).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage63).setOnTouchListener(new MyTouchListener());
	    
	    findViewById(R.id.myimage71).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage81).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage91).setOnTouchListener(new MyTouchListener());
	    
	    findViewById(R.id.myimage101).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage102).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.myimage103).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.buy_list99).setOnDragListener(new MyDragListener());
	    
	    findViewById(R.id.can_flag).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.us_flag).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.rus_flag).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.japan_flag).setOnTouchListener(new MyTouchListener());
	    
	    findViewById(R.id.frame1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame3).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame4).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame5).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame6).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame7).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame8).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame9).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame10).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame11).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame12).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame13).setOnDragListener(new MyDragListener());
	    findViewById(R.id.frame14).setOnDragListener(new MyDragListener());
	    findViewById(R.id.buy_list95).setOnDragListener(new MyDragListener());
	    findViewById(R.id.buy_list96).setOnDragListener(new MyDragListener());
	    findViewById(R.id.buy_list97).setOnDragListener(new MyDragListener());
	    findViewById(R.id.buy_list98).setOnDragListener(new MyDragListener());
	    findViewById(R.id.buy_list99).setOnDragListener(new MyDragListener());
	    findViewById(R.id.flag_list).setOnDragListener(new MyDragListener());
	    
	    //setting parameters of pictures
	    LayoutParams Params11=new LayoutParams(200,300);
	    Params11.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage11).setLayoutParams(Params11);
	    
	    LayoutParams Params12=new LayoutParams(200,300);
	    Params12.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage12).setLayoutParams(Params12);
	    
	    LayoutParams Params13=new LayoutParams(200,300);
	    Params13.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage13).setLayoutParams(Params13);
	    
	    LayoutParams Params14=new LayoutParams(200,300);
	    Params14.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage14).setLayoutParams(Params14);
	    
	    LayoutParams Params15=new LayoutParams(200,300);
	    Params15.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage15).setLayoutParams(Params15);
	    
	    LayoutParams Params16=new LayoutParams(200,300);
	    Params16.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage16).setLayoutParams(Params16);
	    
	    
	    
	    LayoutParams Params21=new LayoutParams(200,300);
	    Params21.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage21).setLayoutParams(Params21);
	    
	    LayoutParams Params22=new LayoutParams(200,300);
	    Params22.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage22).setLayoutParams(Params22);
	    
	    LayoutParams Params23=new LayoutParams(200,300);
	    Params23.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage23).setLayoutParams(Params23);
	    
	    LayoutParams Params24=new LayoutParams(200,300);
	    Params24.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage24).setLayoutParams(Params24);
	    
	    LayoutParams Params25=new LayoutParams(200,300);
	    Params25.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage25).setLayoutParams(Params25);
	    
	    LayoutParams Params26=new LayoutParams(200,300);
	    Params26.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage26).setLayoutParams(Params26);
	    
	    
	    
	    LayoutParams Params31=new LayoutParams(200,300);
	    Params31.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage31).setLayoutParams(Params31);
	    
	    LayoutParams Params32=new LayoutParams(200,300);
	    Params32.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage32).setLayoutParams(Params32);
	    
	    LayoutParams Params33=new LayoutParams(200,300);
	    Params33.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage33).setLayoutParams(Params33);
	    
	    LayoutParams Params34=new LayoutParams(200,300);
	    Params34.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage34).setLayoutParams(Params34);
	    
	    LayoutParams Params35=new LayoutParams(200,300);
	    Params35.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage35).setLayoutParams(Params35);
	    
	    LayoutParams Params36=new LayoutParams(200,300);
	    Params36.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage36).setLayoutParams(Params36);
	    
	    
	    
	    LayoutParams Params41=new LayoutParams(200,300);
	    Params41.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage41).setLayoutParams(Params41);
	    
	    LayoutParams Params42=new LayoutParams(200,300);
	    Params42.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage42).setLayoutParams(Params42);
	    
	    LayoutParams Params43=new LayoutParams(200,300);
	    Params43.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage43).setLayoutParams(Params43);
	    
	    LayoutParams Params44=new LayoutParams(200,300);
	    Params44.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage44).setLayoutParams(Params44);
	    
	    LayoutParams Params45=new LayoutParams(200,300);
	    Params45.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage45).setLayoutParams(Params45);
	    
	    LayoutParams Params46=new LayoutParams(200,300);
	    Params46.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage46).setLayoutParams(Params46);
	    
	    
	    
	    LayoutParams Params51=new LayoutParams(200,300);
	    Params51.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage51).setLayoutParams(Params51);
	    
	    LayoutParams Params52=new LayoutParams(200,300);
	    Params52.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage52).setLayoutParams(Params52);
	    
	    LayoutParams Params53=new LayoutParams(200,300);
	    Params53.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage53).setLayoutParams(Params53);
	    
	    LayoutParams Params54=new LayoutParams(200,300);
	    Params54.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage54).setLayoutParams(Params54);
	    
	    
	    
	    
	    LayoutParams Params61=new LayoutParams(200,300);
	    Params61.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage61).setLayoutParams(Params61);
	    
	    LayoutParams Params62=new LayoutParams(200,300);
	    Params62.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage62).setLayoutParams(Params62);
	    
	    LayoutParams Params63=new LayoutParams(200,300);
	    Params63.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage63).setLayoutParams(Params63);
	    
	    
	    LayoutParams Params71=new LayoutParams(200,300);
	    Params71.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage71).setLayoutParams(Params71);
	    
	    LayoutParams Params81=new LayoutParams(200,300);
	    Params81.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage81).setLayoutParams(Params81);
	    
	    LayoutParams Params91=new LayoutParams(200,300);
	    Params91.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage91).setLayoutParams(Params91);
	    
	    
	    
	    LayoutParams Params101=new LayoutParams(200,300);
	    Params101.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage101).setLayoutParams(Params101);
	    
	    LayoutParams Params102=new LayoutParams(200,300);
	    Params102.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage102).setLayoutParams(Params102);
	    
	    LayoutParams Params103=new LayoutParams(200,300);
	    Params103.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage103).setLayoutParams(Params103);
	    
	    LayoutParams Params104=new LayoutParams(200,300);
	    Params104.setMargins(120, 0,120,12);
	    findViewById(R.id.myimage104).setLayoutParams(Params104);
	    
	    LayoutParams flag1=new LayoutParams(200,300);
	    flag1.setMargins(120, 0,120,12);
	    findViewById(R.id.can_flag).setLayoutParams(flag1);
	    LayoutParams flag2=new LayoutParams(200,300);
	    flag2.setMargins(120, 0,120,12);
	    findViewById(R.id.japan_flag).setLayoutParams(flag2);
	    LayoutParams flag3=new LayoutParams(200,300);
	    flag3.setMargins(120, 0,120,12);
	    findViewById(R.id.rus_flag).setLayoutParams(flag3);
	    LayoutParams flag4=new LayoutParams(200,300);
	    flag4.setMargins(120, 0,120,12);
	    findViewById(R.id.us_flag).setLayoutParams(flag4);
	   
	    //textview for money
	    myTextView = (TextView) findViewById(R.id.mytextview);
	    myTextView.setText("Current total cost is $" + money);
	    myTextView.setTextSize(19);
	    
	    myTextView1 = (TextView) findViewById(R.id.mytextview1);
	    myTextView1.setText("Total money is $12000" );
	    myTextView1.setTextSize(19);


	    //setting up tags
	    findViewById(R.id.myimage11).setTag(someTag11);
	    findViewById(R.id.myimage12).setTag(someTag12);
	    findViewById(R.id.myimage13).setTag(someTag13);
	    findViewById(R.id.myimage14).setTag(someTag14);
	    findViewById(R.id.myimage15).setTag(someTag15);
	    findViewById(R.id.myimage16).setTag(someTag16);
	    
	    findViewById(R.id.myimage21).setTag(someTag21);
	    findViewById(R.id.myimage22).setTag(someTag22);
	    findViewById(R.id.myimage23).setTag(someTag23);
	    findViewById(R.id.myimage24).setTag(someTag24);
	    findViewById(R.id.myimage25).setTag(someTag25);
	    findViewById(R.id.myimage26).setTag(someTag26);
	    
	    findViewById(R.id.myimage31).setTag(someTag31);
	    findViewById(R.id.myimage32).setTag(someTag32);
	    findViewById(R.id.myimage33).setTag(someTag33);
	    findViewById(R.id.myimage34).setTag(someTag34);
	    findViewById(R.id.myimage35).setTag(someTag35);
	    findViewById(R.id.myimage36).setTag(someTag36);
	    
	    findViewById(R.id.myimage41).setTag(someTag41);
	    findViewById(R.id.myimage42).setTag(someTag42);
	    findViewById(R.id.myimage43).setTag(someTag43);
	    findViewById(R.id.myimage44).setTag(someTag44);
	    findViewById(R.id.myimage45).setTag(someTag45);
	    findViewById(R.id.myimage46).setTag(someTag46);
	    
	    findViewById(R.id.myimage51).setTag(someTag51);
	    findViewById(R.id.myimage52).setTag(someTag52);
	    findViewById(R.id.myimage53).setTag(someTag53);
	    findViewById(R.id.myimage54).setTag(someTag54);
	    
	    findViewById(R.id.myimage61).setTag(someTag61);
	    findViewById(R.id.myimage62).setTag(someTag62);
	    findViewById(R.id.myimage63).setTag(someTag63);
	    
	    findViewById(R.id.myimage71).setTag(someTag71);
	    findViewById(R.id.myimage81).setTag(someTag81);
	    findViewById(R.id.myimage91).setTag(someTag91);
	    
	    findViewById(R.id.myimage101).setTag(someTag101);
	    findViewById(R.id.myimage102).setTag(someTag102);
	    findViewById(R.id.myimage103).setTag(someTag103);
	    findViewById(R.id.myimage104).setTag(someTag104);
	  
	    
	    findViewById(R.id.frame1).setTag(someTag1);
	    findViewById(R.id.frame2).setTag(someTag2);
	    findViewById(R.id.frame3).setTag(someTag3);
	    findViewById(R.id.frame4).setTag(someTag4);
	    findViewById(R.id.frame5).setTag(someTag5);
	    findViewById(R.id.frame6).setTag(someTag6);
	    findViewById(R.id.frame7).setTag(someTag7);
	    findViewById(R.id.frame8).setTag(someTag8);
	    findViewById(R.id.frame9).setTag(someTag9);
	    findViewById(R.id.frame10).setTag(someTag10);
	    
	    findViewById(R.id.buy_list95).setTag(someTag95);
	    findViewById(R.id.buy_list96).setTag(someTag96);
	    findViewById(R.id.buy_list97).setTag(someTag97);
	    findViewById(R.id.buy_list98).setTag(someTag98);
	    findViewById(R.id.buy_list99).setTag(someTag99);
	    
	    
	    findViewById(R.id.can_flag).setTag(someTag105);
	    findViewById(R.id.us_flag).setTag(someTag106);
	    findViewById(R.id.japan_flag).setTag(someTag107);
	    findViewById(R.id.rus_flag).setTag(someTag108);
	    findViewById(R.id.flag_list).setTag(someTag109);
	    
  }

  private final class MyTouchListener implements OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
      if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
        ClipData data = ClipData.newPlainText("", "");
        DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(data, shadowBuilder, view, 0);
        view.setVisibility(View.VISIBLE);
        return true;
      } else {
        return false;
      }
    }
  }

  class MyDragListener implements OnDragListener {
    Drawable enterShape = getResources().getDrawable(R.drawable.fire11border);
    Drawable normalShape = getResources().getDrawable(R.drawable.fire11);
    Drawable enterShape1 = getResources().getDrawable(R.drawable.fire7border);
    Drawable normalShape1 = getResources().getDrawable(R.drawable.fire7);

    @Override
    public boolean onDrag(View v, DragEvent event) {
      int action = event.getAction();
      switch (event.getAction()) {
      case DragEvent.ACTION_DRAG_STARTED:
        // do nothing
        break;
      case DragEvent.ACTION_DRAG_ENTERED:
    	if(v.getTag()==Integer.valueOf(95)|| v.getTag()==Integer.valueOf(96)||v.getTag()==Integer.valueOf(97)||v.getTag()==Integer.valueOf(98)||v.getTag()==Integer.valueOf(99) ||v.getTag()==Integer.valueOf(109))
        v.setBackgroundDrawable(enterShape1);
    	else
    	v.setBackgroundDrawable(enterShape);
        break;
      case DragEvent.ACTION_DRAG_EXITED:
    	if(v.getTag()==Integer.valueOf(95)|| v.getTag()==Integer.valueOf(96)||v.getTag()==Integer.valueOf(97)||v.getTag()==Integer.valueOf(98)||v.getTag()==Integer.valueOf(99)||v.getTag()==Integer.valueOf(109))  
        v.setBackgroundDrawable(normalShape1);
    	else
    	v.setBackgroundDrawable(normalShape);
        break;
      case DragEvent.ACTION_DROP:
    	  
        // Dropped, reassign View to ViewGroup
        View view = (View) event.getLocalState();
        
       if(v.getTag()==Integer.valueOf(95) || v.getTag()==Integer.valueOf(96) || v.getTag()==Integer.valueOf(97) || v.getTag()==Integer.valueOf(98) || v.getTag()==Integer.valueOf(99))
        {
        	if(v.getTag()==Integer.valueOf(95) && already1 == 0 && view.getTag()!= Integer.valueOf(105) && view.getTag()!= Integer.valueOf(106) && view.getTag()!= Integer.valueOf(107) && view.getTag()!= Integer.valueOf(108))
        	{
	        	LayoutParams lp = new LayoutParams (150, 200);
	            lp.setMargins(0, -10,0,0);
	            view.setLayoutParams(lp);
	             
	        	ViewGroup the_owner = (ViewGroup) view.getParent();
	 	        the_owner.removeView(view);
	 	        LinearLayout the_container = (LinearLayout) v;
	 	        the_container.addView(view);
	 	        view.setVisibility(View.VISIBLE);
	 	        
	 	        already1=1;
	 	        
	 	       
	  	       if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12)|| view.getTag()== Integer.valueOf(13) || view.getTag()== Integer.valueOf(14) || view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) || view.getTag()== Integer.valueOf(21)|| view.getTag()== Integer.valueOf(22)|| view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) || view.getTag()== Integer.valueOf(31)|| view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36) || view.getTag()== Integer.valueOf(41)|| view.getTag()== Integer.valueOf(42) || view.getTag()== Integer.valueOf(43) || view.getTag()== Integer.valueOf(44) || view.getTag()== Integer.valueOf(45) || view.getTag()== Integer.valueOf(46))
	  		  	{
	  		  		
	  	    	   
	  		  		money += 2000;
	  		  		myTextView.setText("Current total cost is $ " + money);
	  		  		
	  		  		if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12) || view.getTag()== Integer.valueOf(13)|| view.getTag()== Integer.valueOf(14)|| view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) )
	  		  			weapon1_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(21) || view.getTag()== Integer.valueOf(22) || view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) )
	  		  			weapon2_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(31) || view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36))
	  		  			weapon3_bought ++;
	  		  		else 
	  		  			weapon4_bought ++;
	  		  	}
	  	       
	  	       if(view.getTag()== Integer.valueOf(51) || view.getTag()== Integer.valueOf(52) || view.getTag()== Integer.valueOf(53) || view.getTag()== Integer.valueOf(54))
	  	       {
	  	    	  money += 3000;
	  	    	  myTextView.setText("Current total cost is $ " + money);
	  	    	  
	  	    	  weapon5_bought++;
	  	       }
	  	       
	  	      if(view.getTag()== Integer.valueOf(61) || view.getTag()== Integer.valueOf(62) || view.getTag()== Integer.valueOf(63))
	 	       {
	 	    	  money += 4000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 weapon6_bought++;
	 	       }
	  	      
	  	     if(view.getTag()== Integer.valueOf(71) || view.getTag()== Integer.valueOf(81) )
	 	       {
	 	    	  money += 8000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 if(view.getTag()== Integer.valueOf(71))
	 	    		 weapon7_bought++;
	 	    	 else
	 	    		 weapon8_bought++;
	 	       }
	  	     
	  	    if(view.getTag()== Integer.valueOf(91))
	 	       {
	 	    	  money += 9000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	  weapon9_bought++;
	 	       }
	  	    
	  	    if(view.getTag()== Integer.valueOf(101) || view.getTag()== Integer.valueOf(102) || view.getTag()== Integer.valueOf(103) || view.getTag()== Integer.valueOf(104))
	  	       {
	     	      money += 2500;
	     	      myTextView.setText("Current total cost is $ " + money);
	     	      
	     	      weapon10_bought++;
	            }
        	}
        	else
        		view.setVisibility(View.VISIBLE);
        	
        	if(v.getTag()==Integer.valueOf(96) && already2 == 0 && view.getTag()!= Integer.valueOf(105) && view.getTag()!= Integer.valueOf(106) && view.getTag()!= Integer.valueOf(107) && view.getTag()!= Integer.valueOf(108))
        	{
	        	LayoutParams lp = new LayoutParams (150, 200);
	            lp.setMargins(0, -10,0,0);
	            view.setLayoutParams(lp);
	             
	        	ViewGroup the_owner = (ViewGroup) view.getParent();
	 	        the_owner.removeView(view);
	 	        LinearLayout the_container = (LinearLayout) v;
	 	        the_container.addView(view);
	 	        view.setVisibility(View.VISIBLE);
	 	        
	 	        already2=1;
	 	        
	 	       
	 	       if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12)|| view.getTag()== Integer.valueOf(13) || view.getTag()== Integer.valueOf(14) || view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) || view.getTag()== Integer.valueOf(21)|| view.getTag()== Integer.valueOf(22)|| view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) || view.getTag()== Integer.valueOf(31)|| view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36) || view.getTag()== Integer.valueOf(41)|| view.getTag()== Integer.valueOf(42) || view.getTag()== Integer.valueOf(43) || view.getTag()== Integer.valueOf(44) || view.getTag()== Integer.valueOf(45) || view.getTag()== Integer.valueOf(46))
	  		  	{
	  		  		
	  	    	   
	  		  		money += 2000;
	  		  		myTextView.setText("Current total cost is $ " + money);
	  		  		
	  		  		if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12) || view.getTag()== Integer.valueOf(13)|| view.getTag()== Integer.valueOf(14)|| view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) )
	  		  			weapon1_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(21) || view.getTag()== Integer.valueOf(22) || view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) )
	  		  			weapon2_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(31) || view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36))
	  		  			weapon3_bought ++;
	  		  		else 
	  		  			weapon4_bought ++;
	  		  	}
	  	       
	  	       if(view.getTag()== Integer.valueOf(51) || view.getTag()== Integer.valueOf(52) || view.getTag()== Integer.valueOf(53) || view.getTag()== Integer.valueOf(54))
	  	       {
	  	    	  money += 3000;
	  	    	  myTextView.setText("Current total cost is $ " + money);
	  	    	  
	  	    	  weapon5_bought++;
	  	       }
	  	       
	  	      if(view.getTag()== Integer.valueOf(61) || view.getTag()== Integer.valueOf(62) || view.getTag()== Integer.valueOf(63))
	 	       {
	 	    	  money += 4000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 weapon6_bought++;
	 	       }
	  	      
	  	     if(view.getTag()== Integer.valueOf(71) || view.getTag()== Integer.valueOf(81) )
	 	       {
	 	    	  money += 8000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 if(view.getTag()== Integer.valueOf(71))
	 	    		 weapon7_bought++;
	 	    	 else
	 	    		 weapon8_bought++;
	 	       }
	  	     
	  	    if(view.getTag()== Integer.valueOf(91))
	 	       {
	 	    	  money += 9000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	  weapon9_bought++;
	 	       }
	  	    
	  	    if(view.getTag()== Integer.valueOf(101) || view.getTag()== Integer.valueOf(102) || view.getTag()== Integer.valueOf(103) || view.getTag()== Integer.valueOf(104))
	  	       {
	     	      money += 2500;
	     	      myTextView.setText("Current total cost is $ " + money);
	     	      
	     	      weapon10_bought++;
	            }
        	}
        	else
        		view.setVisibility(View.VISIBLE);
        	
        	if(v.getTag()==Integer.valueOf(97) && already3 == 0&& view.getTag()!= Integer.valueOf(105) && view.getTag()!= Integer.valueOf(106) && view.getTag()!= Integer.valueOf(107) && view.getTag()!= Integer.valueOf(108))
        	{
	        	LayoutParams lp = new LayoutParams (150, 200);
	            lp.setMargins(0, -10,0,0);
	            view.setLayoutParams(lp);
	             
	        	ViewGroup the_owner = (ViewGroup) view.getParent();
	 	        the_owner.removeView(view);
	 	        LinearLayout the_container = (LinearLayout) v;
	 	        the_container.addView(view);
	 	        view.setVisibility(View.VISIBLE);
	 	        
	 	        already3=1;
	 	        
	 	       
	 	       if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12)|| view.getTag()== Integer.valueOf(13) || view.getTag()== Integer.valueOf(14) || view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) || view.getTag()== Integer.valueOf(21)|| view.getTag()== Integer.valueOf(22)|| view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) || view.getTag()== Integer.valueOf(31)|| view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36) || view.getTag()== Integer.valueOf(41)|| view.getTag()== Integer.valueOf(42) || view.getTag()== Integer.valueOf(43) || view.getTag()== Integer.valueOf(44) || view.getTag()== Integer.valueOf(45) || view.getTag()== Integer.valueOf(46))
	  		  	{
	  		  		
	  	    	   
	  		  		money += 2000;
	  		  		myTextView.setText("Current total cost is $ " + money);
	  		  		
	  		  		if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12) || view.getTag()== Integer.valueOf(13)|| view.getTag()== Integer.valueOf(14)|| view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) )
	  		  			weapon1_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(21) || view.getTag()== Integer.valueOf(22) || view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) )
	  		  			weapon2_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(31) || view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36))
	  		  			weapon3_bought ++;
	  		  		else 
	  		  			weapon4_bought ++;
	  		  	}
	  	       
	  	       if(view.getTag()== Integer.valueOf(51) || view.getTag()== Integer.valueOf(52) || view.getTag()== Integer.valueOf(53) || view.getTag()== Integer.valueOf(54))
	  	       {
	  	    	  money += 3000;
	  	    	  myTextView.setText("Current total cost is $ " + money);
	  	    	  
	  	    	  weapon5_bought++;
	  	       }
	  	       
	  	      if(view.getTag()== Integer.valueOf(61) || view.getTag()== Integer.valueOf(62) || view.getTag()== Integer.valueOf(63))
	 	       {
	 	    	  money += 4000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 weapon6_bought++;
	 	       }
	  	      
	  	     if(view.getTag()== Integer.valueOf(71) || view.getTag()== Integer.valueOf(81) )
	 	       {
	 	    	  money += 8000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 if(view.getTag()== Integer.valueOf(71))
	 	    		 weapon7_bought++;
	 	    	 else
	 	    		 weapon8_bought++;
	 	       }
	  	     
	  	    if(view.getTag()== Integer.valueOf(91))
	 	       {
	 	    	  money += 9000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	  weapon9_bought++;
	 	       }
	  	    
	  	    if(view.getTag()== Integer.valueOf(101) || view.getTag()== Integer.valueOf(102) || view.getTag()== Integer.valueOf(103) || view.getTag()== Integer.valueOf(104))
	  	       {
	     	      money += 2500;
	     	      myTextView.setText("Current total cost is $ " + money);
	     	      
	     	      weapon10_bought++;
	            }
        	}
        	else
        		view.setVisibility(View.VISIBLE);
        	
        	if(v.getTag()==Integer.valueOf(98) && already4 == 0&& view.getTag()!= Integer.valueOf(105) && view.getTag()!= Integer.valueOf(106) && view.getTag()!= Integer.valueOf(107) && view.getTag()!= Integer.valueOf(108))
        	{
	        	LayoutParams lp = new LayoutParams (150, 200);
	            lp.setMargins(0, -10,0,0);
	            view.setLayoutParams(lp);
	             
	        	ViewGroup the_owner = (ViewGroup) view.getParent();
	 	        the_owner.removeView(view);
	 	        LinearLayout the_container = (LinearLayout) v;
	 	        the_container.addView(view);
	 	        view.setVisibility(View.VISIBLE);
	 	        
	 	        already4=1;
	 	        
	 	       
	 	       if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12)|| view.getTag()== Integer.valueOf(13) || view.getTag()== Integer.valueOf(14) || view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) || view.getTag()== Integer.valueOf(21)|| view.getTag()== Integer.valueOf(22)|| view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) || view.getTag()== Integer.valueOf(31)|| view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36) || view.getTag()== Integer.valueOf(41)|| view.getTag()== Integer.valueOf(42) || view.getTag()== Integer.valueOf(43) || view.getTag()== Integer.valueOf(44) || view.getTag()== Integer.valueOf(45) || view.getTag()== Integer.valueOf(46))
	  		  	{
	  		  		
	  	    	   
	  		  		money += 2000;
	  		  		myTextView.setText("Current total cost is $ " + money);
	  		  		
	  		  		if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12) || view.getTag()== Integer.valueOf(13)|| view.getTag()== Integer.valueOf(14)|| view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) )
	  		  			weapon1_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(21) || view.getTag()== Integer.valueOf(22) || view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) )
	  		  			weapon2_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(31) || view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36))
	  		  			weapon3_bought ++;
	  		  		else 
	  		  			weapon4_bought ++;
	  		  	}
	  	       
	  	       if(view.getTag()== Integer.valueOf(51) || view.getTag()== Integer.valueOf(52) || view.getTag()== Integer.valueOf(53) || view.getTag()== Integer.valueOf(54))
	  	       {
	  	    	  money += 3000;
	  	    	  myTextView.setText("Current total cost is $ " + money);
	  	    	  
	  	    	  weapon5_bought++;
	  	       }
	  	       
	  	      if(view.getTag()== Integer.valueOf(61) || view.getTag()== Integer.valueOf(62) || view.getTag()== Integer.valueOf(63))
	 	       {
	 	    	  money += 4000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 weapon6_bought++;
	 	       }
	  	      
	  	     if(view.getTag()== Integer.valueOf(71) || view.getTag()== Integer.valueOf(81) )
	 	       {
	 	    	  money += 8000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 if(view.getTag()== Integer.valueOf(71))
	 	    		 weapon7_bought++;
	 	    	 else
	 	    		 weapon8_bought++;
	 	       }
	  	     
	  	    if(view.getTag()== Integer.valueOf(91))
	 	       {
	 	    	  money += 9000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	  weapon9_bought++;
	 	       }
	  	    
	  	    if(view.getTag()== Integer.valueOf(101) || view.getTag()== Integer.valueOf(102) || view.getTag()== Integer.valueOf(103) || view.getTag()== Integer.valueOf(104))
	  	       {
	     	      money += 2500;
	     	      myTextView.setText("Current total cost is $ " + money);
	     	      
	     	      weapon10_bought++;
	            }
        	}
        	else
        		view.setVisibility(View.VISIBLE);
        	
        	if(v.getTag()==Integer.valueOf(99) && already5 == 0 && view.getTag()!= Integer.valueOf(105) && view.getTag()!= Integer.valueOf(106) && view.getTag()!= Integer.valueOf(107) && view.getTag()!= Integer.valueOf(108))
        	{
	        	LayoutParams lp = new LayoutParams (150, 200);
	            lp.setMargins(0, -10,0,0);
	            view.setLayoutParams(lp);
	             
	        	ViewGroup the_owner = (ViewGroup) view.getParent();
	 	        the_owner.removeView(view);
	 	        LinearLayout the_container = (LinearLayout) v;
	 	        the_container.addView(view);
	 	        view.setVisibility(View.VISIBLE);
	 	        
	 	        already5=1;
	 	        
	 	       
	 	       if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12)|| view.getTag()== Integer.valueOf(13) || view.getTag()== Integer.valueOf(14) || view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) || view.getTag()== Integer.valueOf(21)|| view.getTag()== Integer.valueOf(22)|| view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) || view.getTag()== Integer.valueOf(31)|| view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36) || view.getTag()== Integer.valueOf(41)|| view.getTag()== Integer.valueOf(42) || view.getTag()== Integer.valueOf(43) || view.getTag()== Integer.valueOf(44) || view.getTag()== Integer.valueOf(45) || view.getTag()== Integer.valueOf(46))
	  		  	{
	  		  		
	  	    	   
	  		  		money += 2000;
	  		  		myTextView.setText("Current total cost is $ " + money);
	  		  		
	  		  		if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12) || view.getTag()== Integer.valueOf(13)|| view.getTag()== Integer.valueOf(14)|| view.getTag()== Integer.valueOf(15) || view.getTag()== Integer.valueOf(16) )
	  		  			weapon1_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(21) || view.getTag()== Integer.valueOf(22) || view.getTag()== Integer.valueOf(23) || view.getTag()== Integer.valueOf(24) || view.getTag()== Integer.valueOf(25) || view.getTag()== Integer.valueOf(26) )
	  		  			weapon2_bought ++;
	  		  		else if (view.getTag()== Integer.valueOf(31) || view.getTag()== Integer.valueOf(32) || view.getTag()== Integer.valueOf(33) || view.getTag()== Integer.valueOf(34) || view.getTag()== Integer.valueOf(35) || view.getTag()== Integer.valueOf(36))
	  		  			weapon3_bought ++;
	  		  		else 
	  		  			weapon4_bought ++;
	  		  	}
	  	       
	  	       if(view.getTag()== Integer.valueOf(51) || view.getTag()== Integer.valueOf(52) || view.getTag()== Integer.valueOf(53) || view.getTag()== Integer.valueOf(54))
	  	       {
	  	    	  money += 3000;
	  	    	  myTextView.setText("Current total cost is $ " + money);
	  	    	  
	  	    	  weapon5_bought++;
	  	       }
	  	       
	  	      if(view.getTag()== Integer.valueOf(61) || view.getTag()== Integer.valueOf(62) || view.getTag()== Integer.valueOf(63))
	 	       {
	 	    	  money += 4000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 weapon6_bought++;
	 	       }
	  	      
	  	     if(view.getTag()== Integer.valueOf(71) || view.getTag()== Integer.valueOf(81) )
	 	       {
	 	    	  money += 8000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	 if(view.getTag()== Integer.valueOf(71))
	 	    		 weapon7_bought++;
	 	    	 else
	 	    		 weapon8_bought++;
	 	       }
	  	     
	  	    if(view.getTag()== Integer.valueOf(91))
	 	       {
	 	    	  money += 9000;
	 	    	  myTextView.setText("Current total cost is $ " + money);
	 	    	  
	 	    	  weapon9_bought++;
	 	       }
	  	    
	  	    if(view.getTag()== Integer.valueOf(101) || view.getTag()== Integer.valueOf(102) || view.getTag()== Integer.valueOf(103) || view.getTag()== Integer.valueOf(104))
	  	       {
	     	      money += 2500;
	     	      myTextView.setText("Current total cost is $ " + money);
	     	      
	     	      weapon10_bought++;
	            }
        	}
        	else
        		view.setVisibility(View.VISIBLE);
 	       
        }
 	    
       /*
        if(v.getTag()==Integer.valueOf(1))
  	  	{
  		  	if(view.getTag()== Integer.valueOf(11) || view.getTag()== Integer.valueOf(12))
  		  	{
  		  		okay=1;
  		  		
  		  	}
  	  	}
        if(okay==1)
        {
	        ViewGroup owner = (ViewGroup) view.getParent();
	        owner.removeView(view);
	        LinearLayout container = (LinearLayout) v;
	        container.addView(view);
	        view.setVisibility(View.VISIBLE);
	        okay=0;
        }
        else */
        	view.setVisibility(View.VISIBLE);
        	
        	
        	
        	if(v.getTag()==Integer.valueOf(109) && already6 == 0 && (view.getTag()==Integer.valueOf(105) ||view.getTag()==Integer.valueOf(106)|| view.getTag()==Integer.valueOf(107) || view.getTag()==Integer.valueOf(108)))
        	{
	        	LayoutParams lp = new LayoutParams (470, 300);
	            lp.setMargins(150, 100,0,0);
	            view.setLayoutParams(lp);
	             
	        	ViewGroup the_owner = (ViewGroup) view.getParent();
	 	        the_owner.removeView(view);
	 	        LinearLayout the_container = (LinearLayout) v;
	 	        the_container.addView(view);
	 	        view.setVisibility(View.VISIBLE);
	 	        
	 	        already6=1;
	 	        
	 	        if(view.getTag()==Integer.valueOf(105))
	 	        	can_flagon=1;
	 	        else if (view.getTag()==Integer.valueOf(106))
	 	        	us_flagon=1;
	 	        else if (view.getTag()==Integer.valueOf(107))
	 	        	japan_flagon=1;	
	 	        else if (view.getTag()==Integer.valueOf(108))
	 	        	rus_flagon=1;
        	}
        	else
        		view.setVisibility(View.VISIBLE);
        
        break;
      case DragEvent.ACTION_DRAG_ENDED:
    	if(v.getTag()==Integer.valueOf(95)|| v.getTag()==Integer.valueOf(96)||v.getTag()==Integer.valueOf(97)||v.getTag()==Integer.valueOf(98)||v.getTag()==Integer.valueOf(99) ||v.getTag()==Integer.valueOf(109) )
        v.setBackgroundDrawable(normalShape1);
    	else
    	v.setBackgroundDrawable(normalShape);	
      default:
        break;
      }
      return true;
    }
  }
} 