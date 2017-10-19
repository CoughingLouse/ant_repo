package ant.SpringMVC.res;

public class Scarpa extends Indumento
{
	private String marca;
	private String modello;
	private String colore;
	private int qta;
	
	public Scarpa(){
		super();
	}
	
	public Scarpa(int id, String marca, String modello, String colore, int qta) {
		super(id);
		this.marca = marca;
		this.modello = modello;
		this.colore = colore;
		this.qta = qta;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}
	
	public String toJSON()
	{
		String ris = "{";
		ris +=	"'id':"+this.getId()+",";
		ris +=	"'marca':'"+this.marca+"',";
		ris += 	"'modello':'"+this.modello+"',";
		ris += 	"'colore':'"+this.colore+"',";
		ris +=	"'qta':"+this.qta+"}";
				
		return ris.replace("'", "\"");
	}
	
    @Override
    public String toString() {
        return this.marca + "#" + this.modello + "#" + this.colore + "#" + this.qta;
    }
	
}
