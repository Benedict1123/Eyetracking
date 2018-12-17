import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingPoint{

    int roadData=100;
    JFrame frame;
    final ImageIcon img = new ImageIcon("res/image.jpg");
    JLabel background;

    //multi-thread method
    class SerialPaint extends JPanel implements Runnable{
        public void paintComponent(Graphics drawPaint){
            drawPaint.setColor(Color.RED);
            drawPaint.fillRect(roadData,roadData,5,5);
            background = new JLabel("bt-bg",img,JLabel.CENTER);
            background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        }
        //线程里的方法
        public void run()
        {
            go();
        }

        public void go()
        {
            while(true)
            {
                roadData++;
                System.out.println(roadData);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                frame.repaint();
            }
        }
    }

    public void ui(){
        frame = new JFrame();
//        TrackSimulate.ImageReader new_one = new TrackSimulate.ImageReader();
        background = new JLabel("bt-bg",img,JLabel.CENTER);
        background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        frame.setSize(img.getIconWidth(),img.getIconHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        frame.add(background);
        SerialPaint serialpaint = new SerialPaint();
        background.add(serialpaint);
//        frame.add(new_one);
//        frame.setContentPane(new JLabel(new ImageIcon(new_one.img)));
        frame.pack();
        frame.setVisible(true);
    }

    public void serialThread(){
        Runnable serialRunnable = new SerialPaint();
        Thread threadS = new Thread(serialRunnable);
        threadS.start();
    }

    public static void main(String[] args){
        MovingPoint serialui = new MovingPoint();
        serialui.ui();
        serialui.serialThread();
    }
}
