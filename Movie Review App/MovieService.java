package syed.ali.moviesapp;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
		
		@Autowired
		private MovieRepo movieRepository;
		
		public List<Movie> allMovies(){
			return movieRepository.findAll();
	}
		public Optional<Movie> singleMovie(String imdbId) {
			return movieRepository.findByImdbId(imdbId);
		}
		public Movie saveMovie(Movie movie) {
			// TODO Auto-generated method stub
			return movieRepository.save(movie);
		}
		public void deleteById(ObjectId id) {
			// TODO Auto-generated method stub
			movieRepository.deleteById(id);
		}
		public Movie updateMovie(Movie movie, ObjectId Id) {
			// TODO Auto-generated method stub
			Movie movie1 = movieRepository.findById(Id).orElseThrow(() -> new MovieNotFoundException("Movie","Id",Id));
			movie1.setImdbId(movie1.getImdbId());
			movie1.setTitle(movie1.getTitle());
			movie1.setReleaseDate(movie1.getReleaseDate());
			movie1.setTrailerLink(movie1.getTrailerLink());
			movie1.setPoster(movie1.getImdbId());
			movieRepository.save(movie);
			return movie1;
		}
}
