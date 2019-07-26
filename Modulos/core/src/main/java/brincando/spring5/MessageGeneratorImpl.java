package brincando.spring5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    //== Dependency inject ==
    @Autowired
    private Game game;

    // == init
    @PostConstruct
    public void initMessageImpl(){

        LOGGER.info("game -> {}", game);
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
