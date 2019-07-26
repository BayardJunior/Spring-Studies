package brincando.spring5.config;

import brincando.spring5.GuessCount;
import brincando.spring5.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    // == fields ==

    private int maxNumber = 100;

    private int guessCount = 10;

    // == beans methods ==

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

}
