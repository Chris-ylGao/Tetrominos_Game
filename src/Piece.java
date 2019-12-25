import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class Piece {
    private Block block;
    private HashMap<Integer, Location[]> locations;

    private Location[] location;
    private Location[] positions;
    // different pieces;
    private int shapeIndex;


    //

    public Piece(int shapeIndex) {
        this.shapeIndex = shapeIndex;
        locations = new HashMap<>();
        positions = new Location[3];
        locations.put(0, new Location[]{new Location(0, 0), new Location(1, 0), new Location(1, 1), new Location(2, 1)});
        locations.put(1, new Location[]{new Location(0, 0), new Location(0, 1), new Location(1, 1), new Location(2, 1)});
        locations.put(2, new Location[]{new Location(1, 0), new Location(0, 1), new Location(1, 1), new Location(2, 1)});
        locations.put(3, new Location[]{new Location(2, 0), new Location(0, 1), new Location(1, 1), new Location(2, 1)});
        locations.put(4, new Location[]{new Location(1, 0), new Location(2, 0), new Location(0, 1), new Location(1, 1)});
        locations.put(5, new Location[]{new Location(0, 0), new Location(1, 0), new Location(2, 0), new Location(3, 0)});
        locations.put(6, new Location[]{new Location(0, 0), new Location(1, 0), new Location(0, 1), new Location(1, 1)});
        positions = locations.get(shapeIndex);
    }

    /**
     * translate the heap of blocks
     * @param x the distance in vertical
     * @param y the distance in horizon
     */
    public void translate(int x, int y) {
        for(Location l : positions){
            l.update(x,y);
        }
    }
    /**
     * find the minimum x coordination of positions
     */
    public int minX(){
        int minX = Integer.MAX_VALUE;
        for (Location l : positions){
            if (l.getX() < minX) minX = l.getX();
        }
        return minX;
    }
    /**
     * find the maximum y coordination of positions
     */
    public int maxY(){
        int maxY = Integer.MIN_VALUE;
        for (Location l : positions){
            if (l.getX() > maxY) maxY = l.getY();
        }
        return maxY;
    }

    /**
     * find the maximum x coordination of positions
     * @return
     */
    public int maxX(){
        int maxX = Integer.MIN_VALUE;
        for (Location l : positions){
            if (l.getX() > maxX) maxX = l.getX();
        }
        return maxX;
    }
    /**
     * draw 6 shapes of Tetrominos
     * @param g
     */
    public void draw(Graphics g) {
        switch (shapeIndex) {
            case 0:
                //draw red shape
                block = new Block(0);
                break;
            case 1:
                // draw blue shape

                block = new Block(1);
                break;
            case 2:
                // draw magenta shape
                block = new Block(2);
                break;
            case 3:
                // draw orange shape
                block = new Block(3);
                break;
            case 4:
                //draw green shape
                block = new Block(4);
                break;
            case 5:
                // draw a line with color cyan
                block = new Block(5);
                break;
            case 6:
                block = new Block(6);
                break;
        }
        for (Location p :positions){
            block.draw(g,16,p.getX(),p.getY());
        }
    }
 public Location[] getLocation(){
        return positions;
 }
 public int getColor(){
        return shapeIndex;
 }
}
