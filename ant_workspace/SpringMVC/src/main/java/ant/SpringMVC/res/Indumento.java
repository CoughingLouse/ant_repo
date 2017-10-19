package ant.SpringMVC.res;

public abstract class Indumento
{
	private int id;
	
	public Indumento(){}
	
	public Indumento(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract String toJSON();
}

