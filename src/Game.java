import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.*;

public class Game {


    //---list of each board point for a 140x140 block---
    List<Point> points = new ArrayList<>();

    public Game() {

    Point zerozero = new Point(55, 55);
    Point zeroone = new Point(205, 55);
    Point zerotwo = new Point(355, 55);
    Point zerothree = new Point(505, 55);

    points.add(zerozero);
    points.add(zeroone);
    points.add(zerotwo);
    points.add(zerothree);


        CanvasWindow canvas = new CanvasWindow("2048 (MSCS Department Edition)", 700,700);
        GameBoard board = new GameBoard();
        canvas.add(board.createGrid());

        Block block = new Block(zerothree);
        canvas.add(block.getBlock());
        canvas.draw();
    }

    public static void main(String args[]) {
        new Game();
    }
}
