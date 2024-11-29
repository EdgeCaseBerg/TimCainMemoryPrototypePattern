package spaces.peetseater.experiment;

import com.badlogic.gdx.math.MathUtils;

public class NotUsingPrototypeCircle {
    private float x;
    private float y;
    private final String name;
    private final float speed;

    public NotUsingPrototypeCircle(float x, float y, String name, float speed) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.speed = speed;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public void update(float delta) {
        float dx = MathUtils.random(-2, 2);
        float dy = MathUtils.random(-2, 2);
        this.x += dx * speed * delta;
        this.y += dy * speed * delta;
    }

    public float getSpeed() {
        return speed;
    }
}
