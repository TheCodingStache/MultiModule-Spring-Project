package dmspallas;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component("generator")
public class NumberGeneratorImpl implements NumberGenerator {
    private final Random random = new Random();
    private int maxNumber = 500;

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
