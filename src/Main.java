import java.util.ArrayList;
import java.util.Random;

public class Main {
    static int NUM_OF_PLAYERS;
    static Random dice = new Random(System.nanoTime());
    static ArrayList<Player> players = new ArrayList<>();
    private static int turn = 0;

    public static void main(String[] args) {
        GUI.MainMenu mainMenu = new GUI.MainMenu();
        GUI.PlayersGUI playersGUI = new GUI.PlayersGUI();
    }

    public static void setNumOfPlayers(int numOfPlayers) {
        NUM_OF_PLAYERS = numOfPlayers;
    }

    public void makePlayers() {
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            GUI.NameGUI nameGUI = new GUI.NameGUI();
            players.add(new Player(GUI.NameGUI.playerName()));
        }
    }


    public static void game() {
        int count = 1;
        while (count < 13) {
            //display the game screen
            GUI.GameGUI gameGUI = new GUI.GameGUI(players.get(turn));
            //display the dice for first turn
            for (int i = 1; i <= 5; i++) {
                int diceRoll = dice.nextInt(1, 7);
                GUI.GameGUI.updateDice(diceRoll, i);
            }
            //user selects what they want to hold in GUI

            //re-roll the remaining dice passed through GUI

            //let user select which score they want to use

            advanceTurn();
            ++count;
        }
    }

    public static void ReRoll(){
        for (int i = 0; i < 5; i++) {
            GUI.GameGUI.ReRollDice(1, i);
        }
    }



    private static void advanceTurn(){
        turn = turn == NUM_OF_PLAYERS - 1 ? 0 : turn + 1;
    }
}
