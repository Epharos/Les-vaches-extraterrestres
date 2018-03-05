package fr.loubetrey.utils;

public class Log 
{
	public static void log(Object o, String s, boolean e)
	{
		if(e)
			System.err.println(s + " | " + o);
		else
			System.out.println(s + " | " + o);
	}
	
	public static void err(Object o)
	{
		log(o, "Erreur", true);
	}
	
	public static void log(Object o)
	{
		log(o, "Trace", false);
	}
	
	public static void severe(Object o)
	{
		log(o, "Severe", true);
	}
	
	public static void important(Object o)
	{
		log(o, "Important", true);
	}
}
