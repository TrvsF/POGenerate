package me.travis.pogenerate.world.object.objects;

import me.travis.pogenerate.POGenerate;
import me.travis.pogenerate.util.Pair;
import me.travis.pogenerate.world.object.Object;

import java.awt.image.BufferedImage;

public class Wall extends Object {

    public Wall(Pair<Integer, Integer> coords) {
        super(coords);
    }

    public Wall(int x, int y) {
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
        return "WALL";
    }

    @Override
    public BufferedImage getImage() {
        return POGenerate.WallImage;
    }
}
