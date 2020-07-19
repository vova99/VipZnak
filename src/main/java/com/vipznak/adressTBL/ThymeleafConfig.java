package com.vipznak.adressTBL;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import java.io.File;


@Configuration
public class ThymeleafConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.
                addResourceHandler("/images/**")
                .addResourceLocations("file:" + System.getProperty("user.home") + File.separator);

    }
}
