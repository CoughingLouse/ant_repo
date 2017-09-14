package store;
import java.util.ArrayList;
import java.util.HashMap;

import entities.Product;

public interface IStore
{
	public ArrayList<Product> listProduct(String type);
	//public ArrayList<HashMap<String,String>> products(String type);
}
