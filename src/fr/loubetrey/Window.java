package fr.loubetrey;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

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
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		glfwWindowHint(GLFW_SAMPLES, 4);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

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
		GL.createCapabilities();
	}
	
	private void loop() 
	{
		GL.createCapabilities();
		
		glViewport(0, 0, width, height);
		
		glEnable(GL_DEPTH_TEST);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glEnable( GL_BLEND );
		
		glMatrixMode(GL11.GL_PROJECTION);
		glLoadIdentity();
		glFrustum (-0.1333, 0.1333, -0.1, 0.1, 0.5, 5000.0); 
		glMatrixMode(GL11.GL_MODELVIEW);

		glClearColor(0.7f, 1f, 1f, 1f);
		
		double last = glfwGetTime();
		int frames = 0;
		double current = glfwGetTime();

		while (!glfwWindowShouldClose(windowID)) 
		{
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			glLoadIdentity();
			
			current = glfwGetTime();
			frames++;
			
			if(current > last + 1.0)
			{
				Log.log(frames, "FPS", false);
				last += 1.0;
				frames = 0;
			}
			
			Rendering.render();
						
			glfwSwapBuffers(windowID);

			glfwPollEvents();
		}
	}
}
