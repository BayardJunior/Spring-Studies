package brincando.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "brincando.spring5")
public class AppConfig {

    //== bean methods ==
}