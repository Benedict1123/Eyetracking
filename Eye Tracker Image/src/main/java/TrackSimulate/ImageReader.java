package TrackSimulate;

import TrackSimulate.Launch;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class ImageReader extends Component {

    BufferedImage img;
    int image_width;
    int image_height;

    public ImageReader() {
        try {
            img = ImageIO.read(new File("res/image.jpg"));
            image_width = img.getWidth();
            image_height = img.getHeight();
        } catch (IOException e) {
            System.out.println("Error loading image");
        }
    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100,100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
        g.setColor(Color.RED);
        g.fillRect(Launch.start_point, Launch.start_point,5,5);
    }

}