package store;

public class StoreFactory 
{

	public static IStore create(String type, String cs)
	{
		IStore ris = null;
		switch(type)
		{
		case "DBG":
			ris = new StoreDebug(cs);
			break;
		case "PROXY":
			ris = new StoreProxy(cs);
			break;
		case "IDEALE":
			ris = new StoreIdeale(cs);
			break;
		default:
			ris = new Store(cs);
		}
		return ris;
		
	}
	
}
