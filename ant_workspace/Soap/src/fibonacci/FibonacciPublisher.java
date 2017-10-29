package fibonacci;

import javax.xml.ws.Endpoint;

public class FibonacciPublisher 
{
	public static void main(String[] args) 
	{
	   Endpoint.publish("http://localhost:8080/ws/fibo", new Fibonacci());
    }
}