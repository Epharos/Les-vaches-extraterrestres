package fr.loubetrey.material;

import java.util.ArrayList;
import java.util.Random;

import fr.loubetrey.utils.Color;
import fr.loubetrey.utils.Log;

public class Material 
{
	public static ArrayList<Material> materials = new ArrayList<Material>();
	public static Material grass,
							dirt,
							stone,
							water;
	
	private String name;
	private Color high, low;
	
	private boolean isTransparent = false;
	
	public Material(String n, Color l, Color h)
	{
		name = n;
		high = h;
		low = l;
		Material.materials.add(this);
		Log.log("Enregistrement d'un material (" + n + ")", "Material", false);
	}
	
	public Material setTransparent()
	{
		isTransparent = true;
		return this;
	}
	
	public boolean isTransparent()
	{
		return isTransparent;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Color getColor(float d)
	{
		return Color.getColorBetween(low, high, d);
	}
	
	public static final void registerMaterials()
	{
		grass = new Material("grass", new Color(0, 0.19f, 0), new Color(0, 0.31f, 0));
		dirt = new Material("dirt", new Color(43.0f / 255.0f, 29.f / 255.f, 14.f / 255.f), new Color(82.f / 255.f, 54.f / 255.f, 27.f / 255.f));
		stone = new Material("stone", new Color(0.25f, 0.25f, .25f), new Color(0.75f, 0.75f, 0.75f));
		water = new Material("water", new Color(0, 106.f / 255.f, 209.f / 255.f), new Color(0, 106.f / 255.f, 209.f / 255.f)).setTransparent();
	}
	
	public static Material getRandomMaterial()
	{
		Random r = new Random();
		
		return Material.materials.get(r.nextInt(Material.materials.size()));
	}
	
	public String toString()
	{
		return name;
	}
}
