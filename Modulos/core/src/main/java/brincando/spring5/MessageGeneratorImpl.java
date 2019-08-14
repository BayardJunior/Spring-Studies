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
    public static final String RESULT_MESSAGE_GAME_WIN = "game.win";
    public static final String RESULT_MESSAGE_GAME_LOST = "game.lost";
    public static final String RESULT_MESSAGE_INVALID_RANGE = "game.invalid.range";
    public static final String RESULT_MESSAGE_FIRST_GUESS = "game.first.guess";
    public static final String RESULT_MESSAGE_DIRECTION = "game.direction";
    public static final String RESULT_MESSAGE_HIGHER = "game.higher";
    public static final String RESULT_MESSAGE_LOWER = "game.lower";


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
            return getMessage(RESULT_MESSAGE_GAME_WIN, game.getNumber());
        }else if (game.isGameLost()) {
            return getMessage(RESULT_MESSAGE_GAME_LOST, game.getNumber());
        }else if (!game.isValidNumberRange()){
            return getMessage(RESULT_MESSAGE_INVALID_RANGE);
        }else if (game.getRemainingGuesses() == game.getGuessCount()){
            return getMessage(RESULT_MESSAGE_FIRST_GUESS);
        }else{
            String direction = getMessage(RESULT_MESSAGE_LOWER);

            if (game.getGuess() < game.getNumber()){
                direction = getMessage(RESULT_MESSAGE_HIGHER);
            }
            return getMessage(RESULT_MESSAGE_DIRECTION, direction, game.getRemainingGuesses());
        }
    }

    private String getMessage(String code, Object...args){

        return messageSource.getMessage(code,args, LocaleContextHolder.getLocale());
    }
}
