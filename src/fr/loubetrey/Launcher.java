package fr.loubetrey;

import fr.loubetrey.map.HeightMap;
import fr.loubetrey.utils.HeightMapImageGenerator;
import fr.loubetrey.utils.Log;
import fr.loubetrey.utils.TimeSince;

public class Launcher 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Game game = new Game();
		
		TimeSince.init();
		
		Log.log("Génération de la heightmap (" + TimeSince.timeSince() + " ms)");
		HeightMap hm = new HeightMap(1024, 1024, 256, 12);
		Log.log("HeightMap générée ! (" + TimeSince.timeSince() + " ms)");
		@SuppressWarnings("unused")
		HeightMapImageGenerator ig = new HeightMapImageGenerator(hm, "test", 0.8);
//		HeightMap hm1 = new HeightMap(2049, 2049, 128, 8);
//		@SuppressWarnings("unused")
//		HeightMapImageGenerator ig1 = new HeightMapImageGenerator(hm1, "2048px");
//		HeightMap hm2 = new HeightMap(1025, 1025, 128, 8);
//		@SuppressWarnings("unused")
//		HeightMapImageGenerator ig2 = new HeightMapImageGenerator(hm2, "1024px");
//		HeightMap hm3 = new HeightMap(513, 513, 128, 8);
//		@SuppressWarnings("unused")
//		HeightMapImageGenerator ig3 = new HeightMapImageGenerator(hm3, "512px");
	}
}
