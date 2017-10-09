package gameMultithread;

public class Cassa {
	
	int MONEY = 1000;
	
	public Cassa(){}
	
	public synchronized void inc(int money)
	{
		MONEY += money;
	}
	
	public synchronized int getMoney()
	{
		return MONEY;
	}

}
