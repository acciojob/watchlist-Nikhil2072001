package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
   HashMap<String,Movie> movieDB;
    HashMap<String,Director> directorDB;
//  HashMap<String,String> mapDB = new HashMap<>();
  HashMap<String,List<String>> movieDirectorDB;

    public MovieRepository() {
        this.movieDB = new HashMap<String, Movie>();
        this.directorDB = new HashMap<String, Director>();

        this.movieDirectorDB = new HashMap<String, List<String>>();

    }

    public  String addMovie(Movie movie){

        String key = movie.name;
        //Add it to the studentDb
       movieDB.put(key,movie);

        return "success ";

    }
    public  String addDirector(Director director){

        String key = director.name;
        //Add it to the studentDb
        directorDB.put(key,director);

        return "success ";

    }
//Pair p = new Pair(movieName,directorName);


public String addMovieDirectorPair(String movieName,String directorName){
       List<String> l = new ArrayList<>();
       if(movieDirectorDB.containsKey(directorName)){
           l= movieDirectorDB.get(directorName);
           l.add(movieName);
           movieDirectorDB.put(directorName,l);
       }else{
           l.add(movieName);
           movieDirectorDB.put(directorName,l);
       }
       return "success";
}


public Movie getMovieByName(String name){
       if(movieDB.containsKey(name))
           return movieDB.get(name);
       return null;
}
    public Director getDirectorByName(String name){

        if(directorDB.containsKey(name))
            return directorDB.get(name);
        return null;
    }
public List getMoviesByDirectorName(String name){
       List<String> l = new ArrayList<>();
if(movieDirectorDB.containsKey(name)){
    l=movieDirectorDB.get(name);
    return l;
}
return l;
}
public List findAllMovies(){
       List<String> l = new ArrayList<>();
       for(String s:movieDB.keySet()){
           l.add(s);
       }
       return l;
}
    public void deleteDirector(String director){

        List<String> movies = new ArrayList<String>();
        if(movieDirectorDB.containsKey(director)){
            //1. Find the movie names by director from the pair
            movies = movieDirectorDB.get(director);

            //2. Deleting all the movies from movieDb by using movieName
            for(String movie: movies){
                if(movieDB.containsKey(movie)){
                    movieDB.remove(movie);
                }
            }

            //3. Deleteing the pair
            movieDirectorDB.remove(director);
        }

        //4. Delete the director from directorDb.
        if(directorDB.containsKey(director)){
            directorDB.remove(director);
        }
    }
    public void deleteAllDirector(){

        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        directorDB = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: movieDirectorDB.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: movieDirectorDB.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieDB.containsKey(movie)){
                movieDB.remove(movie);
            }
        }
        //clearing the pair.
        movieDirectorDB = new HashMap<>();
    }

}
