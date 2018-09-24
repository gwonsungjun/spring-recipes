package ch03.com.springrecipes.court.web;


import ch03.com.springrecipes.court.config.CourtConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class CourtWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CourtConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/"};
    }

}