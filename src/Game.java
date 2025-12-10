import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEventHandler;
public class Game {
    //---list of each board point for a 140x140 block---
    public List<Point> points = new ArrayList<>();
    private CanvasWindow canvas;
    private KeyboardEventHandler handler;
    private Block[] blocksOnScreen = new Block[16];
    private int val;
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
//-------
    //where stuff happens
        addRandomBlock();
        addRandomBlock();
        //call to move block from keydown (when list ready, iterate over each for moveblock)
        canvas.onKeyDown(event ->
            moveBlock(event.getKey())
        );
        // canvas.draw();
    }
//------
    /**
     * Adds an image of either Abby or Alicia onto a random position on the game board 
     */
    public void addRandomBlock() {
        int randIndex = new Random().nextInt(points.size());
        while (blocksOnScreen[randIndex] != null){
            randIndex = new Random().nextInt(points.size());
        }
        double randval = new Random().nextDouble();
        if (randval <= 0.7) {
            val = 2;
        }
        else {
            val = 4;
        }
        Block block = new Block(randIndex, val, this);
        canvas.add(block.getBlock());
        blocksOnScreen[randIndex] = block;
    }
    /**
     * Comprises all four of the move methods into one and calls each one 
     * based off the key that is pressed by the user
     * @param key       Corresponds with the key that is pressed
     */
    public void moveBlock(Key key) {
        Key up = Key.UP_ARROW;
        Key down = Key.DOWN_ARROW;
        Key left = Key.LEFT_ARROW;
        Key right = Key.RIGHT_ARROW;
        System.out.println(blocksOnScreen);
        for(int i = 0; i < 16; i++) {
            Block block = blocksOnScreen[i];
            if(block != null) {
                if(block.getPosition().getX() >= 55 && block.getPosition().getX() <= 505 && block.getPosition().getY() >= 55 && block.getPosition().getY() <= 505) {
                    if(key == up) {
                        moveUp(block);
                    }
                    if (key == down) {
                        moveDown(block);
                    }
                    if (key == left) {
                        moveLeft(block);
                    }
                    if (key == right) {
                        moveRight(block);
                    }
                }
                System.out.println(canvas.getElementAt(block.getPosition()));
            }
        }
        addRandomBlock();
    }
    /**
     * If up-arrow key is pressed, then this method gets called on all blocks
     * to move up
     * @param block
     */
    public void moveUp(Block block) {
        if (block != null && blocksOnScreen[block.getIndex()].getIndex() > 3) {
            while (blocksOnScreen[block.getIndex()-4] == null) {
                if (blocksOnScreen[block.getIndex()].getIndex() < 4) {
                    System.out.println("hello");
                    block.setPosition(block.getIndex());
                    break;
                }
                block.setPosition(block.getIndex()-4);
                break;
            }
            if (blocksOnScreen[block.getIndex()-4] != null) {
                interactWith(block, blocksOnScreen[block.getIndex()-4]);
            }
        }
    }
    /**
     * If down-arrow key is pressed, then this method gets called on all blocks
     * to move down
     * @param block
     */
    public void moveDown(Block block) {
        if (block != null && blocksOnScreen[block.getIndex()].getIndex() < 12) {
            while (blocksOnScreen[block.getIndex()+4] == null) {
                if (blocksOnScreen[block.getIndex()].getIndex() > 11) {
                    System.out.println("hello");
                    block.setPosition(block.getIndex());
                    break;
                }
                block.setPosition(block.getIndex()+4);
                break;
            }
            if (blocksOnScreen[block.getIndex()+4] != null) {
                interactWith(block, blocksOnScreen[block.getIndex()+4]);
            }
        }
    }
    /**
     * If left-arrow key is pressed, then this method gets called on all blocks
     * to move left
     * @param block
     */
    public void moveLeft(Block block) {
        if (block != null && (blocksOnScreen[block.getIndex()].getIndex() != 0 || blocksOnScreen[block.getIndex()].getIndex() != 4 || blocksOnScreen[block.getIndex()].getIndex() != 8 || blocksOnScreen[block.getIndex()].getIndex() != 12)) {
            while (blocksOnScreen[block.getIndex()-1] == null) {
                if (blocksOnScreen[block.getIndex()].getIndex() == 0 || blocksOnScreen[block.getIndex()].getIndex() == 4 || blocksOnScreen[block.getIndex()].getIndex() == 8 || blocksOnScreen[block.getIndex()].getIndex() == 12) {
                    System.out.println("hello");
                    block.setPosition(block.getIndex());
                    break;
                }
                block.setPosition(block.getIndex()-1);
                break;
            }
            if (blocksOnScreen[block.getIndex()-1] != null) {
                interactWith(block, blocksOnScreen[block.getIndex()-1]);
            }
        }
    }
    /**
     * If left-arrow key is pressed, then this method gets called on all blocks
     * to move right
     * @param block
     */
    public void moveRight(Block block) {
        if (block != null && (blocksOnScreen[block.getIndex()].getIndex() != 3 || blocksOnScreen[block.getIndex()].getIndex() != 3 || blocksOnScreen[block.getIndex()].getIndex() != 11 || blocksOnScreen[block.getIndex()].getIndex() != 15)) {
            while (blocksOnScreen[block.getIndex()+1] == null) {
                if (blocksOnScreen[block.getIndex()].getIndex() == 3 || blocksOnScreen[block.getIndex()].getIndex() == 7 || blocksOnScreen[block.getIndex()].getIndex() == 11 || blocksOnScreen[block.getIndex()].getIndex() == 15) {
                    System.out.println("hello");
                    block.setPosition(block.getIndex());
                    break;
                }
                block.setPosition(block.getIndex()+1);
                break;
            }
            if (blocksOnScreen[block.getIndex()+1] != null) {
                interactWith(block, blocksOnScreen[block.getIndex()+1]);
            }
        }
    }
    /**
     * Gets called in the four directional move methods to combine the blocks
     * that meet the criteria to do so
     * @param block          The block that is used to determine if the other block is the same or different
     * @param otherBlock       The block that is used to reference the main block and compare it to that block
     */
    public void interactWith(Block block, Block otherBlock) {
        if(block.getVal() == otherBlock.getVal()) {
            System.out.println("hello");
            Block newBlock = new Block(otherBlock.getIndex(), (otherBlock.getVal()*2), this);
            blocksOnScreen[otherBlock.getIndex()] = newBlock;
            blocksOnScreen[block.getIndex()] = null;
            canvas.remove(block.getBlock());
            canvas.remove(otherBlock.getBlock());
            canvas.add(newBlock.getBlock());
            canvas.draw();
        }
        }
    public static void main(String args[]) {
        new Game();
    }
}