package entities;

public class TasseUsa implements ITasse
{
	int guadagno;
	
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
	}

	@Override
	public int getSpeseSanitarie() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFigli(int n) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getFigli() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcola() {
		// TODO Auto-generated method stub
		return guadagno * 0.15;
	}

}
