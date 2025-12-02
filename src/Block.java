import edu.macalester.graphics.*;

public class Block {

    private Rectangle block;
    private Image image;


    public Block(double x, double y){

        Point size = new Point(140, 140);

        // this.block = new Rectangle(location, size);
        // this.block.setFillColor(Color.GRAY);
        // alicia = new Rectangle(location, size);
        this.image = new Image(x, y, "AbbyMarsh.jpeg");
    }

    public Image getBlock(){
        return this.image;
    }
}
