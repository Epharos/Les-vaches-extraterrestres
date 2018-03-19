package fr.loubetrey;

import static org.lwjgl.opengl.GL11.*;

import fr.loubetrey.render.RenderCube;

public class Rendering 
{		
	private static int d = 0;
	static RenderCube rc = new RenderCube();
	
	public static final void render()
	{
//		d++;
		glTranslatef(-50, 2f * Game.getInstance().getWorld().HEIGHT, -8 * Game.getInstance().getWorld().LENGTH);
		glRotatef(30, 1, 0, 0);
		glRotatef(-38 + d, 0, 1, 0);
		glRotatef(0, 0, 0, 1);
		
		for(int i = 0 ; i < Game.getInstance().getWorld().WIDTH ; i++)
		{
			for(int j = 0 ; j < Game.getInstance().getWorld().HEIGHT ; j++)
			{
				for(int k = 0 ; k < Game.getInstance().getWorld().LENGTH ; k++)
				{
					if(Game.getInstance().getWorld().getMaterialAt(i, j, k) != null)
					{
						rc.render(Game.getInstance().getWorld().getMaterialAt(i, j, k), 
								Game.getInstance().getWorld().getMaterialAt(i, j + 1, k) == null || Game.getInstance().getWorld().getMaterialAt(i, j + 1, k).isTransparent(),
								Game.getInstance().getWorld().getMaterialAt(i, j - 1, k) == null || Game.getInstance().getWorld().getMaterialAt(i, j - 1, k).isTransparent(),
								Game.getInstance().getWorld().getMaterialAt(i, j, k + 1) == null || Game.getInstance().getWorld().getMaterialAt(i, j, k + 1).isTransparent(),
								Game.getInstance().getWorld().getMaterialAt(i, j, k - 1) == null || Game.getInstance().getWorld().getMaterialAt(i, j, k - 1).isTransparent(),
								Game.getInstance().getWorld().getMaterialAt(i - 1, j, k) == null || Game.getInstance().getWorld().getMaterialAt(i - 1, j, k).isTransparent(),
								Game.getInstance().getWorld().getMaterialAt(i + 1, j, k) == null || Game.getInstance().getWorld().getMaterialAt(i + 1, j, k).isTransparent(), (double)j / (double)Game.getInstance().getWorld().HEIGHT);
						
//						rc.render(Game.getInstance().getWorld().getMaterialAt(i, j, k), 
//								true, // U
//								true, // E
//								true, // D
//								true, // W
//								true, // S
//								true // N
//								);
					}
					
					glTranslatef(0, 0, 2);
				}
				glTranslatef(0, 2, -2 * Game.getInstance().getWorld().LENGTH);
			}
			glTranslatef(2, -2 * Game.getInstance().getWorld().HEIGHT, 0);
		}
	}
}
