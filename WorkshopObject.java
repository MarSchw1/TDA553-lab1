import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class WorkshopObject implements Drawable {
    //private final ArrayList<Volvo240> cars;
    private Workshop workshop;
    private final double x;
    private final double y;
    BufferedImage image;
    WorkshopObject(Workshop<Volvo240> workshop){
        this.workshop = workshop;
        this.x = (int) this.workshop.shopX();
        this.y = (int) this.workshop.shopY();
        try {
            this.image = ImageIO.read(View.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
