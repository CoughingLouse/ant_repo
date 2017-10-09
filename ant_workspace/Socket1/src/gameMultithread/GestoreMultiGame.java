package gameMultithread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestoreMultiGame extends Thread
{
	Socket socket = null;
	int numero = 0;
	static DataInputStream in = null;
	static DataOutputStream out = null;
	final static Random rand = new Random();
	static int bid = 0;
	static Cassa c;
	// abbasso i magic numbers!
	final static int BJMP = 3;
	final static int COINMP = 2;
	final static int DICEMP = 6;
	
	public GestoreMultiGame(Socket socket, int numero, Cassa cassa) throws Exception
	{
		this.socket = socket;
		this.numero = numero;
		this.c = cassa;
		this.out = new DataOutputStream(socket.getOutputStream());
		this.in = new DataInputStream(socket.getInputStream());
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
	
	static void choose() throws Exception
	{
		String ris = ""; // userei ris per ottenere una stringa csv tattica
		
		do
		{
			out.writeUTF("A cosa vuoi giocare? (1) BJ/BLACKJACK, (2) COIN/COINFLIP, (3) DICE/DADI, (4) quit");
			String cmd = in.readUTF().toLowerCase();
			
			if(!cmd.equals("quit")) // esco per cmd == quit
			{
				out.writeUTF("Quanto scommetti?"); // richiesta SCOMMESSA
				bid = in.readInt();
				
				switch(cmd)
				{
					case "1":
					case "bj":
					case "blackjack":
		//				ris = blackjack();
						blackjack();
						break;
					case "2":
					case "coin":
					case "coinflip":
		//				ris = coinflip();
						coinflip();
						break;
					case "3":
					case "dadi":
					case "dice":
		//				ris = dice();
						dice();
						break;
					case "4":
					case "quit":
						ris = cmd;
						out.writeUTF("Ciaoooo!");
						break;
					default:
						ris = "Invalid command";
						out.writeUTF(ris);
				}
			} //endif
		}
		while(!ris.equals("quit"));
		
	}
	
	static void blackjack()
	{
		try {
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
			
			int esito = 0;
			
			if(valore(cpu)>21)
			{
				esito = -(bid*BJMP); // la cassa paga
				ris += "HAI VINTO! Guadagni "+Math.abs(esito)+" Euro"; // annullo il "meno"
			}
			else	
			{
				esito = (bid*BJMP); // la cassa guadagna
				ris += "SEI UN PERDENTE! Perdi "+esito+" Euro"; 
			}
			c.inc(esito);
			out.writeUTF(ris);
			System.out.println("La cassa contiene " + c.getMoney());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void coinflip() throws Exception
	{
		String ris = "";
		// TODO: coinflip(): aggiornare la cassa
		int esito = 0;
		out.writeUTF("Testa o Croce?");
		ris = in.readUTF().toLowerCase();
		int launch = rand.nextInt(2);
		
		if(ris.equals("testa"))
		{
			ris = "Hai scelto TESTA ";
			if(launch == 0)
				ris += "e HAI VINTO!";
			else
				ris += "e HAI PERSO!";
		}
		else if(ris.equals("croce"))
		{
			ris = "Hai scelto CROCE ";
			if(launch == 0)
				ris += "e HAI VINTO!";
			else
				ris += "e HAI PERSO";
		}
		else
		{
			ris = "Invalid input";
		}
		// TODO: definire il ruolo di INVALID INPUT per il client (ciclo)
		out.writeUTF(ris);
	}
	
	static void dice() throws Exception
	{
		int player = 0;
		int cpu = 0;
		String ris = "";
		// FIXME: dice(): implementare CASSA
		int esito = 0;
		
		for(int i=0; i<3; i++)
		{
			player += rand.nextInt(6)+1;
			cpu += rand.nextInt(6)+1;
		}
		
		// verifica punteggi
		if(player > cpu)
			ris = "Hai vinto con "+player+" a "+cpu;
		else
			ris = "Ha vinto la CPU "+cpu+" a "+player;
		
		out.writeUTF(ris);
		// TODO: dice(): implementare CASSA
	}
		
	public void run()
	{
//		String cmd = "";
//		while(!cmd.equals("quit"))
//		{
			try {
//				cmd = choose();
				choose();
			} catch (Exception e) {}
//		}
	}
}
