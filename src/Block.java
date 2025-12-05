import java.util.Map;
import edu.macalester.graphics.*;
public class Block {
    //private Rectangle block;
    private Image image;
    private Map<Integer,String> imageCollection = Map.of(2,"AbbyMarsh.jpeg",4,"AliciaJohnson.jpeg",8,"Bretjackson.jpeg");



    public Block(double x, double y, int val){
        for (int key:imageCollection.keySet()) {
            if(key == val){
                this.image = new Image(x, y, imageCollection.get(key));
            }
        }
    }
    public Image getBlock(){
        return this.image;
    }
}