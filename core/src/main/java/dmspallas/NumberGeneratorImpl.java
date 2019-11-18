package dmspallas;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {
    private final Random random = new Random();
    int maxNumber = 500;

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
