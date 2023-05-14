/** @noinspection ALL */ //remove at the end

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
    private int TopSum = 0;

    private int OnePair = 0;
    private int ThreeKind = 0; // Sum all Dice; hold score
    private int FourKind = 0; // Sum all dice; hold score
    private int FullHouse = 0; // 25
    private int SmallStraight = 0; //30
    private int LargeStraight = 0; // 40
    private int Chance = 0; //Sum dice
    private int Yahtzee = 0; //50

    private final Object[][] scoreboard = {
            {"Aces", this.getAces(),0,0,0,0,0},
            {"Twos", this.getTwos(),0,0,0,0,0},
            {"Threes", this.getThrees(),0,0,0,0,0},
            {"Fours", this.getFours(),0,0,0,0,0},
            {"Fives", this.getFives(),0,0,0,0,0},
            {"Sixes", this.getSixes(),0,0,0,0,0},
            {"Total Sum", this.getTopSum(),0,0,0,0,0},
            {"One Pair", this.getOnePair(),0,0,0,0,0},
            {"Three Of a Kind", this.getThreeKind(),0,0,0,0,0},
            {"Four Of a Kind", this.getFourKind(),0,0,0,0,0},
            {"Full House", this.getFullHouse(),0,0,0,0,0},
            {"Small Straight", this.getSmallStraight(),0,0,0,0,0},
            {"Large Straight", this.getLargeStraight(),0,0,0,0,0},
            {"Chance", this.getChance(),0,0,0,0,0},
            {"Yahtzee", this.getYahtzee(),0,0,0,0,0}
    };


    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public int getAces() {
        return Aces;
    }

    public int getTwos() {
        return Twos;
    }

    public int getThrees() {
        return Threes;
    }

    public int getFours() {
        return Fours;
    }

    public int getFives() {
        return Fives;
    }

    public int getSixes() {
        return Sixes;
    }

    public int getTopSum() {
        return TopSum;
    }

    public int getOnePair() {
        return OnePair;
    }

    public int getThreeKind() {
        return ThreeKind;
    }

    public int getFourKind() {
        return FourKind;
    }

    public int getFullHouse() {
        return FullHouse;
    }

    public int getSmallStraight() {
        return SmallStraight;
    }

    public int getLargeStraight() {
        return LargeStraight;
    }

    public int getChance() {
        return Chance;
    }

    public int getYahtzee() {
        return Yahtzee;
    }

    public Object[][] getScoreboard() {
        return scoreboard;
    }

    public void updateSum(){

    }


    public void updateScore(){

    }

    public int getScore() {
        return score;
    }
}
