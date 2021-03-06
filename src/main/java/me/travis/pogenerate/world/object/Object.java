package me.travis.pogenerate.world.object;

import me.travis.pogenerate.util.Pair;

import java.awt.image.BufferedImage;

public abstract class Object {

    protected Pair<Integer, Integer> worldPos;

    public Object(int x, int y) {
        System.out.println("creating object at " + x + " " + y);
        worldPos = Pair.create(x, y);
    }

    public Object(Pair<Integer, Integer> pos) {
        worldPos = pos;
    }

    public abstract void setWorldPos(int x, int y);

    public abstract Pair<Integer, Integer> getWorldPos();

    public abstract String getObjectName();

    public abstract BufferedImage getImage();

}
