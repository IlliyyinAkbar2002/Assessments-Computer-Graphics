import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Rectangle_rounded extends JPanel {

    private double scale = 1.0;
    private double delta = 0.01;
    private int x = 0;

    // Create Rectangle with rounded corners
    private Shape createRoundedRectangle() {
        float x = 50;
        float y = 50;
        float w = 100;
        float h = 100;
        float arc = 20;
        return new RoundRectangle2D.Float(x, y, w, h, arc, arc);
    }

    public Rectangle_rounded() {
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
        g2.fill(createRoundedRectangle());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new Rectangle_rounded(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
