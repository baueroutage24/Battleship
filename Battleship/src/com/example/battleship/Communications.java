package com.example.battleship;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Application;
import android.os.AsyncTask;
import android.view.View;

public class Communications{
	
	private static Communications communicator;
	
	private String ip;
	private Integer port;
	private Application application;
	private Activity currentActivity;
	private char communicationId;
	
	public static void initializeCommunications(String ipAddress, Integer portInput, Application app)
	{
		communicator = new Communications();
		communicator.ip = ipAddress;
		communicator.port = portInput;
		communicator.application = app;
		communicator.communicationId = 0;
	}
	
	public static Communications getCommunications()
	{
		return communicator;
	}
	
	public static void setActivity(Activity activity)
	{
		communicator.currentActivity = activity;
	}
	
	public void openSocket() {
		// Make sure the socket is not already opened 
		
		if (((MyApplication)communicator.application).sock != null && ((MyApplication)communicator.application).sock.isConnected() && !((MyApplication)communicator.application).sock.isClosed()) {
			return;
		}
		
		new SocketConnect().execute((Void) null);
	}
	//  Called when the user wants to send a message
	
	public void sendMessage(String msg) {
		// Create an array of bytes.  First byte will be the
		// message length, and the next ones will be the message
		
		byte buf[] = new byte[msg.length() + 1];
		buf[0] = (byte) msg.length(); 
		System.arraycopy(msg.getBytes(), 0, buf, 1, msg.length());
		// Now send through the output stream of the socket
		
		OutputStream out;
		try {
			out = ((MyApplication)communicator.application).sock.getOutputStream();
			try {
				out.write(buf, 0, msg.length() + 1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Called when the user closes a socket
	
	public void closeSocket() {
		Socket s = ((MyApplication)communicator.application).sock;
		try {
			s.getOutputStream().close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Construct an IP address from the four boxes
	
	
	public void handlePlayerRegistered(byte[] eventData)
	{
		byte[] ID = new byte[1];
		ID[0] = eventData[0];
		
		communicator.communicationId = (char)ID[0];
		
		communicator.currentActivity.runOnUiThread
		(
				new Runnable()
				{
					public void run()
					{
						try
						{
							communicator.currentActivity.findViewById(R.id.statusBox).setVisibility(View.VISIBLE);
						}
						catch(Exception ex)
						{
							
						}
					}
				}
		);
	}
	
	public void handleAllPlayersFound()
	{
		communicator.currentActivity.runOnUiThread
		(
				new Runnable()
				{
					public void run()
					{
						try
						{
							((ConnectActivity)communicator.currentActivity).start_setup();
						}
						catch(Exception ex)
						{
							
						}
					}
				}
		);
	}
	
	public void handleAllPlayersReady()
	{
		
	}
	
	public void handleTurnOver(byte[] eventData)
	{
		if(eventData[0] == communicator.communicationId)
		{
			//Opponents turn!
		}
		else
		{
			//Your turn!
		}
	}
	
	public void parseMessages(byte buf[])
	{
		int i;
		
		for(i = 0; i < buf.length; i++)
		{
			if((char)buf[i] == Events.PLAYER_REGISTRED.getCode())
			{
				byte[] eventData = new byte[1];
				
				i++;
				
				for(int j = 0; j < eventData.length; j++)
				{
					eventData[j] = buf[i];
					i++;
				}
				
				handlePlayerRegistered(eventData);
			}
			else if((char)buf[i] == Events.ALL_PLAYERS_FOUND.getCode())
			{
				i++;
				handleAllPlayersFound();
			}
			else if((char)buf[i] == Events.ALL_PLAYERS_READY.getCode())
			{
				i++;
				handleAllPlayersReady();
			}
			else if((char)buf[i] == Events.GAME_OVER.getCode())
			{
				i++;
			}
			else if((char)buf[i] == Events.PLAYER_READY.getCode())
			{
				i++;
			}
			else if((char)buf[i] == Events.GAME_START.getCode())
			{
				i++;
			}
			else if((char)buf[i] == Events.ATTACK_RESULT.getCode())
			{
				i++;
			}
			else if((char)buf[i] == Events.TURN_OVER.getCode())
			{
				byte[] eventData = new byte[1];
				
				i++;
				
				for(int j = 0; j < eventData.length; j++)
				{
					eventData[j] = buf[i];
					i++;
				}
				
				handleTurnOver(eventData);
			}			
		}
	}
	
    // This is the Socket Connect asynchronous thread.  Opening a socket
	// has to be done in an Asynchronous thread in Android.  Be sure you
	// have done the Asynchronous Tread tutorial before trying to understand
	// this code.
	
	public class SocketConnect extends AsyncTask<Void, Void, Socket> {
		// The main parcel of work for this thread.  Opens a socket
		// to connect to the specified IP.
		
		protected Socket doInBackground(Void... voids) {
			Socket s = null;
			try {
				s = new Socket(communicator.ip, communicator.port);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;
		}
		// After executing the doInBackground method, this is 
		// automatically called, in the UI (main) thread to store
		// the socket in this app's persistent storage
		
		protected void onPostExecute(Socket s) {
			MyApplication myApp = (MyApplication)communicator.application;
			myApp.sock = s;
			((ConnectActivity)communicator.currentActivity).connected();
		}
	}
	// This is a timer Task.  Be sure to work through the tutorials
	// on Timer Tasks before trying to understand this code.
	
	public class TCPReadTimerTask extends TimerTask {
		public void run() {
			MyApplication app = (MyApplication)communicator.application;
			if (app.sock != null && app.sock.isConnected()
					&& !app.sock.isClosed()) {
				
				try {
					InputStream in = app.sock.getInputStream();
					// See if any bytes are available from the Middleman
					
					int bytes_avail = in.available();
					if (bytes_avail > 0) {
						
						// If so, read them in and create a sring
						
						byte buf[] = new byte[bytes_avail];
						in.read(buf);
						
						parseMessages(buf);					
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}