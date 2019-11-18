package dmspallas;

public interface Game {
    int getNumber();

    int guessNumber();

    void setGuess(int guess);

    int getSmaller();

    int getBiggest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

}
