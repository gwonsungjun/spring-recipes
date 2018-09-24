package ch03.com.springrecipes.court.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("ch03.com.springrecipes.court")
@EnableWebMvc // 유무에 따라 InterceptorConfiguration class의 addInterceptors 실행.
public class CourtConfiguration { }