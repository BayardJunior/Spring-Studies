package brincando.spring5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";
    public static void main(String[] args) {

        LOGGER.info("Guess the number");

        //create context (container)

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        //call method next to get a random number

        int number = numberGenerator.next();

        //log generated number
        LOGGER.info("numer = {}", number);

        //close context (container)
        context.close();
    }
}
