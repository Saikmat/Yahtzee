import javax.swing.*;

public class GUI extends JFrame {
    public static class NameGUI extends GUI{
        public NameGUI(){
            super();
        }

        public static String playerName() {
            return "";
        }
    }



    /** @noinspection unused*/
    public static class GameGUI extends GUI{
        public GameGUI(){
            super();
        }
    }

    public static class PlayersGUI extends GUI {
        JFrame playerCount = new JFrame("Number Of Players");
        JLabel label = new JLabel("How Many Players are playing (1-8) ");
        JTextField field = new JTextField();
        static int NUM_OF_PLAYERS;

        public PlayersGUI(){
            super();
            playerCount.getContentPane();
            playerCount.add(label);
            playerCount.add(field);
            NUM_OF_PLAYERS = Integer.parseInt(field.getText());
        }

        public static int getNumOfPlayers() {
            return NUM_OF_PLAYERS;
        }
    }

    public static class MainMenu extends GUI{
        JFrame main = new JFrame("Main Menu");
        JLabel label = new JLabel("Label");


        public MainMenu(){
            super();
            JFrame.setDefaultLookAndFeelDecorated(true);
            main.getContentPane();
            main.add(label);
            main.setExtendedState(JFrame.MAXIMIZED_BOTH);
            main.setLocationRelativeTo(null);
            main.setVisible(true);
            main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }
    }


}
