import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI extends JFrame {

    public GUI(){

    }

    public static class NameGUI extends GUI{
        public NameGUI(){
            super();
        }

        public static String playerName() {
            return "";
        }
    }



    /** @noinspection unused*/
    public static class GameGUI extends GUI implements ItemListener {
        int turncount;

        JFrame frame = new JFrame("Yahtzee");
        JPanel labelPanel = new JPanel();
        static JPanel dicePanel = new JPanel();
        JPanel holdPanel = new JPanel();
        JPanel scorePanel = new JPanel();

        JLabel Dice1 = new JLabel();
        JLabel Dice2 = new JLabel();
        JLabel Dice3 = new JLabel();
        JLabel Dice4 = new JLabel();
        JLabel Dice5 = new JLabel();

        JCheckBox Dice1Box = new JCheckBox("Keep");
        JCheckBox Dice2Box = new JCheckBox("Keep");
        JCheckBox Dice3Box = new JCheckBox("Keep");
        JCheckBox Dice4Box = new JCheckBox("Keep");
        JCheckBox Dice5Box = new JCheckBox("Keep");
        JButton RollButton = new JButton("Roll");
        JButton[] scoreButtons = new JButton[13];
        JTable scoreboard = null;
        static ArrayList<Integer> holds = new ArrayList<>();

        public GameGUI(Player player){
            super();
            turncount = 1;
            frame.getContentPane();
            labelPanel.setLayout(new GridLayout());
            dicePanel.setLayout(new GridLayout());
            holdPanel.setLayout(new GridLayout());
            scorePanel.setLocation(frame.getSize().width - scorePanel.getWidth() - 10, 10);

            frame.add(labelPanel);
            frame.add(dicePanel);
            frame.add(holdPanel);
            frame.add(scorePanel);

            labelPanel.add(Dice1);
            labelPanel.add(Dice2);
            labelPanel.add(Dice3);
            labelPanel.add(Dice4);
            labelPanel.add(Dice5);

            holdPanel.add(Dice1Box);
            holdPanel.add(Dice2Box);
            holdPanel.add(Dice3Box);
            holdPanel.add(Dice4Box);
            holdPanel.add(Dice5Box);

            scorePanel.add(scoreboard);

            Arrays.fill(scoreButtons, new JButton());

            Dice1Box.addItemListener(this);
            Dice2Box.addItemListener(this);
            Dice3Box.addItemListener(this);
            Dice4Box.addItemListener(this);
            Dice5Box.addItemListener(this);
            RollButton.addItemListener(this);
            for (JButton scoreButton : scoreButtons) {
                scoreButton.addItemListener(this);
            }

            String[] colNames = {"Type","Live Score","Round 1 Score","Round 2 Score","Round 3 Score","Round 4 Score",
                                "Round 5 Score"};

            Object[][] boardWithButtons =
                    new Object[player.getScoreboard().length][player.getScoreboard()[0].length + 1];
            for (int i = 0; i < player.getScoreboard().length; i++) {
                System.arraycopy(player.getScoreboard()[i], 0, boardWithButtons[i], 0, player.getScoreboard()[0].length);
                boardWithButtons[i][boardWithButtons.length - 1] = scoreButtons[i];
            }
            ScoreboardTableModel scoreboardTableModel = new ScoreboardTableModel(player.getScoreboard(),
                    colNames);
            scoreboard = new JTable(scoreboardTableModel);
            scoreboard.setDefaultRenderer(JButton.class,
                    new JTableButtonRenderer(scoreboard.getDefaultRenderer(JButton.class)));


            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setVisible(true);
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (Dice1Box.equals(source)) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    holds.add(1);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    holds.remove(Integer.valueOf(1));
                }
            } else if (Dice2Box.equals(source)) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    holds.add(2);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    holds.remove(Integer.valueOf(2));
                }
            } else if (Dice3Box.equals(source)) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    holds.add(3);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    holds.remove(Integer.valueOf(3));
                }
            } else if (Dice4Box.equals(source)) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    holds.add(4);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    holds.remove(Integer.valueOf(4));
                }
            } else if (Dice5Box.equals(source)) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    holds.add(5);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    holds.remove(Integer.valueOf(5));
                }
            } else if (RollButton.equals(source)){
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (turncount == 3) {
                        return;
                    }
                    turncount++;
                    Main.ReRoll();
                }
            }
        }

        public static void updateDice(int num, int currentDice){
            switch (num) {
                case 1 -> {
                    dicePanel.add(Dice.ONE.display());
                    dicePanel.getComponent(currentDice).setLocation(dicePanel.getX() * currentDice + 10,
                            dicePanel.getY() * currentDice + 10);
                }
                case 2 -> {
                    dicePanel.add(Dice.TWO.display());
                    dicePanel.getComponent(currentDice).setLocation(dicePanel.getX() * currentDice + 10,
                            dicePanel.getY() * currentDice + 10);
                }
                case 3 -> {
                    dicePanel.add(Dice.THREE.display());
                    dicePanel.getComponent(currentDice).setLocation(dicePanel.getX() * currentDice + 10,
                            dicePanel.getY() * currentDice + 10);
                }
                case 4 -> {
                    dicePanel.add(Dice.FOUR.display());
                    dicePanel.getComponent(currentDice).setLocation(dicePanel.getX() * currentDice + 10,
                            dicePanel.getY() * currentDice + 10);
                }
                case 5 -> {
                    dicePanel.add(Dice.FIVE.display());
                    dicePanel.getComponent(currentDice).setLocation(dicePanel.getX() * currentDice + 10,
                            dicePanel.getY() * currentDice + 10);
                }
                case 6 -> {
                    dicePanel.add(Dice.SIX.display());
                    dicePanel.getComponent(currentDice).setLocation(dicePanel.getX() * currentDice + 10,
                            dicePanel.getY() * currentDice + 10);
                }
            } // no need for default, exhaustive
        }

        public static void ReRollDice(int num, int currentDice){
            ReRollDice(num, currentDice, holds);
        }

        private static void ReRollDice(int num, int currentDice, ArrayList<Integer> holds){
            if(holds.contains(currentDice)){
                return;
            }
            dicePanel.remove(currentDice);
            updateDice(num, currentDice);
        }

        private static boolean contains(int[] arr, int num){
            for(int i : arr){
                if( i == num){
                    return true;
                }
            }
            return false;
        }

        protected enum Dice {
            ONE(new JLabel(new ImageIcon(("assets\\die3.png")))),
            TWO(new JLabel(new ImageIcon("assets\\die2.png"))),
            THREE(new JLabel(new ImageIcon("assets\\die3.png"))),
            FOUR(new JLabel(new ImageIcon("assets\\die4.png"))),
            FIVE(new JLabel(new ImageIcon("assets\\die5.png"))),
            SIX(new JLabel(new ImageIcon("assets\\die6.png")));

            private final JLabel image;

            Dice(JLabel label) {
                this.image = label;
            }

            public JLabel display() {
                return this.image;
            }
        }

    }

    public static class PlayersGUI extends GUI implements ActionListener {
        JFrame playerCount = new JFrame("Number Of Players");
        JLabel label = new JLabel("How Many Players are playing (1-8) ");
        JTextField field = new JTextField();
        JButton button = new JButton("Submit");
        static int NUM_OF_PLAYERS;

        public PlayersGUI() {
            super();
            playerCount.getContentPane().setLayout(new GridLayout(1, 3));
            playerCount.add(label);
            playerCount.add(field);
            playerCount.add(button);
            playerCount.pack();
            button.addActionListener(this);
            playerCount.setVisible(true);
            playerCount.setLocationRelativeTo(null);
            playerCount.setAlwaysOnTop(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //noinspection StatementWithEmptyBody
            if (e.getSource() == button) {

            }
        }

        @SuppressWarnings("unused")
        public static int getNumOfPlayers() {
            return NUM_OF_PLAYERS;
        }
    }

    public static class MainMenu extends GUI{
        JFrame main = new JFrame("Main Menu");


        public MainMenu(){
            super();
            JFrame.setDefaultLookAndFeelDecorated(true);
            main.getContentPane();
            main.setExtendedState(JFrame.MAXIMIZED_BOTH);
            main.setLocationRelativeTo(null);
            main.setVisible(true);
            main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }


}
