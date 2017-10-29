package vettori;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "IVettore")
public class Vettore<O  extends IFiltrabile> implements IVettore<O > 
{
	
	ArrayList<O> elementi = new ArrayList<O>();
	
	public Vettore() {}
	
	public Vettore(O[] c)
	{
		for(O o:c) this.elementi.add(o);
	}
		

	@Override
	public O get(int i) 
	{
		return elementi.get(i);
	}

	@Override
	public boolean put(O o) 
	{
		return elementi.add(o);
		
	}

	@Override
	public IVettore<O> filtra(String campo, String valore) 
	{
		IVettore<O> ris = new Vettore<O>();
		for(O elemento:elementi)
			if(elemento.valido(campo,valore))
				ris.put(elemento);
		return ris;
	}



	@Override
	public ArrayList<O> toList() 
	{
		ArrayList<O> ris = new ArrayList<O>();
		for(O elemento:elementi)
			ris.add(elemento);
		return ris;
	}

}
