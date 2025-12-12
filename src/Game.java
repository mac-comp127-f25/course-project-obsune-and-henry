import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
public class Game {
    //---list of each board point for a 140x140 block---
    public List<Point> points = new ArrayList<>();


    private CanvasWindow canvas;
    private Block[] blocksOnScreen = new Block[16];
    public Game() {
    
    //setting up points to add to list
    Point offScreen = new Point(-300, -300);
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
    points.add(offScreen);

        //setting up canvas and adding elements from GameBoard
        this.canvas = new CanvasWindow("2048 (MSCS Department Edition)", 700,700);
        GameBoard board = new GameBoard();
        canvas.add(board.createGrid());

//-------
    //Called during gameplay
        addRandomBlock();
        addRandomBlock();
        //call to move block from keydown (when list ready, iterate over each for moveblock)
        canvas.onKeyDown(event ->
            moveBlock(event.getKey())
        );
//------
    }
    public static int gridCoordsToIndex(int x, int y) {
        return x + 4 * y;
    }
    public static int indexToXCoord(int index) {
        return index % 4;
    }
    public static int indextoYCoord(int index) {
        return index/4;
    }
    /**
     * Adds an image of either Abby or Alicia onto a random position on the game board 
     */
    public void addRandomBlock() {
        int randIndex = new Random().nextInt(points.size()-1);
        int valTwoOrFour;
        while (blocksOnScreen[randIndex] != null){
            randIndex = new Random().nextInt(points.size()-1);
        }
        double randval = new Random().nextDouble();
        if (randval <= 0.7) {
            valTwoOrFour = 2;
        }
        else {
            valTwoOrFour = 4;
        }
        Block block = new Block(randIndex, valTwoOrFour, this);
        canvas.add(block.getImage());
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
        addRandomBlock();
                    if(key == up) {
                        for(int y = 0; y < 4;y++ ) {
                            for(int x = 0;x < 4;x++){
                                Block block = blocksOnScreen[gridCoordsToIndex(x, y)];
                                if (block != null) {
                                    moveUp(block);
                                }
                            }
                        }
                    }
                    if (key == down) {
                        for(int y = 3;y > -1;y--) {
                            for(int x = 0; x < 4;x++) {
                                Block block = blocksOnScreen[gridCoordsToIndex(x, y)];
                                if (block != null) {
                                    moveDown(block);
                                }
                            }
                        }
                    }
                    if (key == left) {
                        for(int x = 0;x < 4;x++) {
                            for(int y = 0; y < 4;y++) {
                                Block block = blocksOnScreen[gridCoordsToIndex(x, y)];
                                if (block != null) {
                                    moveLeft(block);
                                }
                            }
                        }
                    }
                    if (key == right) {
                        for(int x = 3;x > -1;x--) {
                            for(int y = 0; y < 4;y++) {
                                Block block = blocksOnScreen[gridCoordsToIndex(x, y)];
                                if (block != null) {
                                    moveRight(block);
                                }
                            }
                        }
                    }
        canvas.removeAll();
        GameBoard board = new GameBoard();
        canvas.add(board.createGrid());
        for(Block block:blocksOnScreen) {
            if (block != null) {
                canvas.add(block.getImage());
            }
        }
        canvas.draw();
    }
    /**
     * If up-arrow key is pressed, then this method gets called on all blocks
     * to move up
     * @param block
     */
    public void moveUp(Block block) {
        if (blocksOnScreen[block.getIndex()].getIndex() < 4) {
            return;
        }
        int currPosition = block.getIndex();
        int newPosition = block.getIndex() - 4;
        if (blocksOnScreen[newPosition] == null) {
            block.setIndex(newPosition);
            blocksOnScreen[newPosition] = block;
            blocksOnScreen[currPosition] = null;
            return;
            }
        if (blocksOnScreen[newPosition] != null) {
            interactWith(block, blocksOnScreen[newPosition]);
        }
    }
    
    /**
     * If down-arrow key is pressed, then this method gets called on all blocks
     * to move down
     * @param block
     */
    public void moveDown(Block block) {
        if (blocksOnScreen[block.getIndex()].getIndex() > 11) {
            return;
        }
        int currPosition = block.getIndex();
        int newPosition = block.getIndex() + 4;
        if (blocksOnScreen[newPosition] == null) {
            block.setIndex(newPosition);
            blocksOnScreen[newPosition] = block;
            blocksOnScreen[currPosition] = null;
            return;
            }
        if (blocksOnScreen[newPosition] != null) {
            interactWith(block, blocksOnScreen[newPosition]);
        }
    }
    /**
     * If left-arrow key is pressed, then this method gets called on all blocks
     * to move left
     * @param block
     */
    public void moveLeft(Block block) {
        if (indexToXCoord(block.getIndex()) == 0) {
            return;
        }
        int currPosition = block.getIndex();
        int newPosition = block.getIndex() - 1;
        if (blocksOnScreen[newPosition] == null) {
            block.setIndex(newPosition);
            blocksOnScreen[newPosition] = block;
            blocksOnScreen[currPosition] = null;
            return;
            }
        if (blocksOnScreen[newPosition] != null) {
            interactWith(block, blocksOnScreen[newPosition]);
        }
    }
    /**
     * If left-arrow key is pressed, then this method gets called on all blocks
     * to move right
     * @param block
     */
    public void moveRight(Block block) {
        if (indexToXCoord(block.getIndex()) == 3) {
            return;
        }
        int currPosition = block.getIndex();
        int newPosition = block.getIndex() + 1;
        if (blocksOnScreen[newPosition] == null) {
            block.setIndex(newPosition);
            blocksOnScreen[newPosition] = block;
            blocksOnScreen[currPosition] = null;
            return;
            }
        if (blocksOnScreen[newPosition] != null) {
            interactWith(block, blocksOnScreen[newPosition]);
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
            canvas.remove(block.getImage());
            canvas.remove(otherBlock.getImage());
            canvas.add(newBlock.getImage());
            block.removeBlock(otherBlock);
            block.removeBlock(block);
            canvas.draw();
        }
        else {
            return;
        }
    }
    public static void main(String args[]) {
        new Game();
    }
}