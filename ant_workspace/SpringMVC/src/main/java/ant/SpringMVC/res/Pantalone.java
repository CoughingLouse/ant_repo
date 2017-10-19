package ant.SpringMVC.res;

public class Pantalone extends Indumento
{
	private String marca;
	private String colore;
	private int taglia;
	private int qta;
	
	public Pantalone(){
		super();
	}

	public Pantalone(int id, String marca, String colore, int taglia, int qta) {
		super(id);
		this.marca = marca;
		this.colore = colore;
		this.taglia = taglia;
		this.qta = qta;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getTaglia() {
		return taglia;
	}

	public void setTaglia(int taglia) {
		this.taglia = taglia;
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
		ris += 	"'colore':'"+this.colore+"',";
		ris += 	"'taglia':'"+this.taglia+"',";
		ris +=	"'qta':"+this.qta+"}";
				
		return ris.replace("'", "\"");
	}
	
    @Override
    public String toString() {
        return this.marca + "#" + this.colore + "#" + this.taglia + "#" + this.qta;
    }
	
}
