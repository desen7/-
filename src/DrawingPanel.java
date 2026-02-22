import animation.AnimationController;
import java.awt.*;
import javax.swing.*;
import models.*;
import utils.ColorPalette;

public class DrawingPanel extends JPanel {
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 600;
    private final int GROUND_LEVEL = 400;
    private final int TIMER_DELAY = 50;

    private Sky sky;
    private Ground ground;
    private Sun sun;
    private House house;
    private Tree tree;
    private Cloud[] clouds;
    private AnimationController animationController;

    public DrawingPanel() {
        initializeComponents();
        setupPanel();
        setupAnimation();
    }

    private void initializeComponents() {
        sky = new Sky(BACKGROUND_WIDTH, GROUND_LEVEL);
        ground = new Ground(BACKGROUND_WIDTH, BACKGROUND_HEIGHT, GROUND_LEVEL);
        sun = new Sun(400, 500, 40, ColorPalette.SUN_YELLOW);
        house = new House(300, 300, 150, 120);
        tree = new Tree(500, 400);

        clouds = new Cloud[] {
                new Cloud(100, 80, 80, 40, 1),
                new Cloud(400, 60, 100, 45, 2),
                new Cloud(650, 90, 70, 35, 1)
        };
    }

    private void setupPanel() {
        setPreferredSize(new Dimension(BACKGROUND_WIDTH, BACKGROUND_HEIGHT));
        setBackground(Color.WHITE);
    }

    private void setupAnimation() {
        Drawable[] animatedObjects = { sun, clouds[0], clouds[1], clouds[2] };
        animationController = new AnimationController(TIMER_DELAY, animatedObjects, BACKGROUND_WIDTH, this);
        animationController.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawScene(g2d);
    }

    private void drawScene(Graphics2D g2d) {
        sky.draw(g2d);
        sun.draw(g2d);

        for (Cloud cloud : clouds) {
            cloud.draw(g2d);
        }

        ground.draw(g2d);
        house.draw(g2d);
        tree.draw(g2d);

        drawText(g2d);
    }

    private void drawText(Graphics2D g2d) {
        g2d.setColor(ColorPalette.TEXT_BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Красивый загородный пейзаж", 280, 50);

        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        g2d.drawString("ООП реализация с анимацией", 300, 80);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Анимированный пейзаж - ООП реализация");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            DrawingPanel panel = new DrawingPanel();
            frame.add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}