package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController

public class MovieController {
    @Autowired
    MovieService movieService;
  @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
String response = movieService.addMovie(movie);
return new ResponseEntity<>(response, HttpStatus.OK);
    }

@PostMapping("/movies/add-director")
public ResponseEntity<String> addDirector(@RequestBody() Director director){
    String response = movieService.addDirector(director);
    return new ResponseEntity<>(response, HttpStatus.OK);
}
@PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("directorName") String directorName){

      String response = movieService.addMovieDirectorPair(movieName,directorName);

    return new ResponseEntity<>(response,HttpStatus.CREATED);
}
@GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
      Movie m = movieService.getMovieByName(name);
      return new ResponseEntity<>(m,HttpStatus.OK);
}
@GetMapping("/movies/get-director-by-name/{name}")
public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
    Director d = movieService.getDirectorByName(name);
    return new ResponseEntity<>(d,HttpStatus.OK);
}
@GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List> getMoviesByDirectorName(@PathVariable("name")String name){
     // List l=;
      return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.OK);
}
@GetMapping("/movies/get-all-movies")
    public ResponseEntity<List> findAllMovies(){
      return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.CREATED);
}
@DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
      String s = movieService.deleteDirectorByName(name);
      return new ResponseEntity<>(s,HttpStatus.CREATED);
}
@DeleteMapping("/movies/delete-all-directors")
public ResponseEntity<String> deleteAllDirectors(){
      String s = movieService.deleteAllDirectors();
      return new ResponseEntity<>(s,HttpStatus.CREATED);
}




}
