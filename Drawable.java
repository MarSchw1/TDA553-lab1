import java.awt.image.BufferedImage;

public interface Drawable {
    public void setX(int x);
    public void setY(int y);
    public int getX();
    public int getY();
    public BufferedImage getImage();
}
