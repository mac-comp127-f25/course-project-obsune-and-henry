import java.util.Map;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
public class Block {
    //private Rectangle block;
    private Image image;
    private Map<Integer,String> imageCollection = Map.of(2,"AbbyMarsh.jpeg",4,"AliciaJohnson.jpeg",8,"Bretjackson.jpeg");
    private double thisval;
    private double x;
    private double y;

    public Block(double x, double y, double val){
        this.thisval = val;
        for (int key:imageCollection.keySet()) {
            if(key == thisval){
                this.image = new Image(x, y, imageCollection.get(key));
            }
        }
    }

    public Point getPosition(){
        return new Point(image.getX(), image.getY());
    }
    public void setPosition(double x, double y){
        this.image.setPosition(x, y);
    }

    public double getVal(){
        return thisval;
    }
    public void setVal(double thisval){
        this.thisval = thisval;
    }
    public Image getBlock(){
        return this.image;
    }
    public void interactWith(Block otherBlock) {
        if(this.getBlock() == otherBlock.getBlock()) {
            combineBlocks(otherBlock);
        }
    }
    public void combineBlocks(Block otherBlock) {
        this.setVal(otherBlock.getVal() * otherBlock.getVal());
    }
 
}