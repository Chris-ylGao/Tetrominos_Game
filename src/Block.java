import javax.swing.*;
import java.awt.*;

public class Block extends JComponent {
    public int colorIndex;
    public static Color[] colors = {Color.red, Color.blue, Color.magenta,
    Color.orange, Color.green, Color.cyan, Color.yellow};
    public Block(int colorIndex){
        this.colorIndex= colorIndex;
    }
    public void draw(Graphics g, int scale, int x, int y){
        g.setColor(colors[colorIndex]);
        g.fillRect(x*scale+1, y*scale+1,scale-2,scale-2);

    }

    }

