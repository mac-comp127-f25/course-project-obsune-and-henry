import edu.macalester.graphics.*;

public class Block {

    //private Rectangle block;
    private Image image;


    public Block(double x, double y, double val){

        //Point size = new Point(140, 140);
        // this.block = new Rectangle(location, size);
        // this.block.setFillColor(Color.GRAY);
        // alicia = new Rectangle(location, size);
        if(val == 2){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }
        if(val == 4){
            this.image = new Image(x, y, "AliciaJohnson.jpeg");
        }
        if(val == 8){
            this.image = new Image(x, y, "Bretjackson.jpeg");
        }
        if(val == 16){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }
        if(val ==32){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }
        if(val == 64){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }
        if(val == 128){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }
        if(val == 256){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }
        if(val == 512){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }
        if(val == 1024){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }
        if(val == 2048){
            this.image = new Image(x, y, "AbbyMarsh.jpeg");
        }

    }

    public Image getBlock(){
        return this.image;
    }
}
