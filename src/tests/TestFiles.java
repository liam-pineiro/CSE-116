package tests;

import java.util.*;
import ratings.*;
import ratings.FileReader;
import ratings.datastructures.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFiles {
    @Test
    public void testReadMoviesWrongFile(){
        ArrayList<Movie> movies = FileReader.readMovies("data/movie.csv");

        assertEquals(0, movies.size());
    }

    @Test
    public void testReadMoviesRightTitle(){
        ArrayList<Movie> movies = FileReader.readMovies("data/movies.csv");

        ArrayList<Movie> movies2 = new ArrayList<>();
        for(Movie movie : movies){
            movies2.add(movie);
        }

        for(Movie movie1 : movies2){
            for(Movie movie2 : movies){
                if(movie1.getTitle().equals(movie2.getTitle())){
                    assertEquals(movie1.getTitle(), movie2.getTitle());
                    ArrayList<String> cast1 = movie1.getCast();
                    ArrayList<String> cast2 = movie2.getCast();
                    for(int a = 0; a < cast1.size(); a++){
                        assertEquals(cast1.get(a), cast2.get(a));
                    }
                }
            }
        }
    }

    @Test
    public void testReadMoviesCastWrongOrder(){
        ArrayList<Movie> movies = FileReader.readMovies("data/movies2.csv");

        ArrayList<String> cast = new ArrayList<>();

        cast.add("Steve Buscemi");
        cast.add("Bridgette Wilson");
        cast.add("Darren McGavin");
        cast.add("Josh Mostel");
        cast.add("Norm Macdonald");
        cast.add("Chris Farley");
        cast.add("Adam Sandler");
        cast.add("Bradley Whitford");
        cast.add("Larry Hankin");

        Movie movie1 = new Movie("Billy Madison", cast);

        for(int i = 0; i < movies.size(); i++){
            ArrayList<String> cast2 = movies.get(i).getCast();
            for(int x = 0; x < movie1.getCast().size(); x++){
                assertNotEquals(movie1.getCast().get(x), cast2.get(x));
            }
        }
    }

    @Test
    public void testReadMoviesCastMaxTwoMovies(){
        int count = 0;
        ArrayList<Movie> movies = FileReader.readMovies("data/movies.csv");

        ArrayList<Movie> moviesAgain = new ArrayList<>();
        if(movies.size() >= count + 2){
            Movie movie1 = movies.get(count);
            Movie movie2 = movies.get(count + 1);

            moviesAgain.add(movie1);
            moviesAgain.add(movie2);

            if(moviesAgain.size() == movies.size()){
                for(Movie movie : moviesAgain){
                    for(Movie otherMovie : movies){
                        assertEquals(movie.getTitle(), otherMovie.getTitle());
                        for(int i = 0; i < movie.getCast().size(); i++){
                            assertEquals(movie.getCast().get(i), otherMovie.getCast().get(i));
                        }
                    }
                }
            }
        }
    }

    @Test
    public void testReadMoviesMissingMovie(){
        ArrayList<Movie> movies = FileReader.readMovies("data/movies2.csv");

        assertEquals(5, movies.size());
    }

    @Test
    public void testReadSongsWrongFile(){
        ArrayList<Song> songs = FileReader.readSongs("data/rating.csv");

        assertEquals(0, songs.size());
    }

    @Test
    public void testReadSongsWrongTitle(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");

        Song song = songs.get(0);
        if(songs.size() > 1){
            Song song1 = songs.get(1);
            assertNotEquals(song.getTitle(), song1.getTitle());
        }
    }

    @Test
    public void testReadSongsWrongArtist(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");

        Song song = songs.get(0);
        Song song1 = songs.get(songs.size()-1);

        assertNotEquals(song.getArtist(), song1.getArtist());
    }

    @Test
    public void testReadSongsWrongArtist2(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");

        Song song = songs.get(0);
        if(songs.size() > 1){
            Song song1 = songs.get(1);
            assertNotEquals(song.getArtist(), song1.getArtist());
        }
    }

    @Test
    public void testReadSongsRightArtist(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings2.csv");

        ArrayList<Song> songsCopy = new ArrayList<>();
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

        songsCopy.add(song1);
        songsCopy.add(song2);
        songsCopy.add(song3);
        songsCopy.add(song4);
        songsCopy.add(song5);

        if(!(songsCopy.isEmpty())){
            for(Song song : songsCopy){
                if(!(songs.isEmpty())){
                    if(songs.size() == songsCopy.size()){
                        for(Song otherSong : songs){
                            if(song.getSongID().equals(otherSong.getSongID())) {
                                assertEquals(song.getSongID(), otherSong.getSongID());
                                assertEquals(song.getArtist(), otherSong.getArtist());
                                assertEquals(song.getTitle(), otherSong.getTitle());

                                LinkedListNode<Rating> ratings1 = song.getRatings();
                                LinkedListNode<Rating> ratings2 = otherSong.getRatings();

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
                    }
                }
            }
        }
    }

    @Test
    public void testReadSongsWrongSongID(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");

        Song song = songs.get(0);
        Song song1 = songs.get(songs.size()-1);

        assertNotEquals(song.getSongID(), song1.getSongID());
    }

    @Test
    public void testReadSongsWrongSongID2(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");

        Song song = songs.get(0);
        if(songs.size() > 1){
            Song song1 = songs.get(1);
            assertNotEquals(song.getSongID(), song1.getSongID());
        }
    }

    @Test
    public void testReadSongsWrongReviewerID(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");

        Song song = songs.get(0);
        if(songs.size() > 1){
            Song song1 = songs.get(1);
            assertNotEquals(song.getRatings().getValue().getReviewerID(), song1.getRatings().getValue().getReviewerID());
        }
    }

    @Test
    public void testReadSongsTwoSongs(){
        int count = 0;
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");

        ArrayList<Song> songsAgain = new ArrayList<>();
        if(songs.size() >= count + 2){
            Song song1 = songs.get(count);
            Song song2 = songs.get(count + 1);

            songsAgain.add(song1);
            songsAgain.add(song2);

            if(songsAgain.size() == songs.size()){
                for(Song song : songsAgain){
                    for(Song otherSong : songs){
                        assertEquals(song.getTitle(), otherSong.getTitle());
                        assertEquals(song.getArtist(), otherSong.getArtist());
                        assertEquals(song.getSongID(), otherSong.getSongID());
                    }
                }
            }
        }
    }

    @Test
    public void testReadSongsOneRating(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");

        assertTrue(songs.get(0).getRatings().size() > 1);
    }

    @Test
    public void testReadSongsRatingsWrongOrder(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratings2.csv");

        Song song1 = new Song("money trees", "2HbKqm4o0w5wEeEFXm2sD4", "Kendrick Lamar");

        song1.addRating(new Rating("66", 4));
        song1.addRating(new Rating("150", 3));
        song1.addRating(new Rating("19", 5));

        for(int i = 0; i < songs.size(); i++){
            LinkedListNode<Rating> ratings = songs.get(i).getRatings();
            LinkedListNode<Rating> ratings2 = song1.getRatings();

            if(ratings.size() == ratings2.size()){
                while(ratings != null && ratings2 != null){
                    assertNotEquals(ratings.getValue().getReviewerID(), ratings2.getValue().getReviewerID());

                    ratings = ratings.getNext();
                    ratings2 = ratings2.getNext();
                }
            }
        }
    }
}