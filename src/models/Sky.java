package models;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import utils.ColorPalette;

public class Sky implements Drawable {
    private final int width;
    private final int height;

    public Sky(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        GradientPaint skyGradient = new GradientPaint(
                0, 0, ColorPalette.SKY_BLUE,
                0, height, ColorPalette.SKY_WHITE
        );
        g2d.setPaint(skyGradient);
        g2d.fillRect(0, 0, width, height);
    }

    @Override
    public void update() {
    }
}