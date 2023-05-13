import com.sun.source.util.TaskListener;

/** @noinspection FieldMayBeFinal*/
public class Player {
    private final String name;
    private int score;

    private final int BONUS_THRESHOLD = 63;
    private int Aces = 0; //Store score for all
    private int Twos = 0;
    private int Threes = 0;
    private int Fours = 0;
    private int Fives = 0;
    private int Sixes = 0;
    private int Sum = 0;

    private int OnePair = 0;
    private int ThreeKind = 0; // Sum all Dice; hold score
    private int FourKind = 0; // Sum all dice; hold score
    private int FullHouse = 0; // 25
    private int SmallStraight = 0; //30
    private int LargeStraight = 0; // 40
    private int Chance = 0; //Sum dice
    private int Yahtzee = 0; //50

    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public Player(String name, int rigged){
        this.name = name;
        if(rigged == 1){
            score = 100; // ;)
        }
    }

    public void updateSum(){

    }


    public void updateScore(){

    }

    public int getScore() {
        return score;
    }
}
