import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Board extends JComponent {
    private static final int SCALE = 16; // number of pixels per square
    private Piece activePiece ;
    private int cols;
    private int rows;
    private Graphics g;
    private boolean isCollision;
    private ArrayList<Block> blocks;
    private ArrayList<Location> locations;


    public Board(int cols, int rows) {
        super();
        isCollision = true;
        this.cols = cols;
        this.rows = rows;
        blocks = new ArrayList<>();
        locations = new ArrayList<>();
        setPreferredSize(new Dimension(cols * SCALE, rows * SCALE));
    }
    //paintComponent() used to draw the blocks
    public void paintComponent(Graphics g) {
        //clear the screen with black
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight()); //fillRect(x,y,width,height) used to set coordinates of the upper left, width and height;
        //setColor() used to set color
        //fillRect(x,y,width,height) used to set coordinates of the upper left, width and height;

        //create an activePiece with random number

        if (isCollision) {
            if (activePiece != null)  copyPieces(g);
            Random rand = new Random();
            int shapeIndex = rand.nextInt(7);
            activePiece = new Piece(shapeIndex);
            isCollision = false;
        }
        activePiece.draw(g);


    }

    // Move the active piece down one step. Check for collisions.
    //  Check for complete rows that can be destroyed.
    // nextTurn() is called every 300 ms.
    public void nextTurn() {
        System.out.println(activePiece.maxY());
        if (activePiece.maxY() < rows - 2) {
            activePiece.translate(0,1);
        }else{
            isCollision = true;
        }
        repaint();

    }

    public void slide(int dx) {
        // TO DO: move the active piece one square in the direction dx
        // (which has a value -1 or 1):
        System.out.println(activePiece.maxX());
        if (dx == -1 && activePiece.minX() > 0)  activePiece.translate(dx,0);
        if (dx == 1 && activePiece.maxX() < cols - 1 ) activePiece.translate(dx,0);
        // request that paintComponent be called again:
        repaint();
    }
    public void rotateRight() {
        // TO DO: rotate the active piece to the right:
        //System.out.println("rotateRight");

        repaint();
    }

    public void rotateLeft() {
        System.out.println("rotateLeft");
        // TO DO: rotate the active piece to the left:
        repaint();
    }
    public void copyPieces(Graphics g){
        isCollision = true;
        int colorIndex = activePiece.getColor();
        for (Location l : activePiece.getLocation()){
            locations.add(l);
        }
       
        for (int i = 0; i< blocks.size(); i++){
            Block b = blocks.get(i);
            b.draw(g,SCALE,locations.get(i).getX(),locations.get(i).getY());
        }
    }


}
