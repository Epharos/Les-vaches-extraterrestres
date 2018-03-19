package fr.loubetrey.utils;

public class Color 
{
	public float red, green, blue;
	
	public Color(float r, float g, float b)
	{
		red = r;
		green = g;
		blue = b;
	}
	
	public static Color getColorBetween(Color c1, Color c2, float value)
	{
		float r = c1.red * (1.0f - value) + c2.red * value;
		float g = c1.green * (1.0f - value) + c2.green * value;
		float b = c1.blue * (1.0f - value) + c2.blue * value;
		
		return new Color(r, g, b);
	}
	
	public static Color light(Color c, float f)
	{
		return new Color(c.red + f, c.green + f, c.blue + f);
	}
}
