package net.alcuria.umbracraft.engine.components;

import net.alcuria.umbracraft.engine.entities.Entity;

/** A basic component
 * @author Andrew Keturi */
public interface BaseComponent {

	/** To be called to do any initialization needed for the component */
	public void create();

	/** To be called when the component needs to be destroyed */
	public void dispose();

	/** To be called when the component needs to be rendered */
	public void render(Entity object);

	/** To be called when the component needs to be updated */
	public void update(Entity object);
}
