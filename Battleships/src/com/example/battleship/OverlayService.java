package com.example.battleship;
 
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
 
public class OverlayService extends Service {
 
    LinearLayout oView;
 
    @Override
    public IBinder onBind(Intent i) {
        return null;
    }
    
    @Override
    public int onStartCommand (Intent intent, int flags, int startId){
        
    	String alertTextMessage = "";
        
        Bundle extras = intent.getExtras();
        if (extras != null) {
        	alertTextMessage = extras.getString("ALERT_TEXT");
        }
        
        oView = new LinearLayout(this);   
        oView.setBackgroundColor(0x88000000);
        TextView alertText = new TextView(this);
        alertText.setText(alertTextMessage);
        alertText.setId(5);
        alertText.setTextSize(20);
        alertText.setGravity(Gravity.CENTER);
        alertText.setLayoutParams(new WindowManager.LayoutParams(
        		WindowManager.LayoutParams.MATCH_PARENT,
        		WindowManager.LayoutParams.WRAP_CONTENT));
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                0 | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);        
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        oView.addView(alertText);
        wm.addView(oView, params);
        
        return START_STICKY;
    }
 
    @Override
    public void onCreate() {
        super.onCreate();
    }
     
    @Override
    public void onDestroy() {            
        super.onDestroy();
        if(oView!=null){
            WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
            wm.removeView(oView);
        }
    }
 
}