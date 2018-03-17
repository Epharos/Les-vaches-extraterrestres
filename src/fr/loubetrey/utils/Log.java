package fr.loubetrey.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log 
{
	public static void log(Object o, String s, boolean e)
	{
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		
		if(e)
			System.err.println(s + " (" + format.format(now) + ") | " + o);
		else
			System.out.println(s + " (" + format.format(now) + ") | " + o);
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
