package brincando.spring5.config;

import brincando.spring5.GuessCount;
import brincando.spring5.MaxNumber;
import brincando.spring5.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==

    //If properties game.maxNumber not found, than 20 is default value.
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    //If properties game.guessNumber not found, than 5 is default value.
    @Value("${game.guessNumber:5}")
    private int guessCount;

    @Value("${game.minNumber:5}")
    private int minNumber;

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

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

}
