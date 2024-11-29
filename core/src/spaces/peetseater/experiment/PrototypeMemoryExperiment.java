package spaces.peetseater.experiment;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.LinkedList;

public class PrototypeMemoryExperiment extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture sprite;
	BitmapFont font;
	Memory memory;
	boolean usePrototype;
	LinkedList<NotUsingPrototypeCircle> allInOnes = new LinkedList<>();
	LinkedList<UsingPrototypeCircle> prototypical = new LinkedList<>();
	int maxNumber = 1000000;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Texture("sprite.png");
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.setUseIntegerPositions(true);
		memory = new Memory();
		usePrototype = false;
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean keyUp(int keycode) {
				if (keycode == Input.Keys.SPACE) {
					usePrototype = !usePrototype;
					System.gc();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    createSetOfData();
				}
				if (keycode == Input.Keys.UP) {
					maxNumber *= 10;
				}
				if (keycode == Input.Keys.DOWN) {
					maxNumber /= 10;
				}
				return super.keyUp(keycode);
			}
		});
	}

	private void createSetOfData() {
		allInOnes.clear();
		prototypical.clear();

		if (usePrototype) {
			NotUsingPrototypeCircle proto = new NotUsingPrototypeCircle(0, 0, "Ball", 2);
			for (int i = 0; i < maxNumber; i++) {
				float x = MathUtils.random(0, 640);
				float y = MathUtils.random(0, 480);
				prototypical.add(new UsingPrototypeCircle(x,y, proto));
			}
		} else {
			for (int i = 0; i < maxNumber; i++) {
				float x = MathUtils.random(0, 640);
				float y = MathUtils.random(0, 480);
				allInOnes.add(new NotUsingPrototypeCircle(x, y, "Ball", 2));
			}
		}
	}

	@Override
	public void render () {
		int fps =  Gdx.graphics.getFramesPerSecond();
		float delta = Gdx.graphics.getDeltaTime();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0, 30f, 30f);
		for (NotUsingPrototypeCircle notUsingPrototypeCircle : allInOnes) {
			notUsingPrototypeCircle.update(delta);
			batch.draw(sprite, notUsingPrototypeCircle.getX(), notUsingPrototypeCircle.getY());
		}
		for (UsingPrototypeCircle usingPrototypeCircle : prototypical) {
			usingPrototypeCircle.update(delta);
			batch.draw(sprite, usingPrototypeCircle.getX(), usingPrototypeCircle.getY());
		}

		memory.calculateMemory();

		font.draw(batch, ""+ fps, 500f, 460f);
		font.draw(batch, memory.used() + "MB", 500f, 440f);
		font.draw(batch, "Protomode: " + usePrototype, 500f, 420f);
		font.draw(batch, "Size of P:" +  prototypical.size(), 500, 400f);
		font.draw(batch, "Size of A:" +  allInOnes.size(), 500, 380f);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
