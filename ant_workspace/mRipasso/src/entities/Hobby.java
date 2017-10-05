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
	public Hobby(String nome) {
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
	public String toJSON()
	{
		String s = "{";
		s += "'id':" + this.id + ",";
		s += "'name':'" + this.nome + "'";
		s += "}";

		s = s.replace("'", "\"");
		
		return s;
	}
}
