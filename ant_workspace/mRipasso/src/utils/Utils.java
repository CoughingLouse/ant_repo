package utils;

public class Utils {
	
	public static final String capitalize(String s)
	{
		s = s.trim();
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

}
