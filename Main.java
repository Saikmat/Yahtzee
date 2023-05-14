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
    public void makePlayers(){
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            GUI.NameGUI nameGUI = new GUI.NameGUI();
            players.add(new Player(GUI.NameGUI.playerName()));
        }
    }


    public void game(){
        //display the game screen
        GUI.GameGUI gameGUI = new GUI.GameGUI(players.get(turn));
        //display the dice for first turn
        for (int i = 1; i <= 5; i++) {
            int diceRoll = dice.nextInt(1, 7);
            gameGUI.updateDice(diceRoll, i);
        }
        //user selects what they want to hold

        //re-roll the remaining dice
        for (int i = 0; i < 5; i++) {
            gameGUI.ReRollDice(1, i);
        }

        advanceTurn();
    }



    private void advanceTurn(){
        turn = turn == NUM_OF_PLAYERS - 1 ? 0 : turn + 1;
    }
}
