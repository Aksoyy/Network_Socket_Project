package Frame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Client
{	
	static Socket socket;

    public static void main(String[] args)  throws IOException , ClassNotFoundException
    {
        Socket server = new Socket("192.168.43.168", 9876);
        System.out.println("Hello");

        ObjectInputStream in = new ObjectInputStream(server.getInputStream());
        JLabel label = new JLabel();
        JFrame frame = new JFrame();
        frame.setSize(640, 360);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        label = new JLabel();
        label.setSize(640, 360);
        label.setVisible(true);
        frame.add(label);
        frame.setVisible(true);

        while (true)
        {
            label.setIcon((ImageIcon) in.readObject());
        }
    }  
}