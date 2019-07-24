package brincando.spring5.console;

import brincando.spring5.AppConfig;
import brincando.spring5.Game;
import brincando.spring5.MessageGenerator;
import brincando.spring5.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Guess the number");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generated bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next to get a random number
        int number = numberGenerator.next();

        // log generated number
        LOGGER.info("numer = {}", number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // get message generated bean from context (Container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        // log generated main message
        LOGGER.info("Main Message = {}",messageGenerator.getMainMessage());

        // log generated result message
        LOGGER.info("Result Message = {}",messageGenerator.getResultMessage());

        // close context (container)
        context.close();
    }
}
