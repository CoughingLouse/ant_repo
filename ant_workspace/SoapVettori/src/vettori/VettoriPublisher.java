package vettori;

import javax.xml.ws.Endpoint;

public class VettoriPublisher 
{
	public static void main(String[] args) 
	{
		// /ws/fibonacci era il package, quindi se uso il default??? Niente!
	   Endpoint.publish("http://localhost:8080/ws/vettori", new Vettore<Persona>());
    }
}