package antsrl.guerra;

public class CarroArmato 
{
	String nome;
	int x;
	int y;
	int g;
	Soldato soldato;

	
	public CarroArmato(Soldato soldato)
	{
		this.soldato = soldato;
	}

	public Soldato getSoldato() {
		return soldato;
	}

	public void setSoldato(Soldato soldato) {
		this.soldato = soldato;
	}

	public void muovi(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public boolean raggiunge(CarroArmato nemico)
	{
		return
			Math.sqrt(Math.pow(x-nemico.x,2)+Math.pow(y-nemico.y,2)) <=g;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	@Override
	public String toString() {
		return "CarroArmato [nome=" + nome + ", x=" + x + ", y=" + y + ", g="
				+ g + "]";
	}
	
	
	
	
}
