import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEventHandler;

public class Game {

    //---list of each board point for a 140x140 block---
    private List<Point> points = new ArrayList<>();

    private CanvasWindow canvas;
    private KeyboardEventHandler handler;
    private List<Block> blocksOnScreen = new ArrayList<>();
    private double max = 505;
    private double min = 55;
    private int count = 0;

    // Block block;

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
        

        this.canvas = new CanvasWindow("2048 (MSCS Department Edition)", 700,700);
        GameBoard board = new GameBoard();
        canvas.add(board.createGrid());
        

        //blocks list
        this.blocksOnScreen = blocksOnScreen;


        
    //     //add block to random pos
    //     Point blockpoint = points.get(new Random().nextInt(points.size()));
    //     Block block = new Block(blockpoint.getX(), blockpoint.getY(), 2);
    //     canvas.add(block.getBlock());

    //     //add new block to random pos (I think this wont work if on same space)
    //     Point newBlockpoint = points.get(new Random().nextInt(points.size()));
    //    if (canvas.getElementAt(newBlockpoint) == null) {
    //         Block newBlock = new Block(newBlockpoint.getX(), newBlockpoint.getY(), 2);
    //         canvas.add(newBlock.getBlock());
    //         canvas.draw();
    //     }

//-------

    //where stuff happens


        addRandomBlock();

        //call to move block from keydown (when list ready, iterate over each for moveblock)
        canvas.onKeyDown(event ->
            moveBlock(event.getKey())
        );
        // canvas.draw();
    }
    

//------

    public void updateElementList(List<Block> list){
        for (Block block:list){
        
        Point pos = block.getPosition();
        double val = block.getVal();
        
        }

    }

    //add random block
    public void addRandomBlock(){
        Point blockpoint;
        double val;
        
        blockpoint = points.get(new Random().nextInt(points.size()));
        while (canvas.getElementAt(blockpoint.getX() + 10, blockpoint.getY() + 10) != null){
            blockpoint = points.get(new Random().nextInt(points.size()));
        }
        double randval = new Random().nextDouble();
        if (randval <= 0.7){
            val = 2;
        }
        else {
            val = 4;
        }
        Block block = new Block(blockpoint.getX(), blockpoint.getY(), val);
        canvas.add(block.getBlock());
        blocksOnScreen.add(block);
        // canvas.draw();



        


        // for(Point point:points){
        //     if(canvas.getElementAt(point.getX() + 10, point.getY() + 10) == null){


        // }

        // if (canvas.getElementAt(newBlockpoint) == null) {
        //     Block newBlock = new Block(newBlockpoint.getX(), newBlockpoint.getY(), 2);
        //     canvas.add(newBlock.getBlock());
        //     canvas.draw();
        // }
    }

    //block movement
    public void moveBlock(Key key) {
        Key up = Key.UP_ARROW;
        Key down = Key.DOWN_ARROW;
        Key left = Key.LEFT_ARROW;
        Key right = Key.RIGHT_ARROW;
        System.out.println(blocksOnScreen);
        for(Block block: blocksOnScreen){
            if(block.getPosition().getX() >= 55 && block.getPosition().getX() <= 505 && block.getPosition().getY() >= 55 && block.getPosition().getY() <= 505) {
                if (key == up) {
                    block.setPosition(block.getPosition().getX(), min);
                }
                if (key == down) {
                    block.setPosition(block.getPosition().getX(), max);
                }
                if (key == left) {
                    block.setPosition(min, block.getPosition().getY());
                }
                if (key == right) {
                    block.setPosition(max, block.getPosition().getY());
                }
            }
        }
        addRandomBlock();
    }
    
    // public List<String> getBlocks(){
        
    //     for (Point point:points) {
    //         GraphicsObject object = canvas.getElementAt(point.getX() + 10, point.getY() + 10);
    //         System.out.println(object.toString());
        
    //     }
    //     //     if(point == null){
    //     //         System.out.println("null");
    //     //     }
    //     //     else{
    //     //         blocksOnScreen.add(point.toString());
    //     //     }
    //     // }
    
    //     return blocksOnScreen;
    // }

    public static void main(String args[]) {
        new Game();
    }
}
