import java.util.List;
import java.util.ArrayList;
import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and container

/**
 * Custom Graphics Example: Paint (similar to Windows' paint program)
 */
public class Paint extends JFrame {
    // Define constants for the various dimensions
    public static final int CANVAS_WIDTH = 500;
    public static final int CANVAS_HEIGHT = 300;
    public static final Color LINE_COLOR = Color.RED;

    // Lines drawn, consists of a List of PolyLine instances
    private List<PolyLine> lines = new ArrayList<PolyLine>();
    private PolyLine currentLine;  // the current line (for capturing)

    // Constructor to set up the GUI components and event handlers
    public Paint() {
        DrawCanvas canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        canvas.addMouseListener(new MouseAdapter() { //鼠标动作捕捉
            @Override
            public void mousePressed(MouseEvent evt) {
                // Begin a new line
                currentLine = new PolyLine();
                lines.add(currentLine);
                currentLine.addPoint(evt.getX(), evt.getY());
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() { //鼠标滑动轨迹捕捉
            @Override
            public void mouseDragged(MouseEvent evt) {
                currentLine.addPoint(evt.getX(), evt.getY());
                repaint();  // invoke paintComponent()
            }
        });

        setContentPane(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Paint");
        pack();
        setVisible(true);
    }

    // Define inner class DrawCanvas, which is a JPanel used for custom drawing
    private class DrawCanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) { // called back via repaint()
            super.paintComponent(g);
            g.setColor(LINE_COLOR);
            for (PolyLine line: lines) {
                line.draw(g);
            }
        }
    }

    // The entry main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            // Run the GUI codes on the Event-Dispatching thread for thread safety
            @Override
            public void run() {
                new Paint(); // Let the constructor do the job
            }
        });
    }
}