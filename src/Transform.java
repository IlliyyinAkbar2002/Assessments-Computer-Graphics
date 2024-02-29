import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
public class Transform extends JPanel{

    private static final int SUN_RADIUS = 50;
    private static final int PLANET_RADIUS = 10;
    private static final int ORBIT_RADIUS = 200;
    private static final double ROTATION_SPEED = 2 * Math.PI / 365;
    private double angle = 0;

    public Transform() {
        setPreferredSize(new Dimension(2 * (ORBIT_RADIUS + SUN_RADIUS), 2 * (ORBIT_RADIUS + SUN_RADIUS)));
        new Timer(100, e -> {
            angle += ROTATION_SPEED;
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int sunX = getWidth() / 2 - SUN_RADIUS;
        int sunY = getHeight() / 2 - SUN_RADIUS;
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(sunX, sunY, 2 * SUN_RADIUS, 2 * SUN_RADIUS);

        int planetX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle) - PLANET_RADIUS);
        int planetY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle) - PLANET_RADIUS);
        g2d.setColor(Color.BLUE);
        g2d.fillOval(planetX, planetY, 2 * PLANET_RADIUS, 2 * PLANET_RADIUS);

        // Draw the point on the planet
        AffineTransform old = g2d.getTransform();
        g2d.rotate(angle, (double) getWidth() / 2, (double) getHeight() / 2);
        g2d.setColor(Color.RED);
        g2d.fillOval(getWidth() / 2 + ORBIT_RADIUS - PLANET_RADIUS, getHeight() / 2, 5, 5);
        g2d.setTransform(old);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Transform());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
