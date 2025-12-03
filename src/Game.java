import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.*;
import edu.macalester.graphics.*;

public class Game {


    //---list of each board point for a 140x140 block---
    List<Point> points = new ArrayList<>();
    CanvasWindow canvas;

    //boolean gameInProgress = true;

    public Game() {

    Point zerozero = new Point(55, 55);
    Point zeroone = new Point(205, 55);
    Point zerotwo = new Point(355, 55);
    Point zerothree = new Point(505, 55);
    Point onezero = new Point(55, 205);
    Point oneone = new Point(205, 205);
    Point onetwo = new Point(355, 205);
    Point onethree = new Point(505, 205);
    Point twozero = new Point(55, 355);
    Point twoone = new Point(205, 355);
    Point twotwo = new Point(355, 355);
    Point twothree = new Point(505, 355);
    Point threezero = new Point(55, 505);
    Point threeone = new Point(205, 505);
    Point threetwo = new Point(355, 505);
    Point threethree = new Point(505, 505);
    points.add(zerozero);
    points.add(zeroone);
    points.add(zerotwo);
    points.add(zerothree);
    points.add(onezero);
    points.add(oneone);
    points.add(onetwo);
    points.add(onethree);
    points.add(twozero);
    points.add(twoone);
    points.add(twotwo);
    points.add(twothree);
    points.add(threezero);
    points.add(threeone);
    points.add(threetwo);
    points.add(threethree);
        

        CanvasWindow canvas = new CanvasWindow("2048 (MSCS Department Edition)", 700,700);
        GameBoard board = new GameBoard();
        canvas.add(board.createGrid());
        canvas.draw();
        
        Point blockpoint = points.get(new Random().nextInt(points.size()));
        Block block = new Block(blockpoint.getX(), blockpoint.getY(), 2);
        canvas.add(block.getBlock());
        Point newBlockpoint = points.get(new Random().nextInt(points.size()));
       if (canvas.getElementAt(newBlockpoint) == null) {
            Block newBlock = new Block(newBlockpoint.getX(), newBlockpoint.getY(), 2);
            canvas.add(newBlock.getBlock());
        }
        canvas.draw();

    }



    public void moveRight(){
        
    }

    

    public static void main(String args[]) {
        new Game();
    }
}
