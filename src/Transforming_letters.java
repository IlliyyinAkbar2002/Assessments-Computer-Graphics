import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Transforming_letters extends JFrame {

//    Transforming letter D to C
    public Transforming_letters(){
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        // Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a shape for letter D
        Shape letterD = new Rectangle2D.Double(100, 100, 100, 200);
        Shape letterDPart = new Ellipse2D.Double(100, 100, 100, 200);

        // Create a shape for letter C
        Shape letterC = new Ellipse2D.Double(300, 100, 200, 200);
        Shape letterCPart = new Rectangle2D.Double(400, 100, 100, 200);

        // Draw letter D
        g2d.draw(letterD);
        g2d.draw(letterDPart);

        // Draw letter C
        Area letterCArea = new Area(letterC);
        letterCArea.subtract(new Area(letterCPart));
        g2d.draw(letterCArea);
    }

    public static void main(String[] args) {
        Transforming_letters frame = new Transforming_letters();
        frame.setVisible(true);
    }
}
