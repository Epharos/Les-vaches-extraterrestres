package fr.loubetrey;

import fr.loubetrey.utils.Log;

public class Game 
{
	private static Game INSTANCE;
	
	public Game()
	{
		Log.log("Création d'une instance de jeu ...");
		
		INSTANCE = this;
	}
	
	public static Game getInstance()
	{
		return INSTANCE;
	}
}
