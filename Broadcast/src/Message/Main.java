package Message;
import Voice.AudioServer;
import Frame.Server;

import java.io.IOException;
import java.net.SocketException;

public class Main
{

	public static void main(String[] args) 
	{
		//String [] a = new String [] {"123"};
		try {
			Server.main(args);
			Frame.Server.main(args);
			try {
				Voice.AudioServer.main(args);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
