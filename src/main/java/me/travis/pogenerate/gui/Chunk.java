package me.travis.pogenerate.gui;

import me.travis.pogenerate.POGenerate;
import me.travis.pogenerate.util.Common;
import me.travis.pogenerate.world.World;
import me.travis.pogenerate.world.object.objects.None;
import me.travis.pogenerate.world.object.objects.Player;
import me.travis.pogenerate.world.object.objects.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Chunk extends JPanel implements MouseListener {

    private BufferedImage image;

    public Chunk(int x, int y, BufferedImage img) {
        setOpaque(false);
        image = img;
        setPos(x, y);
        addMouseListener(this);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void updateImage(BufferedImage img) {
        image = img;
    }

    /**
     * sets squares pos on screen
     * @param x X
     * @param y Y
     */
    private void setPos(int x, int y) {
        setBounds(x, y, 8, 8);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this);
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e Event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(Common.mouseToGame(getX()) + " " + Common.mouseToGame(getY()));
        switch (e.getButton()) {
            case 1: // m1 TODO : MAKE PLAYER 2x2
                int x = Common.mouseToGui(getX());
                int y = Common.mouseToGui(getY());

                World.INSTANCE().getWorld()[x][y]
                        = new Player(Common.mouseToGame(getX()), Common.mouseToGame(getY()));
                POGenerate.Window.redrawWorld();
                break;
            case 2: // m3
                World.INSTANCE().getWorld()[Common.mouseToGui(getX())][Common.mouseToGui(getY())]
                        = new None(Common.mouseToGame(getX()), Common.mouseToGame(getY()));
                POGenerate.Window.redrawWorld();
                break;
            case 3: // m2
                World.INSTANCE().getWorld()[Common.mouseToGui(getX())][Common.mouseToGui(getY())]
                        = new Wall(Common.mouseToGame(getX()), Common.mouseToGame(getY()));
                POGenerate.Window.redrawWorld();
                break;
        }
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e Event
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e Event
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e Event
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

}
