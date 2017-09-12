package entities;

public class TasseItaliane implements ITasse
{
	int guadagno;
	int spese;
	int figli;
	
	@Override
	public void setGuadagni(int g) {
		// TODO Auto-generated method stub
		this.guadagno = g;
	}

	@Override
	public int getGuadagni() {
		// TODO Auto-generated method stub
		return guadagno;
	}

	@Override
	public void setSpeseSanitarie(int s) {
		// TODO Auto-generated method stub
		this.spese = s;
	}

	@Override
	public int getSpeseSanitarie() {
		// TODO Auto-generated method stub
		return spese;
	}

	@Override
	public void setFigli(int n) {
		// TODO Auto-generated method stub
		this.figli = n;
	}

	@Override
	public int getFigli() {
		// TODO Auto-generated method stub
		return figli;
	}

	@Override
	public double calcola() {
		// TODO Auto-generated method stub
		return 
				(
				guadagno * 
					(0.5 - (figli * 0.01)) 
				)
				- 
				(spese * 0.1);
	}

	
}
