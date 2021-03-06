package net.alcuria.umbracraft.engine.entities;

import net.alcuria.umbracraft.engine.components.BaseComponent;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/** A top-level game object. Players, enemies, decorations, and so on, all should
 * be instantiated as GameObjects with logic separated out in the
 * {@link BaseComponent}.
 * @author Andrew Keturi */
public class Entity {

	public int altitude;
	private final Array<BaseComponent> components;
	public Vector2 desiredPosition;
	public Vector2 position;
	public Vector2 velocity;

	public Entity() {
		components = new Array<BaseComponent>();
		position = new Vector2();
		velocity = new Vector2();
		desiredPosition = new Vector2();
	}

	public Entity(BaseComponent... components) {
		this();
		for (BaseComponent component : components) {
			component.create();
			this.components.add(component);
		}
	}

	/** Adds a single component after instantiation
	 * @param component the component to add */
	public void addComponent(BaseComponent component) {
		component.create();
		components.add(component);
	}

	public void dispose() {
		for (int i = 0; i < components.size; i++) {
			components.get(i).dispose();
		}
	}

	public void render() {
		for (int i = 0; i < components.size; i++) {
			components.get(i).render(this);
		}
	}

	public void update(float delta) {
		for (int i = 0; i < components.size; i++) {
			components.get(i).update(this);
		}
	}
}
