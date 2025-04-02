import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener {

    private boolean[][] grid;
    private BrickLayout brickLayout;

    public DrawPanel() {
        this.addMouseListener(this);
        grid = new boolean[30][40];
        brickLayout = new BrickLayout("src/BrickInput", 40, false);
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
                    g2.setColor(Color.GREEN);
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
        brickLayout.doOneBrick();
        int[][] brickLayoutGrid = brickLayout.getBrickLayout();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (brickLayoutGrid[r][c] == 1) {
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