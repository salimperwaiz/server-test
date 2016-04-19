package server.data.model;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;

public class MovieTest {
	
	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
	public void serializesToJSON() throws Exception {
        final Movie movie = new Movie(202, "Raman", "Action", 2004, 3);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/movie.json"), Movie.class));

        assertThat(MAPPER.writeValueAsString(movie)).isEqualTo(expected);
    }
    
    @Test
    public void deserializesFromJSON() throws Exception {
        final Movie movie = new Movie(202, "Raman", "Action", 2004, 3);
        assertThat(MAPPER.readValue(fixture("fixtures/movie.json"), Movie.class))
                .isEqualTo(movie);
    }
	
}
