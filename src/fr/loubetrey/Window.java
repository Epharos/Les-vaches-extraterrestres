package fr.loubetrey;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import fr.loubetrey.material.Material;
import fr.loubetrey.render.RenderCube;
import fr.loubetrey.utils.Log;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Window 
{
	private long windowID;
	private int width, height;
	
	public void run(int w, int h)
	{
		Log.log("LWJGL " + Version.getVersion());
		width = w;
		height = h;
		
		init("Les vaches extraterrestres");
		loop();
		
		glfwFreeCallbacks(windowID);
		glfwDestroyWindow(windowID);

		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
	
	private void init(String name) 
	{
		Log.log("Création de la fenêtre");
		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

		windowID = glfwCreateWindow(width, height, name, NULL, NULL);
		if (windowID == NULL)
			throw new RuntimeException("Failed to create the GLFW window");

		glfwSetKeyCallback(windowID, (window, key, scancode, action, mods) -> 
		{
			if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
				glfwSetWindowShouldClose(window, true);
		});

		try (MemoryStack stack = stackPush()) 
		{
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);

			glfwGetWindowSize(windowID, pWidth, pHeight);

			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			glfwSetWindowPos(
				windowID,
				(vidmode.width() - pWidth.get(0)) / 2,
				(vidmode.height() - pHeight.get(0)) / 2
			);
		}
		
		glfwMakeContextCurrent(windowID);
		glfwSwapInterval(1);

		glfwShowWindow(windowID);
	}
	
	private float d = 0;

	private void loop() 
	{
		GL.createCapabilities();
		
		glViewport(0, 0, width, height);
		
		glEnable(GL_DEPTH_TEST);
		
		glMatrixMode(GL11.GL_PROJECTION);
		glLoadIdentity();
		glFrustum (-0.1333, 0.1333, -0.1, 0.1, 0.5, 25.0); 
		glMatrixMode(GL11.GL_MODELVIEW);

		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

		while (!glfwWindowShouldClose(windowID)) 
		{
			d += 0.0002f;
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			glLoadIdentity();
			
			glTranslatef(0, 0, -d);
			glRotatef(d % 360, 0, 1, 0);
			
			// ICI
			
			RenderCube rc = new RenderCube();
			
			for(int i = 0 ; i < 10 ; i++)
			{
				for(int j = 0 ; j < 10 ; j++)
				{
					rc.render(Material.grass);
					glTranslatef(1, 0, 0);
				}
				glTranslatef(0, 0, 1);
			}
			
			glfwSwapBuffers(windowID);

			glfwPollEvents();
		}
	}
}
