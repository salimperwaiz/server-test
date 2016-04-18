package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import server.config.AppConfiguration;
import server.data.model.Movie;
import server.db.MovieDao;
import server.healthcheck.AppHealthCheck;
import server.mapper.RuntimeExceptionMapper;
import server.resources.MovieResource;
import server.resources.TimeResource;

/**
 * Main application
 */
public class MainApplication extends Application<AppConfiguration> {
	final static Logger logger = LoggerFactory.getLogger(MainApplication.class);

	public static void main(String[] args) throws Exception {
		new MainApplication().run(args);
	}
	
	   private final HibernateBundle<AppConfiguration> hibernate = new HibernateBundle<AppConfiguration>(Movie.class) {
	        @Override
	        public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
	            return configuration.getDatabaseAppDataSourceFactory();
	        }
	    };

	@Override
	public String getName() {
		return "Test Server";
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		// framework bootstrap initialization
		bootstrap.addBundle(hibernate);
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) throws Exception {
		try {
			logger.info("Starting...");

			final MovieResource movieResource = new MovieResource(new MovieDao(hibernate.getSessionFactory()));
			final TimeResource timeResource = new TimeResource();
			final RuntimeExceptionMapper exceptionMapper = new RuntimeExceptionMapper();
			
			environment.jersey().register(movieResource);
			environment.jersey().register(timeResource);
			environment.jersey().register(exceptionMapper);
			
		} catch (Exception exc) {
			// log failure to set up app
			logger.error("Failed to initialize application, exiting...", exc);
			throw new RuntimeException();
		}

		environment.healthChecks().register("app", new AppHealthCheck());

		// register servlet route handlers
		// environment.jersey().register(new YourServlet());
		// {"id": 113, "name": "Mockingjay", "genre": "Action", "year_released":
		// 1460602222975, "rating": 3.2}
	}
}
