package fr.loubetrey;

import fr.loubetrey.material.Material;
import fr.loubetrey.utils.Log;
import fr.loubetrey.world.World;

public class Game 
{
	private static Game INSTANCE;
	private Window window;
	private World theWorld;
	
	public Game()
	{
		Log.log("Création d'une instance de jeu ...");
		
		INSTANCE = this;
		
		Material.registerMaterials();
		theWorld = new World();
		
		// ------------------------
		
		window = new Window();
		window.run(1920, 1080);
	}
	
	public static Game getInstance()
	{
		return INSTANCE;
	}
	
	public World getWorld()
	{
		return theWorld;
	}
}


