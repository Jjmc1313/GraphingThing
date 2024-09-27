import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrameManager extends JFrame implements KeyListener {
    GraphManager gM = new GraphManager();

    public FrameManager() {
       add(gM);
       setSize(Main.res[0], Main.res[1]);

       gM.setFocusable(true);
       gM.addKeyListener(this);

       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setResizable(false);
       setTitle(Main.title);
       setVisible(true);
   }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int shift = 10;
        if (e.getKeyCode() == KeyEvent.VK_0) {
            GraphManager.shiftX = 0;
            GraphManager.shiftY = 0;
            GraphManager.zoom = 50;
            gM.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            GraphManager.shiftX -= shift;
            gM.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            GraphManager.shiftX += shift;
            gM.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            GraphManager.shiftY += shift;
            gM.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            GraphManager.shiftY -= shift;
            gM.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_MINUS) {
            GraphManager.zoom -= shift;
            gM.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_EQUALS) {
            GraphManager.zoom += shift;
            gM.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
