package com.sa.tutorial.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread
{
	Socket socket;
	ServerThread( Socket socket )
	{
		this.socket = socket;
	}
	public void run()
	{
		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("user"+ bufferedReader.readLine() + "baglanmaya hazýr servis..");
			while (true) printWriter.println(bufferedReader.readLine() + "echo");
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}