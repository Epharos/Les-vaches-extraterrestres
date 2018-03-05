package fr.loubetrey.utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import fr.loubetrey.map.HeightMap;

public class HeightMapImageGenerator 
{
	public HeightMapImageGenerator(HeightMap hm, String name, double p)
	{
		Log.log("Creation de l'image (" + TimeSince.timeSince() + " ms)");
		BufferedImage img = new BufferedImage(hm.getWidth() - 1, hm.getHeight() - 1, BufferedImage.TYPE_INT_ARGB);
		File f = new File(name + ".png");
		
		Log.log("Récupération de la map(" + TimeSince.timeSince() + " ms)");
		double[][] map = hm.getMap(p);
		
		Log.log("Début de l'écriture sur image(" + TimeSince.timeSince() + " ms)");
		for(int i = 0 ; i < hm.getWidth() - 1 ; i++)
		{
			for(int j = 0 ; j < hm.getHeight() - 1 ; j++)
			{
				img.setRGB(i, j, getColor(255, (int)(map[i][j] * 255), (int)(map[i][j] * 255), (int)(map[i][j] * 255)));
			}
		}
		
		try
		{
			Log.log("Écriture de l'image sur disque (" + TimeSince.timeSince() + " ms)");
			ImageIO.write(img, "png", f);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static int getColor(int a, int r, int g, int b)
	{
		return (a << 24) | (r << 16) | (g << 8) | b;
	}
}
