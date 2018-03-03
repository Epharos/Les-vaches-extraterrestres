package fr.loubetrey;

public class Game 
{
	private static Game INSTANCE;
	
	public Game()
	{
		INSTANCE = this;
	}
	
	public static Game getInstance()
	{
		return INSTANCE;
	}
}
