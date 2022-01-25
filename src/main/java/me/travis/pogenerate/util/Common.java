package me.travis.pogenerate.util;

import me.travis.pogenerate.POGenerate;
import me.travis.pogenerate.world.World;

public class Common {

    public static int coordToGame(int i) {
        return (i * 16) + 16;
    }

    public static Pair<Integer, Integer> coordsToGame(Pair<Integer, Integer> coords) {
        return Pair.create(coordToGame(coords.getElement1()), coordToGame(coords.getElement2()));
    }

    public static int mouseToGui(int i) {
        return (i - POGenerate.Window.START_PADDING) / 8; // 8*8 is the image size
    }

    public static Pair<Integer, Integer> mouseToGui(Pair<Integer, Integer> coords) {
        return Pair.create(mouseToGui(coords.getElement1()), mouseToGui(coords.getElement2()));
    }

    public static int mouseToGame(int i) {
        return ((i - POGenerate.Window.START_PADDING) / 8 + 1) * 16;
    }

    public static int gameToCoord(int i) {
        return (i - 16) / 16;
    }

    public static Pair<Integer, Integer> gameToCoords(Pair<Integer, Integer> coords) {
        return Pair.create(gameToCoord(coords.getElement1()), gameToCoord(coords.getElement2()));
    }

    public static boolean canPlacePlayer(int x, int y) {
        if (x + 1 >= World.INSTANCE().getWidth() || y + 1 >= World.INSTANCE().getHeight())
            return false;
        return true;
    }

}
