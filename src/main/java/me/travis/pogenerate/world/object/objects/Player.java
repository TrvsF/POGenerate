package me.travis.pogenerate.world.object.objects;

import me.travis.pogenerate.util.Pair;
import me.travis.pogenerate.world.object.Object;

import java.awt.image.BufferedImage;

public class Player extends Object {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void setWorldPos(int x, int y) {
        worldPos = Pair.create(x, y);
    }

    @Override
    public Pair<Integer, Integer> getWorldPos() {
        return worldPos;
    }

    @Override
    public String getObjectName() {
        return "PLAYER";
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }
}
