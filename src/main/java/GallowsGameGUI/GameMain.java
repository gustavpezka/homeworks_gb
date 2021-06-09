package GallowsGameGUI;



public class GameMain {
    public static void main(String[] args) {

        PrepareWord prepareWord = new PrepareWord();
        GameWindow gameWindow = new GameWindow(prepareWord.pickRandomWord());
    }
}
