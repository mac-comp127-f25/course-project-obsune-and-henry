import edu.macalester.graphics.CanvasWindow;

public class Game {
    public Game() {
        CanvasWindow canvas = new CanvasWindow("2048 (MSCS Department Edition)", 700,700);
        GameBoard board = new GameBoard();
        canvas.add(board.createBorder());
        canvas.add(board.createGrid());
        canvas.draw();
    }

    public static void main(String args[]) {
        new Game();
    }
}
