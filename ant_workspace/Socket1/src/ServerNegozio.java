import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import entities.*;

public class ServerNegozio {
	
	private final String HERE = "[ServerNegozio] ";
	//private static String[] pc = new String[]{"hp","mac","asus","dell"};

	public static void main(String[] args) throws Exception
	{	
		ServerSocket server = new ServerSocket(7777);
		System.out.println("Ciao, sono il server e sto aspettando");
		Socket socket = server.accept();
		DataOutputStream uscita =
				new DataOutputStream(socket.getOutputStream());
		DataInputStream entrata =
				new DataInputStream(socket.getInputStream());
		
		// scaffolding pcs
		PC pc1 = new PC();
		pc1.setMarca("Asus").setModello("X9").setProcessore("i7").setRam(16).setHdd(4000);
		PC pc2 = new PC();
		pc2.setMarca("Brondi").setModello("Canard").setProcessore("i5").setRam(8).setHdd(2000);
		PC pc3 = new PC();
		pc3.setMarca("Celsius").setModello("C-55").setProcessore("i3").setRam(4).setHdd(1000);
		PC pc4 = new PC();
		pc4.setMarca("Donnerd").setModello("ABC007").setProcessore("m4").setRam(4).setHdd(2000);
		PC pc5 = new PC();
		pc5.setMarca("Erikkson").setModello("Erik101").setProcessore("i7").setRam(16).setHdd(4000);
		PC pc6 = new PC();
		pc6.setMarca("Asus").setModello("X5").setProcessore("i7").setRam(16).setHdd(4000);
		// creazione negozio
		Negozio negozio = new Negozio();
		negozio.addPC(pc1).addPC(pc2).addPC(pc3).addPC(pc4).addPC(pc5).addPC(pc6);
		
		
		boolean quit = false;
		do
		{
			uscita.writeUTF("cosa vuoi?");
			String cmd = entrata.readUTF().toLowerCase();
			String ris = "";
			
			switch(cmd){
			case "lista":
				for(PC pc:negozio.pcs)
					ris += pc.toString() + "\n";
				break;
			case "piucostoso":
				double piuCostoso = 0;
				for(int i=0; i<negozio.pcs.size(); i++)
					if(negozio.pcs.get(i).prezzo() > piuCostoso)
						piuCostoso = i;
				ris = negozio.pcs.get((int)piuCostoso).toString();
				break;
			case "menocostoso":
				double menoCostoso = negozio.pcs.get(0).prezzo();
				for(int i=0; i<negozio.pcs.size(); i++)
					if(negozio.pcs.get(i).prezzo() < menoCostoso)
						menoCostoso = i;
				ris = negozio.pcs.get((int)menoCostoso).toString();
				break;
			case "sommaprezzi":
				double somma = 0;
				for(PC pc:negozio.pcs)
					somma += pc.prezzo();
				ris = somma+"";
				break;
			// TODO: case "unamarca" CONTROLLARE CHE NON SI FERMI DOPO AVER RISPOSTO
			case "unamarca":
				uscita.writeUTF("qualemarca");
				String marca = entrata.readUTF();
				for(PC pc:negozio.pcs)
					if(pc.getMarca().equalsIgnoreCase(marca))
						ris += pc.toString() + "\n";
				uscita.writeUTF("\n" + ris);
				break;
			case "esci":
				ris = "ciaooone!";
				quit = true;
				break;
			default:
				ris = "Comando sconosciuto";
			}
			uscita.writeUTF(ris);
		}
		while(!quit);
		
		
		
		socket.close();
		uscita.close();
		entrata.close();
		server.close();
	}

}
