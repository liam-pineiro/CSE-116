package tests;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestClasses1 {

    @Test
    public void testSong1(){
        ratings.Song song = new ratings.Song("booman", "Baby Keem", "12345678");
        assertEquals(song.getTitle(), "booman");
    }

    @Test
    public void testSong2(){
        ratings.Song song = new ratings.Song("booman", "Baby Keem", "12345678");
        song.setTitle("hooligan");

        assertEquals(song.getTitle(), "hooligan");
    }

    @Test
    public void testSong3(){
        ratings.Song song = new ratings.Song("booman", "Baby Keem", "12345678");
        assertEquals(song.getArtist(), "Baby Keem");
    }

    @Test
    public void testSong4(){
        ratings.Song song = new ratings.Song("booman", "Baby Keem", "12345678");
        song.setArtist("Kendrick Lamar");

        assertEquals(song.getArtist(), "Kendrick Lamar");
    }

    @Test
    public void testSong5(){
        ratings.Song song = new ratings.Song("booman", "Baby Keem", "12345678");
        assertEquals(song.getSongID(), "12345678");
    }

    @Test
    public void testSong6(){
        ratings.Song song = new ratings.Song("booman", "Baby Keem", "12345678");
        song.setSongID("01234567");

        assertEquals(song.getSongID(), "01234567");
    }

    @Test
    public void testRating1(){
        ratings.Rating rating = new ratings.Rating("12345678", 5);
        assertEquals(5, rating.getRating());
    }

    @Test
    public void testRating2(){
        ratings.Rating rating = new ratings.Rating("12345678", 5);
        assertEquals(rating.getReviewerID(), "12345678");
    }

    @Test
    public void testRating3(){
        ratings.Rating rating = new ratings.Rating("12345678", 5);
        rating.setRating(4);

        assertEquals(4, rating.getRating());
    }

    @Test
    public void testRating4(){
        ratings.Rating rating = new ratings.Rating("12345678", 5);
        rating.setReviewerID("01234567");

        assertEquals(rating.getReviewerID(), "01234567");
    }

    @Test
    public void testRating5(){
        ratings.Rating rating = new ratings.Rating("12345678", -15);
        assertEquals(-1, rating.getRating());
    }

    @Test
    public void testRating6(){
        ratings.Rating rating = new ratings.Rating("12345678", 100);
        assertEquals(-1, rating.getRating());
    }

    @Test
    public void testRating7(){
        ratings.Rating rating = new ratings.Rating("12345678", 4);
        rating.setRating(-4);

        assertEquals(-1, rating.getRating());
    }

    @Test
    public void testRating8(){
        ratings.Rating rating = new ratings.Rating("12345678", 4);
        rating.setRating(1000);

        assertEquals(-1, rating.getRating());
    }

    @Test
    public void testReviewer1(){
        ratings.Reviewer reviewer = new ratings.Reviewer("12345678");
        assertEquals(reviewer.getReviewerID(), "12345678");
    }

    @Test
    public void testReviewer2(){
        ratings.Reviewer reviewer = new ratings.Reviewer("12345678");
        reviewer.setReviewerID("01234567");

        assertEquals(reviewer.getReviewerID(), "01234567");
    }

    @Test
    public void testReviewer3(){
        ratings.Reviewer reviewer = new ratings.Reviewer("12345678");
        ratings.Rating rating = reviewer.rateSong(5);

        assertEquals(rating.getRating(), 5);
    }

    @Test
    public void testReviewer4(){
        ratings.Reviewer reviewer = new ratings.Reviewer("12345678");
        ratings.Rating rating = reviewer.rateSong(5);

        assertEquals(rating.getReviewerID(), "12345678");
    }

    @Test
    public void testReviewer5(){
        ratings.Reviewer reviewer = new ratings.Reviewer("12345678");
        ratings.Rating rating = reviewer.rateSong(5);
        ratings.Rating rating2 = new ratings.Rating("01234567", 5);

        assertEquals(rating.getRating(), rating2.getRating());
    }

    @Test
    public void testReviewer6(){
        ratings.Reviewer reviewer = new ratings.Reviewer("12345678");
        ratings.Rating rating = reviewer.rateSong(100);

        assertEquals(rating.getRating(), -1);
    }

    @Test
    public void testReviewer7(){
        ratings.Reviewer reviewer = new ratings.Reviewer("12345678");
        ratings.Rating rating = reviewer.rateSong(-15);

        assertEquals(rating.getRating(), -1);
    }
}
