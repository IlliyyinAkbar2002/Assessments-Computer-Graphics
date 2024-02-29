import javax.swing.*;
import java.awt.*;

public class SolarSystem extends JPanel{
    private static final int SUN_RADIUS = 50;

    private static final int PLANET_RADIUS = 10;
    private static final int MERCURY_RADIUS = 5;
    private static final int VENUS_RADIUS = 15;
    private static final int EARTH_RADIUS = 10;
    private static final int MARS_RADIUS = 7;
    private static final int JUPITER_RADIUS = 30;
    private static final int SATURN_RADIUS = 25;
    private static final int URANUS_RADIUS = 25;
    private static final int NEPTUNE_RADIUS = 15;

    private static final int ORBIT_RADIUS = 200;
    private static final double ROTATION_SPEED = 2 * Math.PI / 365;

    private double angle = 0;

    public SolarSystem() {
        setPreferredSize(new Dimension(2 * (ORBIT_RADIUS + SUN_RADIUS), 2 * (ORBIT_RADIUS + SUN_RADIUS)));
        new Timer(100, e -> {
            angle += ROTATION_SPEED;
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int sunX = getWidth() / 2 - SUN_RADIUS;
        int sunY = getHeight() / 2 - SUN_RADIUS;
        g.setColor(Color.YELLOW);
        g.fillOval(sunX, sunY, 2 * SUN_RADIUS, 2 * SUN_RADIUS);

//        int planetX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle) - PLANET_RADIUS);
//        int planetY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle) - PLANET_RADIUS);
//
//        g.setColor(Color.BLUE);
//        g.fillOval(planetX, planetY, 2 * PLANET_RADIUS, 2 * PLANET_RADIUS);

//        Planet Mercury
        int mercuryX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle * 4) - MERCURY_RADIUS);
        int mercuryY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle * 4) - MERCURY_RADIUS);
//        Color planet Mercury
        g.setColor(Color.GRAY);
        g.fillOval(mercuryX, mercuryY, 2 * MERCURY_RADIUS, 2 * MERCURY_RADIUS);


//        Planet Venus
        int venusX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle * 3) - VENUS_RADIUS);
        int venusY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle * 3) - VENUS_RADIUS);

//        Color planet Venus
        g.setColor(Color.ORANGE);
        g.fillOval(venusX, venusY, 2 * VENUS_RADIUS, 2 * VENUS_RADIUS);

//        Planet Earth
        int earthX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle * 5) - EARTH_RADIUS);
        int earthY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle * 5) - EARTH_RADIUS);

//        Color planet Earth
        g.setColor(Color.BLUE);
        g.fillOval(earthX, earthY, 2 * EARTH_RADIUS, 2 * EARTH_RADIUS);

        //        Planet Mars
        int marsX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle * 6) - MARS_RADIUS);
        int marsY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle * 6) - MARS_RADIUS);

//        Color planet Mars
        g.setColor(Color.RED);
        g.fillOval(marsX, marsY, 2 * MARS_RADIUS, 2 * MARS_RADIUS);

        //        Planet Jupiter
        int jupiterX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle * 7) - JUPITER_RADIUS);
        int jupiterY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle * 7) - JUPITER_RADIUS);

//        Color planet Jupiter
        g.setColor(Color.ORANGE);
        g.fillOval(jupiterX, jupiterY, 2 * JUPITER_RADIUS, 2 * JUPITER_RADIUS);

        //        Planet Saturn
        int saturnX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle * 8) - SATURN_RADIUS);
        int saturnY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle * 8) - SATURN_RADIUS);

//        Color planet Saturn
        g.setColor(Color.BLACK);
        g.fillOval(saturnX, saturnY, 2 * SATURN_RADIUS, 2 * SATURN_RADIUS);

        //        Planet Uranus
        int uranusX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle * 9) - URANUS_RADIUS);
        int uranusY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle * 9) - URANUS_RADIUS);

//        Color planet Uranus
        g.setColor(Color.CYAN);
        g.fillOval(uranusX, uranusY, 2 * URANUS_RADIUS, 2 * URANUS_RADIUS);

        //        Planet Neptune
        int neptuneX = (int) (getWidth() / 2 + ORBIT_RADIUS * Math.cos(angle * 10) - NEPTUNE_RADIUS);
        int neptuneY = (int) (getHeight() / 2 + ORBIT_RADIUS * Math.sin(angle * 10) - NEPTUNE_RADIUS);

//        Color planet Neptune
        g.setColor(Color.BLUE);
        g.fillOval(neptuneX, neptuneY, 2 * NEPTUNE_RADIUS, 2 * NEPTUNE_RADIUS);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SolarSystem());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}