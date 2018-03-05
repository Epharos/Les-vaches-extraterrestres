package fr.loubetrey.map;

public class HeightMap
{
	int step, octave, width, height;
	double[][] values;
	
	public HeightMap(int w, int h, int s, int o)
	{
		width = w;
		height = h;
		step = s;
		octave = o;
		
		int maxWidth = (int) Math.ceil(width * Math.pow(2, octave - 1) / step);
		int maxHeight = (int) Math.ceil(height * Math.pow(2, octave - 1) / step);
		
		values = new double[maxWidth][maxHeight];
		
		for(int i = 0 ; i < maxWidth ; i++)
		{
			for(int j = 0 ; j < maxHeight ; j++)
			{
				values[i][j] = Math.random();
			}
		}
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public double[][] getMap(double persistance)
	{
		double[][] map = new double[width][height];
		
		for(int i = 0 ; i < width - 1 ; i++)
		{
			for(int j = 0 ; j < height - 1 ; j++)
			{
				map[i][j] = sum(i, j, persistance);
			}
		}
		return map;
	}
	
	double interpolation(double i, double j, double x)
	{
		double k = (1 - Math.cos(x * Math.PI)) / 2;
		return i * (1 - k) + j * k;
	}
	
	double interpolation(double i, double j, double a, double b, double x, double y)
	{
		double m = interpolation(i, j, x);
		double n = interpolation(a, b, x);
		return interpolation(m, n, y);
	}
	
	double getValueAt(int i, int j)
	{
		return values[i][j];
	}
	
	double perlin(double x, double y)
	{
		int i = (int) (x / step);
		int j = (int) (y / step);
		
		return interpolation(getValueAt(i, j), getValueAt(i + 1, j), getValueAt(i, j + 1), getValueAt(i + 1, j + 1), (x / step) % 1, (y / step) % 1);
	}
	
	double sum(double x, double y, double persistance)
	{
		double sum = 0;
		double p = 1;
		int f = 1;
		
		for(int i = 0 ; i < octave ; i++)
		{
			sum += p * perlin(x * f, y * f);
			p *= persistance;
			f *= 2;
		}
		
		return sum * (1 - persistance) / (1 - p);
	}
}
