package com.sa.tutorial.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.SSLServerSocketFactory;
//import java.net.ServerSocket;

public class Client {
	
	public static void main(String[] args) throws IOException
	{
		System.setProperty("java.net.ssl.trustStore", "sa.store");
		//System.setProperty("javax.net.ssl.keyStorePassword", "password");
		
		Socket socket = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost",4444);
		BufferedReader socketbufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter( socket.getOutputStream(), true);
		BufferedReader commandPromptBufferedReader = new BufferedReader( new InputStreamReader(System.in));
		System.out.println(commandPromptBufferedReader.readLine());
		
		String message = null;
		while(true)
		{
			System.out.println("Lutfen mesaj yazýnýz : ");
			message = commandPromptBufferedReader.readLine();
			if ( message.equals("quit"))
			{
				printWriter.println(message);
				socket.close();
				break;
			}
			printWriter.println(message);
			System.out.println("Message reply from server : ");
			System.out.println(socketbufferedReader.readLine());
		}
		
		//ServerSocket serverSocket = ((SSLServerSocketFactory)SSLServerSocketFactory.getDefault()).createServerSocket(4444);
		//System.out.println("Server baglantýya hazýr.........");
		
		//while (true) new ServerThread(serverSocket,.accept()).start();
	}
}