package me.travis.pogenerate.world;

import me.travis.pogenerate.util.Common;
import me.travis.pogenerate.util.Pair;
import me.travis.pogenerate.world.object.Object;
import me.travis.pogenerate.world.object.objects.None;

public class World {

    static private World instance;

    private Object[][] world;

    private int width;
    private int height;

    public static World INSTANCE() {
        if (instance == null)
            instance = new World();
        return instance;
    }

    public World() {
        width = 160;
        height = 110;
        createWorld();
    }

    public void setNewWorldSize(int w, int h) {
        width = w;
        height = h;
        createWorld();
    }

    private void createWorld() {
        world = new Object[width][];
        for (int i = 0; i < width; i++)
        {
            world[i] = new Object[height];
            for (int j = 0; j < height; j++)
            {
                world[i][j] = new None(Common.coordsToGame(Pair.create(i, j)));
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Object[][] getWorld() {
        return world;
    }

}
