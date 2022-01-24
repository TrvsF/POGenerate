package me.travis.pogenerate.world.object;

import me.travis.pogenerate.util.Pair;

import java.awt.image.BufferedImage;

public abstract class Object {

    protected Pair<Integer, Integer> worldPos;

    public Object(int x, int y)
    {
        worldPos = Pair.create(x, y);
    }

    public abstract void setWorldPos(int x, int y);

    public abstract Pair<Integer, Integer> getWorldPos();

    public abstract String getObjectName();

    public abstract BufferedImage getImage();

}
