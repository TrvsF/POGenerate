package me.travis.pogenerate.util;

public class Common {

    public static int coordToGame(int i){
        return (i * 16) + 16;
    }

    public static Pair<Integer, Integer> coordsToGame(Pair<Integer, Integer> coords) {
        return Pair.create(coordToGame(coords.getElement1()), coordToGame(coords.getElement2()));
    }

}
