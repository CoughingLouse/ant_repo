package ant.negozio;

public class RAM {
	
	private String nome;
	private int GB;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
			"[nome: "+nome+" GB: "+GB+"GB]";
	}
	

}
