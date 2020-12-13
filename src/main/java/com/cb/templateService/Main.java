package com.cb.templateService;

import com.cb.templateService.api.TemplateResource;
import com.cb.templateService.database.DAO.TemplatesDAO;
import com.cb.templateService.database.Database;
import com.cb.templateService.services.TemplateService;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class Main extends io.dropwizard.Application<Database> {

    @Override
    public void initialize(Bootstrap<Database> bootstrap) {

    }

    @Override
    public void run(Database configuration, Environment environment) throws Exception {
        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");


        final DBIFactory dbiFactory = new DBIFactory();
        final DBI dbi = dbiFactory.build(environment, configuration.getDataSourceFactory(), "mysql");
        final TemplatesDAO templatesDAO = dbi.onDemand(TemplatesDAO.class);
        TemplateService templateService = new TemplateService(templatesDAO);
        TemplateResource templateResource = new TemplateResource(templateService);
        environment.jersey().register(templateResource);
    }
    public static void main(String[] args) throws Exception{
        new Main().run(new String[]{"server", "config/config.yml"});
    }
}
