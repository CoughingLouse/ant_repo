package fibonacciDocument;

import javax.jws.WebService;

@WebService(endpointInterface = "fibonacciDocument.IFibonacci")
public class Fibonacci implements IFibonacci {

	@Override
	public int calcolo (int a) 
	{
		if(a==1) return 1;
		if(a<=0) return 1;
		return calcolo(a-1)+calcolo(a-2);
	}
}