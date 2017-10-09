package ant.antsocket;

/**
 * Hello world!
 *
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	ServerSocket server = new ServerSocket(6666);
    	System.out.println("Sto aspettando");
    	ScuolaDB db = 
         		new ScuolaDB
         		("jdbc:mysql://localhost/scuola2?user=root&password=root");
    	
    	int numero = 0;
    	while(true)
    	{
    		numero++;
    		Socket s = server.accept();
    		new Gestore(s,db,numero).start();
    	}
    	
    	 
        	
    }
}
