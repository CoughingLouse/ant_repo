package mp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Gestore extends Thread
{
	Socket player;
	String nickname;
	boolean finito;
	List<Carta> mano;
	Banco banco;
	
	public Gestore(Socket player, Banco banco)
	{
		this.player = player;
		this.nickname = "";
		this.banco = banco;
		this.finito = false;
		this.mano = new ArrayList<Carta>();
	}
	
	public String stampaMano()
	{
		String ris = "";
		for(Carta c:mano)
			ris += c.valore+c.seme+" ";
		return ris;
	}
	
	public int sommaMano()
	{
		int ris = 0;
		for(Carta c:mano)
			ris += c.getValore();
		return ris;
	}
	
	public void run()
	{
		try
		{
			DataOutputStream out = new DataOutputStream(player.getOutputStream());
			DataInputStream in = new DataInputStream(player.getInputStream());
			
			out.writeUTF("Datti un nickname: ");
			nickname = in.readUTF(); // ricevo nickname
			mano.add(banco.mazzo.estrai());
			mano.add(banco.mazzo.estrai());
			
			String msg = nickname + " " + stampaMano();
			System.out.println(msg);
			out.writeUTF(msg + " Somma: " + sommaMano()); // invio mano
			
			String continua = "si";
			do
			{
				out.writeUTF("Vuoi un'altra carta? Scrivi \"si\" per continuare");
				continua = in.readUTF().toLowerCase();
				if(continua.equals("si"))
					mano.add(banco.mazzo.estrai());
				else
					finito = true;
				if(sommaMano()>=21)
					finito = true;
				
				String msg1 = "La somma della tue carte é: " + sommaMano() + " " + stampaMano();
				System.out.println(msg1);
				out.writeUTF(msg1);
				out.writeInt(sommaMano()); // invio il punteggio
			}
			while(!finito);
			banco.finito();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
