package fr.loubetrey.utils;

public class TimeSince 
{
	private static long start;
	
	public static void init()
	{
		start = System.currentTimeMillis();
	}
	
	public static long timeSince()
	{
		return System.currentTimeMillis() - start;
	}
}
