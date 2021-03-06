package net.alcuria.umbracraft.engine.screens;

import net.alcuria.umbracraft.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/** A screen to load all assets.
 * @author Andrew Keturi */
public class Loading implements UmbraScreen {

	@Override
	public void dispose() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void render(float delta) {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void resume() {

	}

	@Override
	public void show() {
		Game.assets().load("tiles/debug.png", Texture.class);
		Game.assets().load("sprites/andoru.png", Texture.class);
		Game.assets().load("sprites/shadow.png", Texture.class);
		Game.assets().load("sprites/animations/animtest.png", Texture.class);
		Game.assets().load("fonts/message.fnt", BitmapFont.class);
	}

	@Override
	public void update(float delta) {
		if (Game.assets().update()) {
			Game.setScreen(new World());
		}
	}

}
