package ant.negozio;

public class HD {
	
	private String tipo;
	private int GB;

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getGB() {
		return GB;
	}
	public void setGB(int gB) {
		GB = gB;
	}
	public String toString()
	{
		return
			"[Tipo: " +tipo+" GB: "+GB+"GB]";
	}

}
