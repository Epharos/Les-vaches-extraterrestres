package fr.loubetrey.render;

import org.lwjgl.opengl.GL11;

import fr.loubetrey.material.Material;
import fr.loubetrey.utils.Color;

public class RenderCube implements Render
{
	public void render(Material m, boolean U, boolean D, boolean S, boolean N, boolean W, boolean E, double h) 
	{	
		GL11.glPushMatrix();
		
		Color c = m.getColor((float) h);
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glColor4f(c.red, c.green, c.blue, m.equals(Material.water) ? .4f : 1);
			if(U)
			{
				GL11.glVertex3f(1.0f, 1.0f, -1.0f);
				GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
				GL11.glVertex3f(1.0f, 1.0f, 1.0f);
			}
			
			if(D) 
			{
				GL11.glVertex3f(1.0f, -1.0f, 1.0f);
				GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
				GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				GL11.glVertex3f(1.0f, -1.0f, -1.0f);
			}
			
			Color d = Color.light(c, 0.05f);
			
			GL11.glColor4f(d.red, d.green, d.blue, m.equals(Material.water) ? .4f : 1);
			if(S)
			{
				GL11.glVertex3f(1.0f, 1.0f, 1.0f);
				GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
				GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
				GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			}
			
			if(N)
			{
				GL11.glVertex3f(1.0f, -1.0f, -1.0f);
				GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			}
			
			Color f = Color.light(c, -0.02f);
			
			GL11.glColor4f(f.red, f.green, f.blue, m.equals(Material.water) ? .4f : 1);
			
			if(W)
			{
				GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
				GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
			}
			
			if(E)
			{
				GL11.glVertex3f(1.0f, 1.0f, -1.0f);
				GL11.glVertex3f(1.0f, 1.0f, 1.0f);
				GL11.glVertex3f(1.0f, -1.0f, 1.0f);
				GL11.glVertex3f(1.0f, -1.0f, -1.0f);
			}
		}
		
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
}
