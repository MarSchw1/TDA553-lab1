import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class View extends JPanel implements ModelUpdateObserver{
    private Model model;
    private ArrayList<Drawable> items = new ArrayList<Drawable>();

    public void OnModelUpdate() {
        items = model.getImages();
        this.repaint();
    }
public View(int x, int y, Model model){
    this.model = model;
    this.setDoubleBuffered(true);
    this.setPreferredSize(new Dimension(x, y));
    this.setBackground(Color.green);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable item : items) {
            g.drawImage(item.getImage(), item.getX(), item.getY(), null);
        }
    }
}