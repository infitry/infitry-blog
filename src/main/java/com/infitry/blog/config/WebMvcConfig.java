package com.infitry.blog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @since 2020. 4. 20.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : WebMvc Configuration
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
    @Bean
    public ModelMapper modelMapper() {
    	return new ModelMapper();
    }
}
