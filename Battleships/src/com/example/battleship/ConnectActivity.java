package com.example.battleship;
import java.util.Timer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.example.battleship.Communications.TCPReadTimerTask;

public class ConnectActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		// This call will result in better error messages if you
		// try to do things in the wrong thread.		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());

		super.onCreate(savedInstanceState);
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_connect);
	}
	
	public void start_setup()
	{
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}
	
	// Route called when the user presses "connect"
	public void openSocket(View view) 
	{		
		Communications.initializeCommunications(getConnectToIP(), getConnectToPort(), getApplication());
		Communications.setActivity(this);
		Communications.getCommunications().openSocket();
		TCPReadTimerTask tcp_task = Communications.getCommunications().new TCPReadTimerTask();
		Timer tcp_timer = new Timer();
		tcp_timer.schedule(tcp_task, 3000, 500);
	}
	
	public void setWaitingForPlayersToConnect()
    {
	  findViewById(R.id.connectionOverlay).setVisibility(View.VISIBLE);
    }
	
	public void setAllPlayersNowConnected()
    {
		findViewById(R.id.connectionOverlay).setVisibility(View.GONE);
    }

	// Construct an IP address from the four boxes
	public String getConnectToIP() {
		String addr = "";
		/*EditText text_ip;
		text_ip = (EditText) findViewById(R.id.ip1);
		addr += text_ip.getText().toString();
		text_ip = (EditText) findViewById(R.id.ip2);
		addr += "." + text_ip.getText().toString();
		text_ip = (EditText) findViewById(R.id.ip3);
		addr += "." + text_ip.getText().toString();
		text_ip = (EditText) findViewById(R.id.ip4);
		addr += "." + text_ip.getText().toString();*/
		
		addr += ((TextView) findViewById(R.id.ip1)).getText().toString();
		addr += "." + ((TextView) findViewById(R.id.ip2)).getText().toString();
		addr += "." + ((TextView) findViewById(R.id.ip3)).getText().toString();
		addr += "." + ((EditText) findViewById(R.id.ip4)).getText().toString();
		return addr;
	}

	// Gets the Port from the appropriate field.
	public Integer getConnectToPort() {
		Integer port;
		TextView text_port;

		text_port = (TextView) findViewById(R.id.port);
		port = Integer.parseInt(text_port.getText().toString());

		return port;
	}
	
	public void connected()
	{
		String playerName = ((TextView) findViewById(R.id.playerName)).getText().toString();
		Communications.getCommunications().sendMessage("A" + playerName);
	}
	
	public void onDisconnectButtonClick(View view)
	{
		findViewById(R.id.statusBox).setVisibility(View.INVISIBLE);
		Communications.getCommunications().closeSocket();
	}
}
