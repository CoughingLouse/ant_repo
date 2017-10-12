package ant.negozio;

public abstract class Prodotto
{
	private String codice;
	private String descrizione;
	private int quantita;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public double prezzo()
	{
		double ris = 0;
		return ris;
	}
	public String scheda()
	{
		String ris = "";
		
		return ris;
	}
	
	
}
