
import java.util.Map;
import edu.macalester.graphics.*;
public class Block {
    //private Rectangle block;
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