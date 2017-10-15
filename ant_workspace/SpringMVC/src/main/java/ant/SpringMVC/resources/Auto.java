package ant.SpringMVC.resources;

//classe java pojo
public class Auto 
{
	String modello;
	int cilindrata;
	
	public Auto(String modello, int cilindrata) {
		super();
		this.modello = modello;
		this.cilindrata = cilindrata;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	
	
	
	

}
