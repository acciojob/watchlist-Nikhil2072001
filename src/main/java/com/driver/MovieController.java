package com.driver;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")

public class MovieController {
    @Autowired
    MovieService movieService;
  @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
String response = movieService.addMovie(movie);
return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

@PostMapping("/movies/add-director")
public ResponseEntity<String> addDirector(@RequestBody() Director director){
    String response = movieService.addDirector(director);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}
@PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("directorName") String directorName){

      String response = movieService.addMovieDirectorPair(movieName,directorName);

    return new ResponseEntity<>(response,HttpStatus.CREATED);
}
@GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
      Movie m = movieService.getMovieByName(name);
      return new ResponseEntity<>(m,HttpStatus.CREATED);
}
@GetMapping("/movies/get-director-by-name/{name}")
public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
    Director d = movieService.getDirectorByName(name);
    return new ResponseEntity<>(d,HttpStatus.CREATED);
}
@GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
    List<String> movies = movieService.getMoviesByDirectorName(director);
    return new ResponseEntity<>(movies,HttpStatus.CREATED);
}
@GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){


    List<String> movies = movieService.findAllMovies();
    return new ResponseEntity<>(movies, HttpStatus.CREATED);

}
@DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String director){
      String s = movieService.deleteDirectorByName(director);
      return new ResponseEntity<>(s,HttpStatus.CREATED);
}
@DeleteMapping("/movies/delete-all-directors")
public ResponseEntity<String> deleteAllDirectors(){
      String s = movieService.deleteAllDirectors();
      return new ResponseEntity<>(s,HttpStatus.CREATED);
}




}
