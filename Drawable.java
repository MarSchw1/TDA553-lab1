import java.awt.image.BufferedImage;

public interface Drawable {
    public void setPosition(int x, int y);
    public int getX();
    public int getY();
    public BufferedImage getImage();
}
