import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class view extends JPanel implements ModelUpdateObserver{
    private Model model;
    private ArrayList<drawable> items = new ArrayList<drawable>();

    public void OnModelUpdate() {
        items = Model.getDrawings();
        this.repaint();
    }
public view(int x, int y, Model model){
    this.model = model;
    this.setDoubleBuffered(true);
    this.setPreferredSize(new Dimension(x, y));
    this.setBackground(Color.green);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (drawable item : items) {
            g.drawImage(item.getImage(), item.getX(), item.getY(), null);
        }
    }
}