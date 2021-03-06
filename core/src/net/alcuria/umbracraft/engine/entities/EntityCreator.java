package net.alcuria.umbracraft.engine.entities;

import net.alcuria.umbracraft.Game;
import net.alcuria.umbracraft.engine.components.AnimationComponent;
import net.alcuria.umbracraft.engine.components.InputComponent;
import net.alcuria.umbracraft.engine.components.PhysicsComponent;
import net.alcuria.umbracraft.engine.events.CameraTargetEvent;
import net.alcuria.umbracraft.engine.map.Map;

import com.badlogic.gdx.Gdx;

/** The EntityCreator is responsible for instantiating various game objects
 * (players, etc) to be used by the {@link EntityManager}
 * @author Andrew Keturi */
public class EntityCreator {

	/** @param map
	 * @return A player {@link Entity} */
	public static Entity player(final Map map) {
		Entity player = new Entity();
		/*
		 * new BaseComponent() { private TextureRegion character; private
		 * TextureRegion shadow;
		 *
		 * @Override public void create() { character = new
		 * TextureRegion(Game.assets( ).get("sprites/andoru.png",
		 * Texture.class), 16, 27); shadow = new TextureRegion
		 * (Game.assets().get("sprites/shadow.png", Texture.class), 16, 16); }
		 *
		 * @Override public void dispose() {
		 *
		 * }
		 *
		 * @Override public void render(Entity object) {
		 * Game.batch().draw(shadow, object.position.x - 1, object.position.y -
		 * 6 + 16 * map.getAltitudeAt(object.position.x / 16, object.position.y
		 * / 16)); Game.batch().draw(character, object.position.x,
		 * object.position.y + object.altitude); }
		 *
		 * @Override public void update(Entity object) {
		 *
		 * } }
		 */
		// input
		final InputComponent input = new InputComponent();
		Gdx.input.setInputProcessor(input);
		player.addComponent(input);
		player.addComponent(new PhysicsComponent(map));
		player.addComponent(new AnimationComponent(Game.db().anim("Spin")));
		Game.publisher().publish(new CameraTargetEvent(player));
		return player;
	}
}
