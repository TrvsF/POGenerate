package me.travis.pogenerate;

import me.travis.pogenerate.gui.Window;
import me.travis.pogenerate.world.World;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class POGenerate {

    // image loading things
    public static ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    public static BufferedImage NoneImage;
    public static BufferedImage PlayerImage;
    public static BufferedImage WallImage;

    public static Window Window;

    public static void main(String[] args) {
        System.out.println("starting POGenerate...");

        System.out.print("loading images...");
        try {
            NoneImage = ImageIO.read(Objects.requireNonNull(classLoader.getResource("none.png")));
            PlayerImage = ImageIO.read(Objects.requireNonNull(classLoader.getResource("player.png")));
            WallImage = ImageIO.read(Objects.requireNonNull(classLoader.getResource("brick.png")));
        }catch (IOException ioException) {
            System.out.println("\nERROR LOADING IMAGES\n" + ioException);
        }
        System.out.println("done");

        Window = new Window();
    }

}
