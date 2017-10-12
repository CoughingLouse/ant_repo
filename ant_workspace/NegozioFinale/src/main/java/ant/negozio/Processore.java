package ant.negozio;

public class Processore {
	
	private String tipo;
	private int benchmark;
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getBenchmark() {
		return benchmark;
	}
	public void setBenchmark(int benchmark) {
		this.benchmark = benchmark;
	}
	public String toString()
	{
		return
			"[tipo: "+tipo+" benchmark: "+benchmark+"]";
	}
	
	

}
