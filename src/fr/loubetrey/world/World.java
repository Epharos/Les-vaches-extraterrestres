package fr.loubetrey.world;

import fr.loubetrey.map.HeightMap;
import fr.loubetrey.material.Material;

public class World 
{
	public final int WIDTH = 256, HEIGHT = 60, LENGTH = 256;
	private Material[][][] map = new Material[WIDTH][HEIGHT][LENGTH];
	
	public World()
	{
		HeightMap hm = new HeightMap(WIDTH, LENGTH, 64, 8);
		
		transformHeightMap(hm);
	}
	
	private void transformHeightMap(HeightMap hm)
	{
		double[][] mapDouble = hm.getMap(0.3);
		
		for(int i = 1 ; i < mapDouble.length - 1; i++)
		{
			for(int j = 0 ; j < mapDouble[0].length - 1 ; j++)
			{
				map[i][(int) (mapDouble[i][j] * HEIGHT)][j] = Material.grass;
				
				for(int k = (int) (mapDouble[i][j] * HEIGHT) + 1 ; k < HEIGHT / 3 ; k++)
					map[i][k][j] = Material.water;
				
				for(int k = (int) (mapDouble[i][j] * HEIGHT) - 1 ; k >= (int) (mapDouble[i][j] * HEIGHT) - 5 ; k--)
					map[i][k][j] = Material.dirt;
				
				for(int k = (int) (mapDouble[i][j] * HEIGHT) - 6 ; k >= 0 ; k--)
					map[i][k][j] = Material.stone;
			}
		}
	}
	
	public Material getMaterialAt(int i, int j, int k)
	{
		try
		{
			return map[i][j][k];
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
