package dmspallas;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game {
    //== constants
    private static final Logger log = (Logger) LoggerFactory.getLogger(GameImpl.class);
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    //== public methods ==
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int guessNumber() {
        return guessCount;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getGuess() {
        return guess;
    }

    @Override
    public int getSmaller() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);

    }

    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess >= number) {
                biggest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }
    //== private methods ==

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
