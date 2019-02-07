package com.sa.tutorial.socket;

import java.io.IOException;
import java.net.ServerSocket;

import javax.net.ssl.SSLServerSocketFactory;

public class Server
{
	public static void main(String[] args) throws IOException {
		System.setProperty("java.net.ssl.keyStore", "sa.store");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		ServerSocket serverSocket = ((SSLServerSocketFactory)SSLServerSocketFactory.getDefault()).createServerSocket(4444);
		System.out.println("Server okumaya hazýr..........");
		while (true) new ServerThread(serverSocket.accept()).start();
	}
}