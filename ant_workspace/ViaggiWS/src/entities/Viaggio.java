package entities;

public class Viaggio {

	String meta;
	int giorni;
	int prezzo;
	boolean full;
	
	public Viaggio(String meta, int giorni, int prezzo, boolean full)
	{
		this.meta = meta;
		this.giorni = giorni;
		this.prezzo = prezzo;
		this.full = full;
	}

	public String toJSON(int id)
	{
		String ris = "{";
		ris += "'id':"+id+",";
		ris += "'meta':'"+meta+"',";
		ris += "'prezzo':"+prezzo+",";
		ris += "'link':[";
		ris += "'tipo':'self',";
		ris += "'href':'/Viaggi/mostra/?id="+id+"',"; // proviamo il link alla function "mostra"
		ris += "'tipo':'prenota',";
		ris += "'href':'/Viaggi/prenota?id="+id+"'"; // proviamo il link alla function "prenota"
		ris += "]}";
		
		ris = ris.replace("'", "\"");
		return ris;
	}

}
