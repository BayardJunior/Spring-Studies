package brincando.spring5.config;

import brincando.spring5.Util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "brincando.spring5")
public class WebConfig implements WebMvcConfigurer {

    // == constants ==
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFIX = ".jsp";

    // == beans methods ==

    @Bean
    public ViewResolver viewResolver(){

        UrlBasedViewResolver urlBasedViewResolver = new InternalResourceViewResolver();
        urlBasedViewResolver.setPrefix(RESOLVER_PREFIX);
        urlBasedViewResolver.setSuffix(RESOLVER_SUFIX);

        return urlBasedViewResolver;
    }

    // will be redirect into home view, very used when no need to user controller.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }
}
