import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MovingHeart extends JPanel{
    private double scale = 1.0;
    private double delta = 0.01;
    private int x = 0;

    public MovingHeart() {
        Timer timer = new Timer(10, e -> {
            scale += delta;
            if (scale > 1.2) {
                delta = -0.01;
            } else if (scale < 1.0) {
                delta = 0.01;
            }
            x += 1;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(x, getHeight() / 2);
        g2.scale(scale, scale);
        g2.setPaint(Color.RED);
        g2.fill(createHeartShape());
    }

    private Shape createHeartShape() {
        GeneralPath heart = new GeneralPath();
        heart.moveTo(0, 0);
        heart.curveTo(50, -50, 150, -50, 200, 0);
        heart.curveTo(200, 100, 150, 200, 100, 250);
        heart.curveTo(50, 200, 0, 100, 0, 0);
        return heart;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new MovingHeart(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
