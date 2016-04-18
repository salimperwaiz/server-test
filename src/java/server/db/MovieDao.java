package server.db;

import java.util.List;
import org.hibernate.SessionFactory;
import io.dropwizard.hibernate.AbstractDAO;
import server.data.model.Movie;


public class MovieDao extends AbstractDAO<Movie>{

	   public MovieDao(SessionFactory factory) {
	        super(factory);
	    }

	    @SuppressWarnings("unchecked")
		public List<Movie> getAll() {
	        return (List<Movie>) currentSession().createCriteria(Movie.class).list();
	    }

	    /**
	     * 
	     * @param id
	     * @return Movie
	     */
	    public Movie findById(int id) {
	        return (Movie) currentSession().get(Movie.class, id);
	    }
	    
	    /**
	     * 
	     * @param movie
	     */
	    public void delete(Movie movie) {
	        currentSession().delete(movie);
	    }

	    /**
	     * 
	     * @param movie
	     */
	    public void update(Movie movie) {
	        currentSession().saveOrUpdate(movie);
	    }

	    /**
	     * 
	     * @param movie
	     * @return
	     */
	    public Movie insert(Movie movie) {
	        return persist(movie);
	    }
}
