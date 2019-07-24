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

    // === fields ==
    private int guessCount = 10;

    // == init
    @PostConstruct
    public void initMessageImpl(){

        LOGGER.info("game -> {}", game);
    }

    // == Public methods ==
    @Override
    public String getMainMessage() {
        return "Calling method MainMessage";
    }

    @Override
    public String getResultMessage() {
        return "Calling method ResultMessage";
    }
}
