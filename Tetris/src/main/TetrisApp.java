import board.TetrisBoard;
import drawing.PanelDrawingManager;
import controller.TetrisController;
import frame.*;

public class TetrisApp {
    public static void main(String[] args) {
        TetrisBoard playerTetrisBoard = new TetrisBoard();
        TetrisBoardPanel playerTetrisBoardPanel = new TetrisBoardPanel(playerTetrisBoard);
        PlayerStatusPanel playerStatusPanel = new PlayerStatusPanel();
        PlayerPanel playerPanel = new PlayerPanel(playerTetrisBoardPanel, playerStatusPanel);

        TetrisBoard enemyTetrisBoard = new TetrisBoard();
        TetrisBoardPanel enemyTetrisBoardPanel = new TetrisBoardPanel(enemyTetrisBoard);
        EnemyPanel enemyPanel = new EnemyPanel(enemyTetrisBoardPanel);

        PanelDrawingManager playerPanelDrawingManager = new PanelDrawingManager(playerTetrisBoardPanel, playerStatusPanel);

        TetrisController tetrisController = new TetrisController(playerPanelDrawingManager, playerTetrisBoard);

        TetrisFrame tetrisFrame = new TetrisFrame(tetrisController, playerPanel, enemyPanel);
    }
}
