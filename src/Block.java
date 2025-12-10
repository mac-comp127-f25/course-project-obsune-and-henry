import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
public class Block {
    //private Rectangle block;
    private Image image;
    private Map<Integer,String> imageCollection = Map.of(2,"AbbyMarsh.jpeg",4,"AliciaJohnson.jpeg",8,"Bretjackson.jpeg");
    private int thisval;
    private int index;
    public Game game;

    public Block(int index, int val, Game game){
        this.index = index;
        this.game = game;
        this.thisval = val;
        for (int key:imageCollection.keySet()) {
            if(key == thisval){
                this.image = new Image(game.points.get(index).getX(), game.points.get(index).getY(), imageCollection.get(key));
            }
        }
    }
    public Point getPosition(){
        return new Point(image.getX(), image.getY());
    }
    public void setPosition(int index){
        this.image.setPosition(game.points.get(index).getX(), game.points.get(index).getY());
    }
    public int getVal(){
        return thisval;
    }
    public void setVal(int thisval){
        this.thisval = thisval;
    }
    public Image getBlock(){
        return this.image;
    }
    public void setBlock(int index, Integer val) {
        this.image = new Image(game.points.get(index).getX(), game.points.get(index).getY(), imageCollection.get(val));
    }
    public int getIndex() {
        return this.index;
    }
}