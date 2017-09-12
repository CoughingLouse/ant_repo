package acqua;

//Classe Adapter
public class Lettura2010 implements ILettura2010 
{

	//Contengo la vecchia VERSIONE
	//Contengo l'adattato
	private ILettura l = new Lettura();
	
	@Override
	public int sollevato(int li, int ci) 
	{
		//USO L'ADATTATO PER FARE I CALCOLI
		return l.sollevato(li,ci, (int) (li * 0.02), 1);
	}

}
