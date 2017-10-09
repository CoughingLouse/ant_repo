package ant.antsocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Gestore extends Thread
{
	
	int numero = 0;
	Socket socket = null;
	ScuolaDB db = null;
	
	//Passo una socket al gestore
	public Gestore(Socket s, ScuolaDB db, int numero)
	{
		this.numero = numero;
		this.socket = s;
		this.db = db;
	}
	
	
	//Fa le veci del main
	public void run()
	{
		try
		{
	    	DataInputStream dalclient = new DataInputStream(socket.getInputStream());
	    	DataOutputStream alclient = new DataOutputStream(socket.getOutputStream());
	    	String comando = "";
	    	System.out.println("Sto servendo il client "+numero);
	    	int i=0;
	    	
	    	while(!comando.equals("QUIT"))
	    	{
	    		comando = dalclient.readUTF();
	        
	    		switch(comando)
	    		{
		    		case "STUDENTI":
		    			alclient.writeUTF
		    			(
		    				db.vista
		    				(
		    					"select * from studenti", 
		    					"[nome] [cognome] [esito]\n", 
		    					new String[]{"nome","cognome","esito"}
		    				)
		    					
		    			);
		    			break;
		    		case "PROFESSORI":
		    			alclient.writeUTF
		    			(
		    				db.vista
		    				(
		    					"select * from professori", 
		    					"[nome] [cognome] [stipendio]\n", 
		    					new String[]{"nome","cognome","stipendio"}
		    				)
		    					
		    			);
		    			break;
		    		default:
		    			alclient.writeUTF("Comando non riconosciuto");
		    		   		
		    		}i++;
		    	}
	   			System.out.println("Client "+numero+" disconnesso");
			
			System.out.println("Esaurito "+i);
		
		}
		catch(Exception e)
		{
    		System.out.println("Client "+numero+" disconnesso con errore");
		}
	    	
		
		
	}
	
	

}
