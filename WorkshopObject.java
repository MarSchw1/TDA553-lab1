import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class WorkshopObject implements Drawable {
    //private final ArrayList<Volvo240> cars;
    private Workshop workshop;
    private final int x;
    private final int y;
    BufferedImage image;

    WorkshopObject(Workshop<Volvo240> workshop){
        this.workshop = workshop;
        this.x = (int) this.workshop.getX();
        this.y = (int) this.workshop.getY();
        try {this.image = ImageIO.read(View.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int newX) {
    }

    @Override
    public void setY(int newY) {
    }
}
