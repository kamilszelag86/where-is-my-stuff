package pl.coderslab.whereismystuff.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.whereismystuff.location.converter.LocationConverter;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("user/login");
        registry.addViewController("/403").setViewName("403");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getLocationConverter());
    }

    @Bean
    public LocationConverter getLocationConverter() {
        return new LocationConverter();
    }

}