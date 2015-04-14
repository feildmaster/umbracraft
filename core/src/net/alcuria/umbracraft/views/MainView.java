package net.alcuria.umbracraft.views;

import net.alcuria.umbracraft.modules.HeroModule;
import net.alcuria.umbracraft.modules.Module;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kotcrab.vis.ui.widget.VisTextButton;

public class MainView implements View {

	private Array<Module> modules;
	private Stage stage;
	private Table content;
	
	public MainView() {
		modules = new Array<Module>();
		modules.add(new HeroModule());
		stage = new Stage();
		stage.setDebugAll(true);
		Gdx.input.setInputProcessor(stage);
		Table root = new Table();
		root.setFillParent(true);
		final Table menu = new Table();
		content = new Table();
		for (final Module m : modules){
			menu.add(m.getButton()).row();
			m.getButton().addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					content.clear();
					m.populate(content);
				}
			});
		}
		root.add(topnav()).expandX().fill().height(20).row();
		root.add(new Table(){
			{
				add(menu);
				add(content).expand().fill();
				
			}
		}).expand().fill();
		stage.addActor(root);
	}
	
	private Table topnav(){
		return new Table(){
			{
				add(new VisTextButton("Save"){
					{
						addListener(new ClickListener(){
							public void clicked(InputEvent event, float x, float y) {
								for (Module m : modules){
									m.save();
								}
							};
						});
					}
				});
			}
		};
	}
	
	@Override
	public void update(float delta) {
		stage.act();
	}

	@Override
	public void render() {
		stage.draw();
	}

}
