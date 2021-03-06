package net.alcuria.umbracraft;

import net.alcuria.umbracraft.editor.Drawables;
import net.alcuria.umbracraft.layouts.EditorLayout;
import net.alcuria.umbracraft.layouts.Layout;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kotcrab.vis.ui.VisUI;

/** The editor.
 * @author Andrew Keturi */
public class UmbraCraftEditor implements ApplicationListener {

	private SpriteBatch batch;
	private Layout view;

	@Override
	public void create() {
		VisUI.load();
		Drawables.init();
		batch = new SpriteBatch();
		view = new EditorLayout();
	}

	@Override
	public void dispose() {
		VisUI.dispose();
		batch.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		view.update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		view.render(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
