import java.util.Map;
import edu.macalester.graphics.*;
public class Block {
    private Image image;
    Map<Integer, String> imageCollection = Map.ofEntries( 
        Map.entry(2, "AbbyMarsh.jpeg"),
        Map.entry(4, "AliciaJohnson.jpeg"),
        Map.entry(8, "Bretjackson.jpeg"),
        Map.entry(16, "DanDrake.jpeg"),
        Map.entry(32, "GetiriaOnsongo.png"),
        Map.entry(64, "LianDuan.png"),
        Map.entry(128, "PaulCantrell.png"),
        Map.entry(256, "Shilad.jpeg"),
        Map.entry(512, "Suhas.jpeg"),
        Map.entry(1024, "SusanFox.png"),
        Map.entry(2048, "WilliamMitchell.jpeg"));    
    private int thisval;
    private int index;
    public Game game;
    /**
     * Creates a new Block object
     * @param index     The index of the points list from the Game class that will determine the placement the block goes in
     * @param val       The value of the block that coincides with that value's image
     * @param game      A call to the Game class that will retrieve the data from the points list
     */
    public Block(int index, int val, Game game) {
        this.index = index;
        this.game = game;
        this.thisval = val;
        for (int key:imageCollection.keySet()) {
            if(key == thisval) {
                this.image = new Image(game.points.get(index).getX(), game.points.get(index).getY(), imageCollection.get(key));
            }
        }
    }
    /**
     * Gets the position of the blocks position using the getX() and getY() method on the image
     * @return a new point of the image's position
     */
    public Point getPosition() {
        return new Point(image.getX(), image.getY());
    }
    /**
     * Sets the position of the blocks position using the index from the points list
     * @param index 
     */
    private void setPosition(int index) {
        this.image.setPosition(game.points.get(index).getX(), game.points.get(index).getY());
    }
    /**
     * Returns the value that corresponds to that image
     * @return
     */
    public int getVal() {
        return thisval;
    }
    /**
     * Returns the image of the block
     * @return
     */
    public Image getBlock() {
        return this.image;
    }
    /**
     * Creates a new block with its corresponding value and position it will have on the game board
     * @param index 
     * @param val
     */
    public void setBlock(int index, Integer val) {
        this.image = new Image(game.points.get(index).getX(), game.points.get(index).getY(), imageCollection.get(val));
    }
    /**
     * Returns the index the block is positioned at
     * @return
     */
    public int getIndex() {
        return this.index;
    }
    /**
     * Sets a new index for a block to position it somewhere else
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }
    public void removeBlock(Block block) {
        block.setIndex(-1);
        block.setPosition(16);
    }
}