package syed.ali.moviesapp;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/{imdbId}")
	public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
		return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
	}
	
	@PostMapping("createmovie")
	public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieService.saveMovie(movie),HttpStatus.CREATED);
	}
	
	@DeleteMapping("deletemovie/{id}")
	public String deleteMovie(@PathVariable("id") ObjectId id) {
		movieService.deleteById(id);
		return "successfully deleted";	
		}
	
	@PutMapping("updatemovie")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable("id") ObjectId Id) {
		return new ResponseEntity<Movie>(movieService.updateMovie(movie,Id),HttpStatus.CREATED);
	}
}
