package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import ratings.*;
import ratings.datastructures.*;
import java.util.*;

public class TestDataStructures3 {

    @Test
    public void testDegreesOfSeperationEmptyMovieList(){
        ArrayList<Movie> movies = FileReader.readMovies("data/movie.csv");
        DegreesOfSeparation degrees1 = new DegreesOfSeparation(movies);

        assertEquals(-1, degrees1.degreesOfSeparation("Tim Allen", "Tom Hanks"));
    }

    @Test
    public void testDegreesOfSeperationNormalList(){
        ArrayList<Movie> movies = FileReader.readMovies("data/movies5.csv");
        DegreesOfSeparation degrees1 = new DegreesOfSeparation(movies);

        assertEquals(5, degrees1.degreesOfSeparation("Jim Carrey", "Matt Damon"));
    }

    @Test
    public void testDegreesOfSeperationSelfConnection(){
        ArrayList<Movie> movies = FileReader.readMovies("data/movies5.csv");
        DegreesOfSeparation degrees1 = new DegreesOfSeparation(movies);

        assertEquals(0, degrees1.degreesOfSeparation("Jim Carrey", "Jim Carrey"));
    }

    @Test
    public void testDegreesOfSeperationActorsNotFound(){
        ArrayList<Movie> movies = FileReader.readMovies("data/movies5.csv");
        DegreesOfSeparation degrees1 = new DegreesOfSeparation(movies);

        assertEquals(-1, degrees1.degreesOfSeparation("Tim Allen", "Tom Hanks"));
    }
}
