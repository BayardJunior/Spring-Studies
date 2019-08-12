package brincando.spring5.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DecoupledLogicSetup {

    private final SpringResourceTemplateResolver resolver;

    public DecoupledLogicSetup(SpringResourceTemplateResolver resolver) {
        this.resolver = resolver;
    }

    @PostConstruct
    public void init(){
        resolver.setUseDecoupledLogic(true);
        log.info("Decoupled template logic enable");
    }


}