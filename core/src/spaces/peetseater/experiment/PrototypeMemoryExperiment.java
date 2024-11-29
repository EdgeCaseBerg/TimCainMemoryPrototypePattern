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
	BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.setUseIntegerPositions(true);
	}

	@Override
	public void render () {
		int fps =  Gdx.graphics.getFramesPerSecond();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		font.draw(batch, ""+ fps, 500f, 460f);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
