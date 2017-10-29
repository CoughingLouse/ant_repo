package fibonacci;

import javax.xml.ws.Endpoint;

public class VettorePublisher 
{
	public static void main(String[] args) 
	{
	   Endpoint.publish("http://localhost:8080/ws/vettore", new Vettore());
    }
}