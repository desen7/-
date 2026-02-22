package animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.Drawable;

public class AnimationController {
    private final Timer timer;
    private final Drawable[] animatedObjects;
    private final int sceneWidth;
    private final JPanel drawingPanel;

    public AnimationController(int delay, Drawable[] animatedObjects, int sceneWidth, JPanel drawingPanel) {
        this.animatedObjects = animatedObjects;
        this.sceneWidth = sceneWidth;
        this.drawingPanel = drawingPanel;
        this.timer = new Timer(delay, new AnimationHandler());
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    private class AnimationHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Drawable obj : animatedObjects) {
                obj.update();
            }
            handleCloudBoundaries();
            drawingPanel.repaint();
        }

        private void handleCloudBoundaries() {
            for (Drawable obj : animatedObjects) {
                if (obj instanceof models.Cloud) {
                    models.Cloud cloud = (models.Cloud) obj;
                    if (cloud.getX() > sceneWidth) {
                        cloud.resetPosition(-cloud.getWidth());
                    }
                }
            }
        }
    }
}