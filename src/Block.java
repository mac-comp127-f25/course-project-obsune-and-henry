import java.util.Map;

import edu.macalester.graphics.*;
public class Block {
    //private Rectangle block;
    private Image image;
    private Map<Integer,String> imageCollection = Map.of(2,"AbbyMarsh.jpeg",4,"AliciaJohnson.jpeg",8,"Bretjackson.jpeg");
    private int max = 505;
    private int min = 55;

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
    public void moveBlock(String key) {
        if(this.image.getPosition().getX() >= 55 && this.image.getPosition().getX() <= 505 && this.image.getPosition().getY() >= 55 && this.image.getPosition().getY() <= 505) {
            if (key == "UP_ARROW") {
                this.image.setPosition(image.getPosition().getX(), min);
            }
        }
    }
}