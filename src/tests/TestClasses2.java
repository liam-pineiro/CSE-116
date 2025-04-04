package tests;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

import ratings.Song;
import ratings.Rating;
import ratings.Movie;


public class TestClasses2 {

    @Test
    public void testBayesianAverageRating() {
        Song song = new Song("No More Parties in LA", "Kanye West", "12345678");
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        song.addRating(rating1);
        song.addRating(rating2);

        assertEquals(3.75, song.bayesianAverageRating(2, 3), 0.001);
    }

    @Test
    public void testBayesianAverageRating2() {
        Song song = new Song("No More Parties in LA", "Kanye West", "12345678");

        assertEquals(0.0, song.bayesianAverageRating(0, 0), 0.001);
    }

    @Test
    public void testBayesianAverageRating3() {
        Song song = new Song("No More Parties in LA", "Kanye West", "12345678");
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        song.addRating(rating1);
        song.addRating(rating2);

        assertEquals(0.0, song.bayesianAverageRating(-1, 3), 0.001);
    }

    @Test
    public void testBayesianAverageRating4() {
        Song song = new Song("No More Parties in LA", "Kanye West", "12345678");
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        song.addRating(rating1);
        song.addRating(rating2);

        assertEquals(0.0, song.bayesianAverageRating(2, 100), 0.001);
    }

    @Test
    public void testBayesianAverageRating5() {
        Song song = new Song("No More Parties in LA", "Kanye West", "12345678");
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        song.addRating(rating1);
        song.addRating(rating2);

        assertEquals(4.5, song.bayesianAverageRating(0, 2), 0.001);
    }

    @Test
    public void testBayesianAverageRating6() {
        Song song = new Song("No More Parties in LA", "Kanye West", "12345678");
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        song.addRating(rating1);
        song.addRating(rating2);

        assertEquals(0.0, song.bayesianAverageRating(2, -2), 0.001);
    }

    @Test
    public void testBayesianAverageRating7() {
        Song song = new Song("No More Parties in LA", "Kanye West", "12345678");
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        song.addRating(rating1);
        song.addRating(rating2);

        assertEquals(3.75, song.bayesianAverageRating(2, 3), 0.001);
        assertEquals(3.75, song.bayesianAverageRating(2, 3), 0.001);
    }

    @Test
    public void testMovie() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        assertEquals("Jumanji", movie.getTitle());
    }

    @Test
    public void testMovie2() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Dwayne Johnson");
        cast2.add("Kevin Hart");
        cast2.add("Jack Black");

        int count = 0;
        for (int i = 0; i < cast.size(); i++) {
            if (cast.get(i).equalsIgnoreCase(cast2.get(i))) {
                count++;
            }
        }
        if (cast.size() == cast2.size()) {
            assertEquals(count, cast.size());
        }
    }

    @Test
    public void testMovie3() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        movie.addRating(rating1);
        movie.addRating(rating2);

        assertEquals(3.75, movie.bayesianAverageRating(2, 3), 0.001);
    }

    @Test
    public void testMovie4() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        movie.addRating(rating1);
        movie.addRating(rating2);

        assertEquals(4.5, movie.bayesianAverageRating(0, 3), 0.001);
    }

    @Test
    public void testMovie5() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        movie.addRating(rating1);
        movie.addRating(rating2);

        assertEquals(0.0, movie.bayesianAverageRating(-1, 3), 0.001);
    }

    @Test
    public void testMovie6() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        movie.addRating(rating1);
        movie.addRating(rating2);

        assertEquals(0.0, movie.bayesianAverageRating(2, -2), 0.001);
    }

    @Test
    public void testMovie7() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        movie.addRating(rating1);
        movie.addRating(rating2);

        assertEquals(0.0, movie.bayesianAverageRating(2, 100), 0.001);
    }

    @Test
    public void testMovie8() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        assertEquals(0.0, movie.bayesianAverageRating(0, 3), 0.001);
    }

    @Test
    public void testMovie9() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);
        Rating rating1 = new Rating("14360", 4);
        Rating rating2 = new Rating("14361", 5);

        movie.addRating(rating1);
        movie.addRating(rating2);

        assertEquals(3.75, movie.bayesianAverageRating(2, 3), 0.001);
        assertEquals(3.75, movie.bayesianAverageRating(2, 3), 0.001);
    }

    @Test
    public void testMovie10() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Dwayne Johnson");
        cast2.add("Kevin Hart");
        cast2.add("Jack Black");

        int count = 0;
        for (int i = 0; i < cast.size(); i++) {
            if (cast.get(i).equalsIgnoreCase(cast2.get(i))) {
                count++;
            }
        }
        if (cast.size() == cast2.size()) {
            assertEquals(count, cast.size());
        }
    }

    @Test
    public void testMovie11() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Jack Black");
        cast2.add("Kevin Hart");
        cast2.add("Dwayne Johnson");

        int count = 0;
        for (int i = 0; i < cast.size(); i++) {
            if (cast.get(i).equalsIgnoreCase(cast2.get(i))) {
                count++;
            }
        }
        if (cast.size() == cast2.size()) {
            assertFalse(count == cast.size());
        }
    }

    @Test
    public void testMovie12() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Jack Black");
        cast2.add("Kevin Hart");
        cast2.add("Dwayne Johnson");

        int count = 0;
        if (cast.size() == cast2.size()) {
            for (int i = 0; i < cast.size(); i++) {
                if (cast.get(i).equalsIgnoreCase(cast2.get(i))) {
                    count++;
                }
            }
        }
        assertFalse(count == cast.size());
    }

    @Test
    public void testMovie13() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Dwayne Johnson");
        cast2.add("Kevin Hart");

        int count = 0;
        if (cast.size() == cast2.size()) {
            for (int i = 0; i < cast.size(); i++) {
                if (cast.get(i).equalsIgnoreCase(cast2.get(i))) {
                    count++;
                }
            }
        }
        if (cast.size() != cast2.size()) {
            assertFalse(count == cast.size());
        }
    }

    @Test
    public void testMovie14() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Dwayne Johnson");
        cast2.add("Kevin Hart");
        cast2.add("Kevin Hart");

        int count = 0;
        if (cast.size() == cast2.size()) {
            for (int i = 0; i < cast.size(); i++) {
                if (cast.get(i).equalsIgnoreCase(cast2.get(i))) {
                    count++;
                }
            }
        }
        assertFalse(count == cast.size());
    }

    @Test
    public void testMovie15() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        int count = 0;
        for (int i = 0; i < movie.getCast().size(); i++) {
            if (movie.getCast().get(i).equalsIgnoreCase(cast.get(i))) {
                count++;
            }
        }
        assertTrue(count == cast.size());
    }

    @Test
    public void testMovie16() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Dwayne Johnson");
        cast.add("Kevin Hart");
        cast.add("Jack Black");

        Movie movie = new Movie("Jumanji", cast);

        int count = 0;
        for (int i = 0; i < cast.size(); i++) {
            if(i == 0 || movie.getCast().size() == cast.size()){
                if (cast.get(i).equalsIgnoreCase(movie.getCast().get(i))) {
                    count++;
                }
            }
            else if (i > 0 && movie.getCast().size() < cast.size()){
                if (cast.get(i).equalsIgnoreCase(movie.getCast().get(i-1))) {
                    count++;
                }
            }
        }
        assertTrue(count == cast.size());
    }
}