import java.util.ArrayList;
import java.util.Random;

public class Main {
    static int NUM_OF_PLAYERS;
    Random dice = new Random(System.nanoTime());
    ArrayList<Player> players = new ArrayList<>();
    private int turn = 0;

    public static void main(String[] args) {
        GUI.MainMenu mainMenu = new GUI.MainMenu();
        GUI.PlayersGUI playersGUI = new GUI.PlayersGUI();
        NUM_OF_PLAYERS = GUI.PlayersGUI.getNumOfPlayers();
    }

    public void game(){
        GUI.GameGUI gameGUI = new GUI.GameGUI();

    }

    public void makePlayers(){
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            GUI.NameGUI nameGUI = new GUI.NameGUI();
            players.add(new Player(GUI.NameGUI.playerName()));
        }
    }

    private void advanceTurn(){
        turn = turn == NUM_OF_PLAYERS - 1 ? 0 : turn + 1;
    }
}
