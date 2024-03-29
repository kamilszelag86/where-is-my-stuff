package pl.coderslab.whereismystuff.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.whereismystuff.location.converter.LocationConverter;

import java.nio.file.Path;
import java.nio.file.Paths;

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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("item-images", registry);
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        if (dirName.startsWith("../")) {
            dirName = dirName.replace("../", "");
        }

        registry.addResourceHandler("/" + dirName + "/**")
                .addResourceLocations("file://" + uploadPath + "/");
    }

}