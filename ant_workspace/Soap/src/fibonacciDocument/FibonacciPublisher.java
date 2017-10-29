package fibonacciDocument;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class FibonacciPublisher
{

	public static void main(String[] args) 
	{
	   Endpoint.publish("http://localhost:8080/ws/fibonacci", new Fibonacci());
    }

}