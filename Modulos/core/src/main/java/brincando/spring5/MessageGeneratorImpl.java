package brincando.spring5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    //== Dependency inject ==
    private final Game game;

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == init
    @PostConstruct
    public void initMessageImpl(){

        log.info("game -> {}", game);
    }

    // == Public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " +
                game.getBiggest()+ ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()){
            return "You guesses it! The number was:" + game.getNumber();
        }else if (game.isGameLost()) {
            return "You lost. The Number was:" + game.getNumber();
        }else if (!game.isValidNumberRange()){
            return "Invalid number range!";
        }else if (game.getRemainingGuesses() == game.getGuessCount()){
            return "What is you first guess?";
        }else{
            String direction = "Lower";

            if (game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + " You have: " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
