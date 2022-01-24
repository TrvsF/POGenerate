package me.travis.pogenerate.util;

import me.travis.pogenerate.POGenerate;

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

}
