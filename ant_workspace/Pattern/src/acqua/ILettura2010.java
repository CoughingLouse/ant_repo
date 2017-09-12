package acqua;

public interface ILettura2010 
{

	int sollevato(int li, int ci);
	
	default int venduto(int li, int ci)
	{
		return (int)(sollevato(li,ci)*0.95);
	}
	
}
