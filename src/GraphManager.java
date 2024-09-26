import java.awt.*;
import java.util.ArrayList;

public class GraphManager extends Canvas {
    public static ArrayList<Double[]> datapoints = Main.XandYPositions;
    public static int zoom = 50;

    public static int shiftX = 0;
    public static int shiftY = 0;

    public void paint(Graphics g) {
        g.setColor(Color.red);

        g.fillRect(Main.res[0]/2 + shiftX, 0, 1, Main.res[1]);
        g.fillRect(0, Main.res[1]/2 + shiftY, Main.res[0], 1);

        int PointerD = 8;
        g.fillOval(Main.res[0]/2 - PointerD / 2, Main.res[1]/2 - PointerD / 2, PointerD, PointerD);

        g.setColor(Color.BLACK);
        for (int i = 0; i < datapoints.size(); i++) {
            try {
                int x = (Main.res[0] / 2) + (int) Math.round(datapoints.get(i)[0] * zoom) + shiftX;
                int y = (Main.res[1] / 2) - (int) Math.round(datapoints.get(i)[1] * zoom) + shiftY;

                int x1 = (Main.res[0] / 2) + (int) Math.round(datapoints.get(i+1)[0] * zoom) + shiftX;
                int y1 = (Main.res[1] / 2) - (int) Math.round(datapoints.get(i+1)[1] * zoom) + shiftY;

                if (!Double.isNaN(datapoints.get(i+1)[1])) {
                    g.drawLine(x1, y1, x, y);
                }
            } catch (Exception ignored) {}
        }
    }
}
