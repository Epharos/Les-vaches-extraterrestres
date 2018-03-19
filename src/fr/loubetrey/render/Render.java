package fr.loubetrey.render;

import fr.loubetrey.material.Material;

public interface Render 
{
	public void render(Material m, boolean N, boolean S, boolean E, boolean W, boolean U, boolean D, double d);
}
