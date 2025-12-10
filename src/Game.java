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
    private double max = 505;
    private double min = 55;
    private int count = 0;
    private Point blockpoint;
    private Block block;
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
        int randIndex = new Random().nextInt(points.size());
        while (blocksOnScreen[randIndex] != null){
            randIndex = new Random().nextInt(points.size());
        }
        double randval = new Random().nextDouble();
        if (randval <= 0.7){
            val = 2;
        }
        else {
            val = 4;
        }
        Block block = new Block(randIndex, val, this);
        canvas.add(block.getBlock());
        blocksOnScreen[randIndex] = block;
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
        for(int i = 0; i < 16; i++){
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
                        block.setPosition(block.getIndex() - 1);
                    }
                    if (key == right) {
                        block.setPosition(block.getIndex() + 1);
                    }
                }
            }
        }
        handleBlockInteraction();
        addRandomBlock();
    }
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
            
        //     if(canvas.getElementAt(points.get(i)) != null) {
        //         if(canvas.getElementAt(points.get(i-4)) == null) {
        //             // FIND THE BLOCK -- WE KNOW IT'S THERE, WE KNOW ITS POSITION, NOW WE HAVE TO GO GET IT
        //             // for(Block b : blocksOnScreen) {
        //             //     if(b.getPosition().equals(points.get(i))) {
        //             //         b.setPosition(points.get(i).getX(), points.get(i).getY() - 150);
        //             //     }
        //             // }
        //         }
        //         if(canvas.getElementAt(points.get(i-4)) != null) {
        //             Block thisBlock = null;
        //             Block otherBlock = null;
        //             // FIND THE BLOCK -- WE KNOW IT'S THERE, WE KNOW ITS POSITION, NOW WE HAVE TO GO GET IT

        //             for(Block b : blocksOnScreen) {
        //                 if(b.getPosition().equals(points.get(i))) {
        //                     thisBlock = b;
        //                 }
        //                 if(b.getPosition().equals(points.get(i-4))) {
        //                     otherBlock = b;
        //                 }
        //             }
        //             interactWith(thisBlock, otherBlock);
        //         }
        //     }
        
    }

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
    //     for(int i = 11; i >= 0; i--) {

    //     }
    // }

    public void moveLeft(Block block) {
        if (block != null && blocksOnScreen[block.getIndex()].getIndex() != 0 && blocksOnScreen[block.getIndex()].getIndex() != 4 && blocksOnScreen[block.getIndex()].getIndex() != 8 && blocksOnScreen[block.getIndex()].getIndex() != 12) {
            while (blocksOnScreen[block.getIndex()-1] == null) {
                if (blocksOnScreen[block.getIndex()].getIndex() == 0 && blocksOnScreen[block.getIndex()].getIndex() == 4 && blocksOnScreen[block.getIndex()].getIndex() == 8 && blocksOnScreen[block.getIndex()].getIndex() == 12) {
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
    //     for(int i = 1; i < 16; i++) {
    //         if(i != 4 && i != 8 && i != 12) {

    //         }
    //     }
    // }

    public void moveRight(Block block) {
        if (block != null && blocksOnScreen[block.getIndex()].getIndex() != 3 && blocksOnScreen[block.getIndex()].getIndex() != 7 && blocksOnScreen[block.getIndex()].getIndex() != 11 && blocksOnScreen[block.getIndex()].getIndex() != 15) {
            while (blocksOnScreen[block.getIndex()+1] == null) {
                if (blocksOnScreen[block.getIndex()].getIndex() == 3 && blocksOnScreen[block.getIndex()].getIndex() == 7 && blocksOnScreen[block.getIndex()].getIndex() == 11 && blocksOnScreen[block.getIndex()].getIndex() == 15) {
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
    
    //     for(int i = 14; i >= 0; i--) {
    //         if(i != 3 && i != 7 && i != 11) {

    //         }
    //     }
    // }

    public void interactWith(Block block, Block otherBlock) {
        if(block.getVal() != otherBlock.getVal()) {
            return;
        }
        else {
            System.out.println("hello");
            Block newBlock = new Block(otherBlock.getIndex(), (otherBlock.getVal()*2), this);
            blocksOnScreen[otherBlock.getIndex()] = newBlock;
            blocksOnScreen[block.getIndex()] = null;
            canvas.remove(block.getBlock());
            canvas.remove(otherBlock.getBlock());
            canvas.add(newBlock.getBlock());
            canvas.draw();
        }
        //     for(int i = 0;i < 4;i++) {
        //         if (canvas.getElementAt(points.get(i)) != null) {
        //             block.setPosition(block.getPosition().getX(), min + 150);
        //         }
        //     }
        // }
        // else{
        //     block.setVal(otherBlock.getVal() * 2);
        //     blocksOnScreen.remove(otherBlock);
        //     blocksOnScreen.remove(block);
        //     canvas.remove(otherBlock.getBlock());
        //     canvas.remove(block.getBlock());
        //     Block newBlock = new Block(block.getPosition().getX(), block.getPosition().getY(), val);
        //     blocksOnScreen.add(newBlock);
        //     canvas.add(newBlock.getBlock());

        //     }
        }
    

    public void handleBlockInteraction() {
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