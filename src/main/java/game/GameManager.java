package game;

public class GameManager {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    public GameManager() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();


    }
}
