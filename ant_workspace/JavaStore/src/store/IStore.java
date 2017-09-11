package store;
import java.util.ArrayList;
import entities.*;

public interface IStore
{
	public ArrayList<Product> listProduct(String type);
}
