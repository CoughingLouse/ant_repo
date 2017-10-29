package vettori;


import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class VettoriClient 
{
	public static void main(String[] args) throws Exception
	{
		URL url = new URL("http://localhost:8080/ws/vettori?wsdl");
	
	    //1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
	    QName qname = new QName("http://vettori/", "VettoriService");
	
	    Service service = Service.create(url, qname);
	
	    Vettore<Persona> v = service.getPort(Vettore.class);
	
	//    System.out.println(v.calcolo(6));
	}
}
