import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener {

    private boolean[][] grid;

    public DrawPanel() {
        grid = new boolean[30][40];
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        int y = 10;
        Graphics2D g2 = (Graphics2D) g;
        
        for (int i = 0; i < 30; i++) {
            for (int a = 0; a < 40; a++) {
                g.drawRect(x, y, 20, 20);
                if (grid[i][a]) {
                    g2.setColor(Color.RED);
                    g.fillRect(x, y, 20, 20);
                    g2.setColor(Color.BLACK);
                }
                x += 25;
            }
            x = 10;
            y += 25;
        }
    }

    private void turnRed() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int chance = (int) (Math.random() * 10);
                if (chance < 3) {
                    grid[r][c] = true;
                }
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        grid = new boolean[30][40];
        turnRed();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}