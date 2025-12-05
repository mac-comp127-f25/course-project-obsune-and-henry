import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.GraphicsGroup;
import java.awt.Color;

public class GameBoard {

    public Rectangle border;

    public GameBoard() {
    }

    public GraphicsGroup createGrid() {
        GraphicsGroup grid = new GraphicsGroup();

        //-----vertical------
        Line line = new Line(200, 50, 200, 650);
        line.setStrokeWidth(10);
        grid.add(line);
        Line line1 = new Line(350, 50, 350, 650);
        line1.setStrokeWidth(10);
        grid.add(line1);
        Line line2 = new Line(500, 50, 500, 650);
        line2.setStrokeWidth(10);
        grid.add(line2);
        //-----horizontal----//
        Line line3 = new Line(50, 200, 650, 200);
        line3.setStrokeWidth(10);
        grid.add(line3);
        Line line4 = new Line(50, 350, 650, 350);
        line4.setStrokeWidth(10);
        grid.add(line4);
        Line line5 = new Line(50, 500, 650, 500);
        line5.setStrokeWidth(10);
        grid.add(line5);

        //----Border-----
        Line border1 = new Line(50, 50, 650, 50);
        grid.add(border1);
        border1.setStrokeWidth(10);
        border1.setStrokeColor(Color.BLACK);
        Line border2 = new Line(650, 50, 650, 650);
        grid.add(border2);
        border2.setStrokeWidth(10);
        border2.setStrokeColor(Color.BLACK);
        Line border3 = new Line(50, 650, 650, 650);
        grid.add(border3);
        border3.setStrokeWidth(10);
        border3.setStrokeColor(Color.BLACK);
        Line border4 = new Line(50, 50, 50, 650);
        grid.add(border4);
        border4.setStrokeWidth(10);
        border4.setStrokeColor(Color.BLACK);
        return grid;
    }
}
