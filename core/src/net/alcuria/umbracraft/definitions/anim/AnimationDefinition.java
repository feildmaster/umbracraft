package net.alcuria.umbracraft.definitions.anim;

import net.alcuria.umbracraft.definitions.Definition;

import com.badlogic.gdx.utils.Array;

/** Defines an entire animation.
 * @author Andrew Keturi */
public class AnimationDefinition extends Definition {

	/** A friendly name */
	public String name;
	/** Full internal path to texture */
	public String filename;
	/** The frames for the animation. */
	public Array<AnimationFrameDefinition> frames;
	/** Width of a frame */
	public int width;
	/** Height of a frame */
	public int height;
	/** An internal identifier */
	private int id;
	/** Whether or not to hold on last frame */
	public boolean keepLast;
	/** Whether or not it loops */
	public boolean loop;

	/** For serialization */
	public AnimationDefinition() {
	}

	/** Creates a module, setting the ID */
	public AnimationDefinition(int id) {
		this.id = id;
	}

	/** @return the unique id */
	public int getId() {
		return id;
	}
}
