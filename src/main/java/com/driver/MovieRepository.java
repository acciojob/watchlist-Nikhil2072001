package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
   HashMap<String,Movie> movieDB = new HashMap<>();
    HashMap<String,Director> directorDB= new HashMap<>();
  HashMap<String,String> mapDB = new HashMap<>();

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
public String addMovieDirectorPair(String movieName,String directorName){
//Pair p = new Pair(movieName,directorName);

mapDB.put(movieName,directorName);
    return "success ";
}
public Movie getMovieByName(String name){
       if(movieDB.containsKey(name))
           return movieDB.get(name);
       return null;
}
public List getMoviesByDirectorName(String name){
       List<String> l = new ArrayList<>();
for(String s: mapDB.keySet()){
    if(mapDB.get(s).equals(name))
        l.add(s);
}
return l;
}
public Director getDirectorByName(String name){

        if(directorDB.containsKey(name))
            return directorDB.get(name);
        return null;
    }
//public class Pair{
//       String movieName;
//       String directorname;
//
//    public Pair(String movieName, String directorname) {
//        this.movieName = movieName;
//        this.directorname = directorname;
//    }
//}
}
