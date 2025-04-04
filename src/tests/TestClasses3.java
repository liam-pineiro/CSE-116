package tests;

import java.util.*;
import ratings.*;
import ratings.FileReader;
import ratings.datastructures.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestClasses3 {

    @Test
    public void testReadMovieRatingsWrongFile(){
        ArrayList<Movie> moviesNoRatings = FileReader.readMovies("data/movies2.csv");
        ArrayList<Movie> movies = FileReader.readMovieRatings(moviesNoRatings, "data/movie_rating.csv");

        assertEquals(0, movies.size());
    }

    @Test
    public void testReadMovieRatingsOneRating(){
        ArrayList<Movie> moviesNoRatings = FileReader.readMovies("data/movies3.csv");
        ArrayList<Movie> movies = FileReader.readMovieRatings(moviesNoRatings, "data/movie_ratings2.csv");

        assertTrue(movies.get(0).getRatings().size() > 1);
    }

    @Test
    public void testReadMovieRatingsUnratedMovies(){
        ArrayList<Movie> moviesNoRatings = FileReader.readMovies("data/movies2.csv");
        ArrayList<Movie> movies = FileReader.readMovieRatings(moviesNoRatings, "data/movie_ratings2.csv");

        assertEquals(0, movies.size());
    }

    @Test
    public void testReadMovieRatingsMultipleMovies(){
        ArrayList<Movie> moviesNoRatings = FileReader.readMovies("data/movies4.csv");
        ArrayList<Movie> movies = FileReader.readMovieRatings(moviesNoRatings, "data/movie_ratings2.csv");

        assertEquals(2, movies.size());
    }

    @Test
    public void testTopKRatablesMinusOne(){
        MediaLibrary media = new MediaLibrary();
        media.populateLibrary("data/ratings2.csv", "data/movies3.csv", "data/movie_ratings2.csv");

        ArrayList<Ratable> ratables = media.topKRatables(3-1);
        assertEquals(2, ratables.size());
    }

    @Test
    public void testTopKRatablesOnlyMovies(){
        MediaLibrary media = new MediaLibrary();
        media.populateLibrary("data/ratings2.csv", "data/movie.csv", "data/movie_rating2.csv");
        ArrayList<Song> songs = FileReader.readSongs("data/ratings2.csv");

        ArrayList<Ratable> ratables = media.topKRatables(songs.size());
        assertTrue(ratables.size() >= songs.size());
    }

    @Test
    public void testTopKRatablesOnlySongs(){
        MediaLibrary media = new MediaLibrary();
        media.populateLibrary("data/rating2.csv", "data/movies3.csv", "data/movie_ratings2.csv");
        ArrayList<Movie> movies = FileReader.readMovies("data/movies3.csv");
        ArrayList<Movie> moviesWithRatings = FileReader.readMovieRatings(movies, "data/movie_ratings2.csv");

        ArrayList<Ratable> ratables = media.topKRatables(moviesWithRatings.size());
        assertTrue(ratables.size() >= moviesWithRatings.size());
    }

    @Test
    public void testTopKRatablesReverseOrder(){
        MediaLibrary media = new MediaLibrary();
        media.populateLibrary("data/ratings2.csv", "data/movie.csv", "data/movie_rating2.csv");

        ArrayList<Ratable> ratables = media.topKRatables(5);
        ArrayList<Ratable> ratableCopy = new ArrayList<>();
        ArrayList<Ratable> rankedRatables = new ArrayList<>();

        Song song1 = new Song("THANK GOD", "Travis Scott", "18NOKLkZETa4sWwLMIm0UZ");
        Song song2 = new Song("Flashing Lights", "Kanye West", "5TRPicyLGbAF2LGBFbHGvO");
        Song song3 = new Song("LOT OF ME", "Lil Tecca", "2ZXxRC6V6AXzMdbLQZMHSB");
        Song song4 = new Song("Shirt", "SZA", "2wSTnntOPRi7aQneobFtU4");
        Song song5 = new Song("money trees", "Kendrick Lamar", "2HbKqm4o0w5wEeEFXm2sD4");

        song1.addRating(new Rating("170", 4));
        song1.addRating(new Rating("164", 3));
        song1.addRating(new Rating("66", 3));
        song1.addRating(new Rating("86", 4));

        song2.addRating(new Rating("40", 5));
        song2.addRating(new Rating("38", 2));
        song2.addRating(new Rating("223", 3));
        song2.addRating(new Rating("46", 5));
        song2.addRating(new Rating("66", 4));

        song3.addRating(new Rating("170", 3));
        song3.addRating(new Rating("48", 2));
        song3.addRating(new Rating("155", 4));
        song3.addRating(new Rating("254", 5));
        song3.addRating(new Rating("66", 3));
        song3.addRating(new Rating("86", 4));

        song4.addRating(new Rating("90", 5));
        song4.addRating(new Rating("49", 5));
        song4.addRating(new Rating("231", 4));
        song4.addRating(new Rating("17", 4));
        song4.addRating(new Rating("187", 5));
        song4.addRating(new Rating("154", 3));
        song4.addRating(new Rating("66", 3));

        song5.addRating(new Rating("19", 5));
        song5.addRating(new Rating("66", 3));
        song5.addRating(new Rating("150", 4));

        ratableCopy.add(song1);
        ratableCopy.add(song2);
        ratableCopy.add(song3);
        ratableCopy.add(song4);
        ratableCopy.add(song5);

        rankedRatables.addAll(ratableRanker(ratableCopy));

        for(int i = 0; i < ratables.size(); i++){
            assertEquals(ratables.get(i).getTitle(), rankedRatables.get(i).getTitle());

            LinkedListNode<Rating> ratings1 = ratables.get(i).getRatings();
            LinkedListNode<Rating> ratings2 = rankedRatables.get(i).getRatings();

            while(ratings1 != null & ratings2 != null){
                if(ratings1.getValue().getReviewerID().equals(ratings2.getValue().getReviewerID())){
                    assertEquals(ratings1.getValue().getReviewerID(), ratings2.getValue().getReviewerID());
                    assertEquals(ratings1.getValue().getRating(), ratings2.getValue().getRating());
                }
                ratings1 = ratings1.getNext();
                ratings2 = ratings2.getNext();
            }
        }
    }

    public ArrayList<Ratable> ratableRanker(ArrayList<Ratable> ratables){
        int size = ratables.size();
        ArrayList<Ratable> rankedMedia = new ArrayList<>();
        ArrayList<Ratable> mediaCopy = ratables;

        if(!(mediaCopy.isEmpty())){
            while(rankedMedia.size() != size){
                Ratable highestRated = mediaCopy.get(0);
                if(mediaCopy.size() != 1){
                    for(int i = 0; i < mediaCopy.size(); i++){
                        if(mediaCopy.get(i).bayesianAverageRating(2, 3) > highestRated.bayesianAverageRating(2, 3)){
                            highestRated = mediaCopy.get(i);
                        }
                    }
                    rankedMedia.add(highestRated);
                    mediaCopy.remove(highestRated);
                }
                else{
                    rankedMedia.add(highestRated);
                    mediaCopy.remove(highestRated);
                }
            }
        }
        return rankedMedia;
    }
}
