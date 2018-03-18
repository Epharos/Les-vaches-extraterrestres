package fr.loubetrey.material;

import java.util.ArrayList;

import fr.loubetrey.utils.Log;

public class Material 
{
	public static ArrayList<Material> materials = new ArrayList<Material>();
	public static Material grass,
							dirt,
							stone;
	
	private String name;
	private float[] color = new float[3];
	
	public Material(String n, float r, float g, float b)
	{
		name = n;
		color[0] = r;
		color[1] = g;
		color[2] = b;
		Material.materials.add(this);
		Log.log("Enregistrement d'un material (" + n + ")", "Material", false);
	}
	
	public String getName()
	{
		return name;
	}
	
	public float[] getColor()
	{
		return color;
	}
	
	public static final void registerMaterials()
	{
		grass = new Material("grass", 0, 1, 0);
		dirt = new Material("dirt", 0.5f, 0.33f, 0.2f);
		stone = new Material("stone", .5f, .5f, .5f);
	}
}
