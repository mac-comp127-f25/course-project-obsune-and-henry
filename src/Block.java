import java.util.Map;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
public class Block {
    //private Rectangle block;
    private Image image;
    private Map<Integer,String> imageCollection = Map.of(2,"AbbyMarsh.jpeg",4,"AliciaJohnson.jpeg",8,"Bretjackson.jpeg");
    private int max = 505;
    private int min = 55;
    private int thisval;

    public Block(double x, double y, int val){
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
    public int getVal(){
        return thisval;
    }

    public Image getBlock(){
        return this.image;
    }
    public void moveBlock(Key key) {
        System.out.println("It's getting called");
        Key up = Key.UP_ARROW;
        if(this.image.getPosition().getX() >= 55 && this.image.getPosition().getX() <= 505 && this.image.getPosition().getY() >= 55 && this.image.getPosition().getY() <= 505) {
            if (key == up) {
                this.image.setPosition(image.getPosition().getX(), min);
                System.out.println("Yes");
            }
        }
    }
}