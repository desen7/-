package models;

import java.awt.Color;
import java.awt.Graphics2D;
import utils.ColorPalette;

public class Sun implements Drawable {
    private int x;
    private int y;
    private final int radius;
    private final Color color;
    private int position = 0;
    private boolean rising = true;

    public Sun(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawSunRays(g2d);
        drawSunBody(g2d);
    }

    private void drawSunBody(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    private void drawSunRays(Graphics2D g2d) {
        g2d.setColor(ColorPalette.SUN_YELLOW);
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30);
            int startX = x + (int)(radius * Math.cos(angle));
            int startY = y + (int)(radius * Math.sin(angle));
            int endX = x + (int)((radius + 20) * Math.cos(angle));
            int endY = y + (int)((radius + 20) * Math.sin(angle));
            g2d.drawLine(startX, startY, endX, endY);
        }
    }

    @Override
    public void update() {
        if (rising) {
            position += 2;
            if (position > 180) {
                rising = false;
            }
        } else {
            position -= 2;
            if (position < 0) {
                rising = true;
            }
        }

        double angle = Math.toRadians(position);
        this.x = 200 + (int)(200 * Math.cos(angle));
        this.y = 500 - (int)(300 * Math.sin(angle));
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setPosition(int position) { this.position = position; }
    public boolean isRising() { return rising; }
}