package fr.loubetrey;

import fr.loubetrey.render.Mesh;
import fr.loubetrey.render.Shader;
import fr.loubetrey.utils.FileLoader;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Rendering 
{		
	static Shader sh;
	
	public static final void init() throws Exception
	{
		sh = new Shader();
		sh.createVertexShader(FileLoader.loadResource("vertex.vs"));
		sh.createFragmentShader(FileLoader.loadResource("fragment.fs"));
		sh.link();
	}
	
	public static final void render(Mesh m)
	{
		sh.bind();

        glBindVertexArray(m.getVaoId());
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glDrawElements(GL_TRIANGLES, m.getVertexCount(), GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glBindVertexArray(0);

        sh.unbind();
	}
	
	public static final void end()
	{
		sh.cleanShader();
	}
}
