package entities;

public class Main {

	static boolean conflitto(Relazione r1, Relazione r2)
	{
		return(
		(r1.da>=r2.da && r1.a<=r2.a) //r2 contiene r1
		|| 
		(r1.da<=r2.da && r1.a>=r2.a) //r1 contiene r2
		||
		(r2.da>=r1.da && r2.da<=r1.a) //r2 comincia in mezzo a r1
		|| 
		(r1.da>=r2.da && r1.da<=r2.a) //r1 comincia in mezzo a r2 
		); 
	}

	// creare un metodo che prenda due relazioni e restituisca un boolean
	// static boolean poligamo(Relazione[] relazioni);
	
	public static void main(String[] args) 
	{
		// relazioni[] = db.carica(1);
		
		Relazione relazioni[] =
		new Relazione[]
		{
			new Relazione(1,2,"M",1,10),
			new Relazione(1,3,"M",3,5),
			new Relazione(1,7,"M",12,15),
			new Relazione(1,8,"M",4,12),
			new Relazione(1,9,"M",8,14)
		};
	
	boolean bigamo = false;
	
	for(int i=0;i<relazioni.length-1;i++)
	for(int k=i+1;k<relazioni.length;k++)
	if(conflitto(relazioni[i],relazioni[k]))
	{
		System.out.println(i+ " e "+k+ " sono in conflitto");
		bigamo = true;
	}
	
	System.out.println("E' bigamo? "+bigamo);
	
	}
}
