package brincando.spring5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloMaven  {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloMaven.class);

    public static void main(String[] args) {
        LOGGER.info("Hello info");
        //System.out.println("Hello Maven");
        LOGGER.debug("Hello Debug");
    }
}
