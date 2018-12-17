package TrackSimulate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Launch {
    static int start_point = 50;
    static JFrame f = new JFrame("Load Image Sample");

    public static void main(String[] args) {

        f.setUndecorated(true);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        ImageReader new_one = new ImageReader();
        f.add(new_one);
        System.out.println(new_one.image_width + "\n" + new_one.image_height);
        f.pack();
        f.setVisible(true);
        f.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent me)
            {
                System.out.println(me.getX() + "........." + me.getY());
            }
        });
//        Runnable movement = new Movement();
//        Thread thread_move = new Thread(movement);
//        thread_move.start();
    }

    static class Movement implements Runnable{
        //线程里的方法
        public void run()
        {
            while(true) {
                start_point++;
//                System.out.println(start_point);
                System.out.println("Now it is at" + start_point);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                f.repaint();
            }
        }
    }
}
