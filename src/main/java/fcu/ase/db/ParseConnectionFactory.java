package fcu.ase.db;

import org.parse4j.Parse;
import org.parse4j.ParseException;

public  class ParseConnectionFactory {
	
	private static final String apiKey = "cq4REGk1XC3w60p2ivhwPI3CwOsPu9nxli7ls1AT";
	
	private static final String restKey = "hlCy0xpb1aFDbJ9Zt6KjRrF3kYuDvUsnP5YgUEgX";
	
	private static boolean initialized = false;

	public static void initializeParseConnection()
	{
		if(initialized == false)
		{
			Parse.initialize(apiKey,  restKey);
			initialized = true;
		}
	}
	
	public static void main(String[] args) throws ParseException
	{
		ParseConnectionFactory.initializeParseConnection();
	}
	
}
