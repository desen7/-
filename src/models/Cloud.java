package models;

import java.awt.Graphics2D;
import utils.ColorPalette;

public class Cloud implements Drawable {
    private int x;
    private final int y;
    private final int width;
    private final int height;
    private final int speed;

    public Cloud(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(ColorPalette.CLOUD_WHITE);
        g2d.fillOval(x, y, width, height);
        g2d.fillOval(x + 15, y - 10, width - 10, height - 5);
        g2d.fillOval(x + 30, y, width - 15, height);
        g2d.fillOval(x - 10, y + 5, width - 10, height - 10);
    }

    @Override
    public void update() {
        this.x += speed;
    }

    public void resetPosition(int newX) {
        this.x = newX;
    }

    public int getX() { return x; }
    public int getWidth() { return width; }
}