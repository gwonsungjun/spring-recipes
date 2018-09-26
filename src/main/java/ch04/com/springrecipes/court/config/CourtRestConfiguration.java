package ch04.com.springrecipes.court.config;

import ch04.com.springrecipes.court.domain.Member;
import ch04.com.springrecipes.court.domain.Members;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.Marshaller;

import java.util.Collections;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ch04.com.springrecipes.court")
public class CourtRestConfiguration {

/*    @Bean
    public View membertemplate() {
        return new MarshallingView(jaxb2Mashaller());
    }

    @Bean
    public Marshaller jaxb2Mashaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Members.class, Member.class);
        marshaller.setMarshallerProperties(Collections.singletonMap(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE));
        return marshaller;
    }

    @Bean
    public ViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }*/
}
