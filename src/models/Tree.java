package models;

import java.awt.Graphics2D;
import utils.ColorPalette;

public class Tree implements Drawable {
    private final int x;
    private final int y;

    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawTrunk(g2d);
        drawCrown(g2d);
    }

    private void drawTrunk(Graphics2D g2d) {
        g2d.setColor(ColorPalette.TREE_TRUNK);
        g2d.fillRect(x, y, 20, 60);
    }

    private void drawCrown(Graphics2D g2d) {
        g2d.setColor(ColorPalette.TREE_CROWN);
        g2d.fillOval(x - 25, y - 40, 70, 60);
        g2d.fillOval(x - 15, y - 60, 50, 50);
        g2d.fillOval(x - 20, y - 50, 60, 55);
    }

    @Override
    public void update() {
    }
}