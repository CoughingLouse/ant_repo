package gameMultithread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Gestore extends Thread
{
	Socket socket = null;
	int numero = 0;
	
	public Gestore(Socket socket, int numero)
	{
		this.socket = socket;
		this.numero = numero;
	}
	
	static String stampa(List<Carta> giocatore)
	{
		String ris="";
		for(Carta c:giocatore)
			ris += c.valore + c.seme + " ";
		return ris;
	}
	
	static int valore(List<Carta> carte)
	{
		int ris = 0;
		for(Carta c:carte)
			ris += c.getValore();
		return ris;
	}
	
	public void run()
	{
		try
		{
			DataOutputStream out =
					new DataOutputStream(socket.getOutputStream());
			DataInputStream in =
					new DataInputStream(socket.getInputStream());

			Mazzo m = new Mazzo();
			List<Carta> giocatore = new ArrayList<Carta>();
			List<Carta> cpu = new ArrayList<Carta>();
			
			giocatore.add(m.estrai());
			cpu.add(m.estrai());
			giocatore.add(m.estrai());
			cpu.add(m.estrai());
			
			String continua = "si";
			while(continua.equalsIgnoreCase("si"))
			{
				giocatore.add(m.estrai());
				out.writeInt(valore(giocatore));
				if(valore(giocatore)<=21)
				{
					out.writeUTF(
						stampa(giocatore) + "\n" +
						valore(giocatore) + "\n" + 
						"Vuoi continuare? Scrivi \"si\" per ricevere una carta"				
						);
				}
				else
				{
					out.writeUTF(
							stampa(giocatore) + "\n" +
							valore(giocatore) + "\n" + 
							"Hai sballato. Hai perso."				
							);
					break;
				}
				continua = in.readUTF();
			}
			
			while(valore(cpu)<=21 && valore(giocatore)<=21 && valore(cpu)<valore(giocatore))
			{
				cpu.add(m.estrai());
			}
			
			String ris =
					"TU: " + stampa(giocatore) + " = " + valore(giocatore) + "\n" +
					"CPU: " + stampa(cpu) + " = " + valore(giocatore) + "\n";
			
			if(valore(cpu)>21)
				ris += "HAI VINTO!";
			else
				ris += "SEI UN PERDENTE!";
			
			out.writeUTF(ris);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
