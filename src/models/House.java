package models;

import java.awt.Graphics2D;
import utils.ColorPalette;

public class House implements Drawable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public House(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawMainBody(g2d);
        drawRoof(g2d);
        drawWindow(g2d);
        drawDoor(g2d);
    }

    private void drawMainBody(Graphics2D g2d) {
        g2d.setColor(ColorPalette.HOUSE_BROWN);
        g2d.fillRect(x, y, width, height);
    }

    private void drawRoof(Graphics2D g2d) {
        int[] xPoints = {x - 20, x + width/2, x + width + 20};
        int[] yPoints = {y, y - 60, y};
        g2d.setColor(ColorPalette.ROOF_BROWN);
        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    private void drawWindow(Graphics2D g2d) {
        g2d.setColor(ColorPalette.WINDOW_BLUE);
        g2d.fillRect(x + 30, y + 40, 40, 40);
        g2d.setColor(ColorPalette.TEXT_BLACK);
        g2d.drawRect(x + 30, y + 40, 40, 40);
        g2d.drawLine(x + 50, y + 40, x + 50, y + 80);
        g2d.drawLine(x + 30, y + 60, x + 70, y + 60);
    }

    private void drawDoor(Graphics2D g2d) {
        g2d.setColor(ColorPalette.DOOR_BROWN);
        g2d.fillRect(x + width - 60, y + height - 80, 30, 60);
        g2d.setColor(ColorPalette.SUN_YELLOW);
        g2d.fillOval(x + width - 45, y + height - 50, 5, 5);
    }

    @Override
    public void update() {
    }
}