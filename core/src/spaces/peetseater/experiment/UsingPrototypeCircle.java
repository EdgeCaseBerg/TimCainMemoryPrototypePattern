package spaces.peetseater.experiment;

import com.badlogic.gdx.math.MathUtils;

public class UsingPrototypeCircle {
    private final NotUsingPrototypeCircle prototype;
    private float x;
    private float y;

    public UsingPrototypeCircle(float x, float y, NotUsingPrototypeCircle prototypeCircle) {
        this.prototype = prototypeCircle;
        this.x = x;
        this.y = y;
    }

    public void update(float delta) {
        float dx = MathUtils.random(-2, 2);
        float dy = MathUtils.random(-2, 2);
        this.x += dx * getSpeed() * delta;
        this.y += dy * getSpeed() * delta;
    }

    public String getName() {
        return this.prototype.getName();
    }

    public float getSpeed() {
        return this.prototype.getSpeed();
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }
}
