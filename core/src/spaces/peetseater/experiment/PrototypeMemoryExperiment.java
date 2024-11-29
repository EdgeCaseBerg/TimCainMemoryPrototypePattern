package spaces.peetseater.experiment;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PrototypeMemoryExperiment extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture sprite;
	BitmapFont font;
	Memory memory;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Texture("sprite.png");
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.setUseIntegerPositions(true);
		memory = new Memory();
	}

	@Override
	public void render () {
		int fps =  Gdx.graphics.getFramesPerSecond();
		memory.calculateMemory();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(sprite, 320, 240);
		font.draw(batch, ""+ fps, 500f, 460f);
		font.draw(batch, memory.used() + "MB", 500f, 440f);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
