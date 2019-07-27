package brincando.spring5;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;

    private final int minNumber;

    // == constructor ==

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        //Example min = 5 max = 20 -> max-min= 15 -> range 0-15 + min => 5-20
        return random.nextInt(maxNumber-minNumber)+minNumber;
    }
}
