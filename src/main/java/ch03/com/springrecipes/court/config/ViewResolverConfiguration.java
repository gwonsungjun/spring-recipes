package ch03.com.springrecipes.court.config;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/*public class ViewResolverConfiguration implements WebMvcConfigurer, ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    public ViewResolverConfiguration(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public ViewResolver viewResolver() {
        XmlViewResolver viewResolver = new XmlViewResolver();
        // 기본적으로 /WEB-INF/views.xml 파일에서 뷰 빈을 읽지만, location 프로퍼티로 위치를 달리 할 수 있음.
        viewResolver.setLocation(resourceLoader.getResource("/WEB-INF/court-views.xml"));
        return viewResolver;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

}*/
@Configuration
public class ViewResolverConfiguration {

    @Bean
    public ResourceBundleViewResolver viewResolver(){
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setOrder(0);
        viewResolver.setBasename("court-views");
        return viewResolver;
    }

    // 템플릿명과 위치에 따라 뷰 해석.
    // 항상 뷰를 해석하므로 우선순위를 가장 낮게 할당
    // InternalResourceViewResolver로 해석할 수 없는 뷰만 court-views.properties 리소스 번들 파일에 기재
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
