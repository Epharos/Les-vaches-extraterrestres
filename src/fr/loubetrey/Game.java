package fr.loubetrey;

import fr.loubetrey.material.Material;
import fr.loubetrey.utils.Log;

public class Game 
{
	private static Game INSTANCE;
	private static Window window;
	
	public Game()
	{
		Log.log("Création d'une instance de jeu ...");
		
		INSTANCE = this;
		
		Material.registerMaterials();
		
		// ------------------------
		
		window = new Window();
		window.run(600, 600);
	}
	
	public static Game getInstance()
	{
		return INSTANCE;
	}
}
