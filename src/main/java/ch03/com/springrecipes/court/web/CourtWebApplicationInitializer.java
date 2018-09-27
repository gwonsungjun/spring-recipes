package ch03.com.springrecipes.court.web;


import ch03.com.springrecipes.court.config.CourtConfiguration;
import ch04.com.springrecipes.court.config.CourtRestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class CourtWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    /*protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CourtConfiguration.class};
    }*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CourtRestConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/"};
    }

}