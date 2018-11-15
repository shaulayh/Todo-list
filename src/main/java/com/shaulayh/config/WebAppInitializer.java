package com.shaulayh.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    public static final String DISPATCHER = "Dispatch";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        log.info("Web server starts");
        // Creating context for Web Application
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // Adding the configuration file
        context.register(WebConfig.class);

        // MVC need the dispatch servlet to start
        // don't forget to add the context to the dispatcher
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        //NOTE: need to register the dispatcher and servlet context
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet(DISPATCHER, dispatcherServlet);

        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");

    }
}
