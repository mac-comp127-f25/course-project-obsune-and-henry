import java.awt.Color;
import edu.macalester.graphics.*;

public class Block {

    private Rectangle block;

    public Block(Point location){

        Point size = new Point(140, 140);

        this.block = new Rectangle(location, size);
        this.block.setFillColor(Color.GRAY);
    }

    public Rectangle getBlock(){
        return this.block;
    }
}
