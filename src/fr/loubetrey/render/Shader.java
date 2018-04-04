package fr.loubetrey.render;

import static org.lwjgl.opengl.GL20.*;
import fr.loubetrey.utils.Log;

public class Shader
{
	private final int programId;
	private int vertexId, fragmentId;
	
	public Shader()
	{
		programId = glCreateProgram();
		
		if(programId == 0)
			Log.log("Impossible de créer le programme !", "Shader", true);
	}
	
	public int createShader(String code, int shaderCode)
	{
		int shaderId = glCreateShader(shaderCode);
		
		if(shaderId == 0)
		{
			Log.log("Impossible de créer le shader !", "Shader", true);
			return 0;
		}
		
		glShaderSource(shaderId, code);
		glCompileShader(shaderId);
		
		if(glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0)
			Log.log("Problème à la compilation du shader " + glGetShaderInfoLog(shaderId, 1024), "Shader", true);
		
		glAttachShader(programId, shaderId);
		
		return shaderId;
	}
	
	public void createVertexShader(String code)
	{
		vertexId = createShader(code, GL_VERTEX_SHADER);
	}
	
	public void createFragmentShader(String code)
	{
		fragmentId = createShader(code, GL_FRAGMENT_SHADER);
	}
	
	public void link()
	{
		glLinkProgram(programId);
		
		if(glGetProgrami(programId, GL_LINK_STATUS) == 0)
			Log.log("Problème lors de la création du lien " + glGetProgramInfoLog(programId, 1024), "Shader", true);
		
		if(vertexId != 0)
			glDetachShader(programId, vertexId);
		
		if(fragmentId != 0)
			glDetachShader(programId, fragmentId);
		
		glValidateProgram(programId);
		
		if(glGetProgrami(programId, GL_VALIDATE_STATUS) == 0)
			Log.log("Problème lors de la validation du programme " + glGetProgramInfoLog(programId, 1024), "Shader", true);
	}
	
	public void bind()
	{
		glUseProgram(programId);
	}
	
	public void unbind()
	{
		glUseProgram(0);
	}
	
	public void cleanShader()
	{
		unbind();
		
		if(programId != 0)
			glDeleteProgram(programId);
	}
}