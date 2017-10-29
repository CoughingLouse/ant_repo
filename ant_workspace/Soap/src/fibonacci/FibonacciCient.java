package fibonacci;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class FibonacciCient 
{
	public static void main(String[] args) throws Exception
	{
	URL url = new URL("http://localhost:8080/ws/fibonacci?wsdl");

    //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
    QName qname = new QName("http://fibonacci/", "FibonacciService");

    Service service = Service.create(url, qname);

    IFibonacci f = service.getPort(IFibonacci.class);

    System.out.println(f.calcolo(6));
	}
}
