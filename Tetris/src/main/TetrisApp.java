import controller.TetrisController;
import frame.TetrisFrame;

public class TetrisApp {
    public static void main(String[] args) {
        TetrisController tetrisController = new TetrisController();
        TetrisFrame tetrisFrame = new TetrisFrame(tetrisController);
        tetrisController.generateNewTetromino();
    }
}
