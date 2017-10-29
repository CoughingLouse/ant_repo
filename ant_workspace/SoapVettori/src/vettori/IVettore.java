package vettori;
import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface IVettore<O extends IFiltrabile>
{
	
	// Implementare questa interfaccia e offrire questi metodi tramite un web service SOAP
	// ovviamente mantenendo le firme come sono.
	
	IVettore<O> filtra(String campo, String valore);
	ArrayList<O> toList();
	
	O get(int i);
	boolean put(O o);
	
	
}
