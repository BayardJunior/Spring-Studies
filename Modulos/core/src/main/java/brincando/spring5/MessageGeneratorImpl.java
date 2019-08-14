package brincando.spring5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    public static final String MAIN_MESSAGE = "game.main.message";
    public static final String RESULT_MESSAGE = "game.result.message";

    //== Dependency inject ==
    private final Game game;
    private final MessageSource messageSource;

    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    // == init
    @PostConstruct
    public void initMessageImpl(){

        log.info("game -> {}", game);
    }

    // == Public methods ==
    @Override
    public String getMainMessage() {

        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
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

    private String getMessage(String code, Object...args){

        return messageSource.getMessage(code,args, LocaleContextHolder.getLocale());
    }
}
