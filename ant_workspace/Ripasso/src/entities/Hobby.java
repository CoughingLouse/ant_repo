package entities;

public class Hobby
{
	private int id;
	private String nome;
	
	public Hobby(){}
	
	public Hobby(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public Hobby setId(int id) {
		this.id = id;
		return this;
	}
	public String getNome() {
		return nome;
	}
	public Hobby setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	
}
