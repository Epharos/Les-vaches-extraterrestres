package fr.loubetrey.render;

import org.lwjgl.opengl.GL11;

import fr.loubetrey.material.Material;

public class RenderCube implements Render
{
	public void render(Material m) 
	{	
		GL11.glPushMatrix();
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glColor3f(0, 1f; 0);
			GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			GL11.glColor3f(0.3f, 1f; 0.3f);
			GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
			GL11.glColor3f(0.05f, 0.8f; 0.1f);
			GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
			GL11.glColor3f(0, 0.8f; 0);
			GL11.glVertex3f(1.0f, 1.0f, 1.0f);
			
			GL11.glColor3f(0, 1f; 0);
			GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			GL11.glColor3f(0.3f, 1f; 0.3f);
			GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
			GL11.glColor3f(0.05f, 0.8f; 0.1f);
			GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
			GL11.glColor3f(0, 0.8f; 0);
			GL11.glVertex3f(1.0f, -1.0f, -1.0f);
			
			GL11.glColor3f(0, 1f; 0);
			GL11.glVertex3f(1.0f, 1.0f, 1.0f);
			GL11.glColor3f(0.3f, 1f; 0.3f);
			GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
			GL11.glColor3f(0.05f, 0.8f; 0.1f);
			GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
			GL11.glColor3f(0, 0.8f; 0);
			GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			
			GL11.glColor3f(0, 1f; 0);
			GL11.glVertex3f(1.0f, -1.0f, -1.0f);
			GL11.glColor3f(0.3f, 1f; 0.3f);
			GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
			GL11.glColor3f(0.05f, 0.8f; 0.1f);
			GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
			GL11.glColor3f(0, 0.8f; 0);
			GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			
			GL11.glColor3f(0, 1f; 0);
			GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
			GL11.glColor3f(0.3f, 1f; 0.3f);
			GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
			GL11.glColor3f(0.05f, 0.8f; 0.1f);
			GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
			GL11.glColor3f(0, 0.8f; 0);
			GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
			
			GL11.glColor3f(0, 1f; 0);
			GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			GL11.glColor3f(0.3f, 1f; 0.3f);
			GL11.glVertex3f(1.0f, 1.0f, 1.0f);
			GL11.glColor3f(0.05f, 0.8f; 0.1f);
			GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			GL11.glColor3f(0, 0.8f; 0);
			GL11.glVertex3f(1.0f, -1.0f, -1.0f);
		}
		
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
}
