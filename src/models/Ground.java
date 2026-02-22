package models;

import java.awt.Graphics2D;
import utils.ColorPalette;

public class Ground implements Drawable {
    private final int width;
    private final int height;
    private final int groundLevel;

    public Ground(int width, int height, int groundLevel) {
        this.width = width;
        this.height = height;
        this.groundLevel = groundLevel;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(ColorPalette.GRASS_GREEN);
        g2d.fillRect(0, groundLevel, width, height - groundLevel);

        drawGrass(g2d);
    }

    private void drawGrass(Graphics2D g2d) {
        g2d.setColor(ColorPalette.DARK_GREEN);
        for (int i = 0; i < width; i += 4) {
            int grassHeight = (int)(Math.random() * 8) + 2;
            g2d.drawLine(i, groundLevel, i, groundLevel - grassHeight);
        }
    }

    @Override
    public void update() {
    }
}