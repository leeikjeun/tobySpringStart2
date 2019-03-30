package springbook2.learningtest.spring.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by adaeng on 30/03/2019.
 */
@Configuration
public class AnnotationHelloConfig {

    @Bean
    public AnnotationHello annotationHello(){
        return new AnnotationHello();
    }
}
