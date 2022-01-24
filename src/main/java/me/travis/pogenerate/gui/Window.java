package me.travis.pogenerate.gui;

import me.travis.pogenerate.world.World;
import me.travis.pogenerate.world.object.Object;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {

    public final int START_PADDING = 5;
    public final int PADDING = 8;

    private final List<Chunk> chunks = new ArrayList<>();

    public Window() {
        SwingUtilities.invokeLater(this::initWindow);
    }

    private void initWindow() {
        refreshWindow();
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("POGenerator");
        getContentPane().setBackground(new Color(0x4F4F4F));
        setVisible(true);
        drawWorld();
    }

    private void refreshWindow() {
        setSize(World.INSTANCE().getWidth() * 8 + 70,
                World.INSTANCE().getHeight() * 8 + 50);
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void drawWorld() {
        int x = START_PADDING;
        int y = START_PADDING;

        for (Object[] objects : World.INSTANCE().getWorld()) {
            for (Object object : objects) {
                Chunk chunk = new Chunk(y, x, object.getImage());
                add(chunk); // adds to jframe (cant remeber why)
                chunks.add(chunk); // adds to own list (to update images)
                x += PADDING;
            }
            y += PADDING;
            x = START_PADDING;
        }
    }

    public void redrawWorld() {
        int c = -1;
        for (Object[] objects : World.INSTANCE().getWorld()) {
            for (Object object : objects) {
                c++;
                if (chunks.get(c).getImage() == object.getImage()) continue;

                chunks.get(c).updateImage(object.getImage());
                chunks.get(c).repaint();
            }
        }
    }

}
