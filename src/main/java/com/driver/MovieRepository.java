package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
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
public String deleteDirectorByName(String name){
      if(movieDirectorDB.containsKey(name))
          movieDirectorDB.remove(name);
       return "success";
}
public String deleteAllDirectors(){
       for(String s:movieDirectorDB.keySet()){
           movieDirectorDB.remove(s);
       }
       return "success";
}

}
