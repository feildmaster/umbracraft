package net.alcuria.umbracraft.layouts;

import net.alcuria.umbracraft.editor.Drawables;
import net.alcuria.umbracraft.modules.AnimationsModule;
import net.alcuria.umbracraft.modules.HeroModule;
import net.alcuria.umbracraft.modules.Module;
import net.alcuria.umbracraft.modules.TilesetsModule;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.widget.VisTextButton;

/** The top-level screen for the editor. Here, all of the {@link Module} classes
 * are added to a left nav.
 * @author Andrew Keturi */
public class EditorLayout extends Layout {

	private final Array<Module<?>> modules;

	public EditorLayout() {
		super();
		modules = new Array<>();
		addModules();
		stage = new Stage();
		//stage.setDebugAll(true);
		Gdx.input.setInputProcessor(stage);
		Table root = new Table();
		root.setFillParent(true);
		final Table menu = new Table();
		content = new Table();
		for (final Module<?> m : modules) {
			menu.add(m.getButton()).row();
			m.getButton().addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					content.clear();
					m.populate(content);
				}
			});
		}
		final ScrollPane scroll = new ScrollPane(content);
		root.add(topnav()).expandX().fill().height(40).padBottom(10).row();
		root.add(new Table() {
			{
				add(menu);
				add(scroll).expand().fill();
			}
		}).expand().fill();
		stage.addActor(root);
	}

	private void addModules() {
		modules.add(new HeroModule());
		modules.add(new TilesetsModule());
		modules.add(new AnimationsModule());
	}

	private Table topnav() {
		return new Table() {
			{
				setBackground(Drawables.get("menu"));
				add(new VisTextButton("Save") {
					{
						addListener(new ClickListener() {
							@Override
							public void clicked(InputEvent event, float x, float y) {
								for (Module<?> m : modules) {
									m.save();
								}
							};
						});
					}
				});
			}
		};
	}

}
