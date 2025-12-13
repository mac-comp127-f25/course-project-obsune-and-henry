import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
public class GameBoard {
    public List<GraphicsText> keyBoard = new ArrayList<>();
    public Rectangle board;

    public GameBoard() {
    }
    /**
     * Creates a game board with 4 internal, vertical lines, 4 internal 
     * horizontal lines, and 4 lines to make the border.
     * In all, there are 16 total boxes 
     * @return
     */
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
    public GraphicsGroup createKeyBoard() {
        GraphicsGroup keyBoard = new GraphicsGroup();
        Rectangle board = new Rectangle(700, 125, 225, 300);
        board.setFillColor(Color.GRAY);
        keyBoard.add(board);
        GraphicsText abby = new GraphicsText("Abby Marsh: 2", 750, 150);
        abby.setFillColor(Color.RED);
        keyBoard.add(abby);
        GraphicsText alicia = new GraphicsText("Alicia Johnson: 4", 750, 175);
        alicia.setFillColor(Color.ORANGE);
        keyBoard.add(alicia);
        GraphicsText bret = new GraphicsText("Bret Jackson: 8", 750, 200);
        bret.setFillColor(Color.YELLOW);
        keyBoard.add(bret);
        GraphicsText dan = new GraphicsText("Dan Drake: 16", 750, 225);
        dan.setFillColor(Color.GREEN);
        keyBoard.add(dan);
        GraphicsText getiria = new GraphicsText("Getiria Onsongo: 32", 750, 250);
        getiria.setFillColor(Color.BLUE);
        keyBoard.add(getiria);
        GraphicsText lian = new GraphicsText("Lian Duan: 64", 750, 275);
        lian.setFillColor(new Color(75, 0, 130));
        keyBoard.add(lian);
        GraphicsText paul = new GraphicsText("Paul Cantrell: 128", 750, 300);
        paul.setFillColor(new Color(128, 0, 255));
        keyBoard.add(paul);
        GraphicsText shilad = new GraphicsText("Shilad Sen: 256", 750, 325);
        shilad.setFillColor(Color.RED);
        keyBoard.add(shilad);
        GraphicsText suhas = new GraphicsText("Suhas Arehalli: 512", 750, 350);
        suhas.setFillColor(Color.ORANGE);
        keyBoard.add(suhas);
        GraphicsText susan = new GraphicsText("Susan Fox: 1024", 750, 375);
        susan.setFillColor(Color.YELLOW);
        keyBoard.add(susan);
        GraphicsText william = new GraphicsText("William Mitchell: 2048!", 750, 400);
        william.setFillColor(Color.GREEN);
        keyBoard.add(william);
        return keyBoard;
    }
}