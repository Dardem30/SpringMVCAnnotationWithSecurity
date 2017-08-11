package by.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by УВД on 11.08.2017.
 */
public class AppInicializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RepositoryConfig.class,SecurityConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfigSpringMVC.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
