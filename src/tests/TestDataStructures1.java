package tests;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestDataStructures1 {

    @Test
    public void testGetRating(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");
        assertNull(song.getRatings());
    }

    @Test
    public void testGetRating2(){
        ratings.Song song = new ratings.Song("booman", "Baby Keem", "12345678");
        ratings.Rating rating1 = new ratings.Rating("14360", 5);
        ratings.Rating rating2 = new ratings.Rating("14361", 5);
        ratings.Rating rating3 = new ratings.Rating("14362", 4);

        song.addRating(rating1);
        song.addRating(rating2);
        song.addRating(rating3);

        ratings.Song song2 = new ratings.Song("MAFIA", "Travis Scott", "12345678");

        song2.addRating(rating1);
        song2.addRating(rating2);
        song2.addRating(rating3);

        assertEquals(song2.getRatings().toString(), song.getRatings().toString());
    }

    @Test
    public void testSetRating1(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");
        ratings.Rating rating1 = new ratings.Rating("14360", 5);
        ratings.Rating rating2 = new ratings.Rating("14361", 5);
        ratings.Rating rating3 = new ratings.Rating("14362", 4);

        song.addRating(rating1);
        song.addRating(rating2);
        song.addRating(rating3);

        ratings.Rating rating4 = new ratings.Rating("14360", 4);
        ratings.Rating rating5 = new ratings.Rating("14361", 4);
        ratings.Rating rating6 = new ratings.Rating("14362", 4);

        ratings.datastructures.LinkedListNode<ratings.Rating> list = new ratings.datastructures.LinkedListNode<>(rating4, null);
        list = new ratings.datastructures.LinkedListNode<>(rating5, list);
        list = new ratings.datastructures.LinkedListNode<>(rating6, list);

        song.setRatings(list);

        assertEquals(song.getRatings().toString(), list.toString());
    }

    @Test
    public void testSetRating2(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");
        ratings.Rating rating1 = new ratings.Rating("14360", 5);
        ratings.Rating rating2 = new ratings.Rating("14361", 5);
        ratings.Rating rating3 = new ratings.Rating("14362", 4);

        song.addRating(rating1);
        song.addRating(rating2);
        song.addRating(rating3);

        ratings.Rating rating4 = new ratings.Rating("14360", 4);
        ratings.Rating rating5 = new ratings.Rating("14361", 4);
        ratings.Rating rating6 = new ratings.Rating("14362", 4);

        ratings.Song song2 = new ratings.Song("SPACE CADET","Lil Uzi Vert", "12345677");

        song2.addRating(rating4);
        song2.addRating(rating5);
        song2.addRating(rating6);

        song.setRatings(song2.getRatings());

        assertEquals(song.getRatings().toString(), song2.getRatings().toString());

    }

    @Test
    public void testSetRating3(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");
        ratings.Rating rating1 = new ratings.Rating("14360", 5);
        ratings.Rating rating2 = new ratings.Rating("14361", 5);
        ratings.Rating rating3 = new ratings.Rating("14362", 4);

        song.addRating(rating1);
        song.addRating(rating2);
        song.addRating(rating3);

        ratings.Song song2 = new ratings.Song("SPACE CADET","Lil Uzi Vert", "12345677");

        song.setRatings(song2.getRatings());

        assertNull(song.getRatings());
    }

    @Test
    public void testAverageRating1(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");
        ratings.Rating rating1 = new ratings.Rating("14360", 5);
        ratings.Rating rating2 = new ratings.Rating("14361", 5);
        ratings.Rating rating3 = new ratings.Rating("14362", 4);
        ratings.Rating rating4 = new ratings.Rating("14363", 2);

        song.addRating(rating1);
        song.addRating(rating2);
        song.addRating(rating3);
        song.addRating(rating4);

        assertEquals(4.0, song.averageRating(), 0.001);
    }

    @Test
    public void testAverageRating2(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");
        assertEquals(0.0, song.averageRating(), 0.001);
    }

    @Test
    public void testAverageRating3(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");

        ratings.Rating rating1 = new ratings.Rating("14360", 5);
        ratings.Rating rating2 = new ratings.Rating("14361", 5);
        ratings.Rating rating3 = new ratings.Rating("14362", 4);
        ratings.Rating rating4 = new ratings.Rating("14363", 2);
        ratings.Rating rating5 = new ratings.Rating("14364", 100);

        song.addRating(rating1);
        song.addRating(rating2);
        song.addRating(rating3);
        song.addRating(rating4);
        song.addRating(rating5);

        assertEquals(4.0, song.averageRating(), 0.001);
    }

    @Test
    public void testAverageRating4(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");
        ratings.Rating rating = new ratings.Rating("14360", 4);

        song.addRating(rating);

        assertEquals(4.0, song.averageRating(), 0.001);
    }

    @Test
    public void testAverageRating5(){
        ratings.Song song = new ratings.Song("out for the night", "21 Savage", "0000001");
        ratings.Reviewer reviewer = new ratings.Reviewer("14360");

        song.addRating(reviewer.rateSong(5));
        song.removeRatingByReviewer(reviewer);

        assertEquals(0.0, song.averageRating(), 0.001);
    }

    @Test
    public void testAverageRating6(){
        ratings.Song song = new ratings.Song("out for the night", "21 Savage", "0000001");
        assertEquals(0.0, song.averageRating(), 0.001);
    }

    @Test
    public void testRemoveByReviewer1(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");
        ratings.Rating rating1 = new ratings.Rating("14360", 5);
        ratings.Rating rating2 = new ratings.Rating("14361", 5);
        ratings.Rating rating3 = new ratings.Rating("14362", 4);
        ratings.Rating rating4 = new ratings.Rating("14363", 2);

        song.addRating(rating1);
        song.addRating(rating2);
        song.addRating(rating3);
        song.addRating(rating4);

        ratings.Reviewer reviewer = new ratings.Reviewer("12345678");
        song.addRating(reviewer.rateSong(5));

        song.removeRatingByReviewer(reviewer);

        assertEquals(4.0, song.averageRating(), 0.001);
    }

    @Test
    public void testRemoveByReviewer3(){
        ratings.Song song = new ratings.Song("booman","Baby Keem", "12345678");

        ratings.Reviewer reviewer = new ratings.Reviewer("12345670");
        ratings.Reviewer reviewer2 = new ratings.Reviewer("12345679");
        ratings.Reviewer reviewer3 = new ratings.Reviewer("12345677");
        ratings.Reviewer reviewer4 = new ratings.Reviewer("12345676");

        song.addRating(reviewer.rateSong(5));
        song.addRating(reviewer2.rateSong(4));
        song.addRating(reviewer3.rateSong(3));
        song.addRating(reviewer4.rateSong(2));

        song.removeRatingByReviewer(reviewer);

        assertEquals(3.0, song.averageRating(), 0.001);
    }

    @Test
    public void testRemoveByReviewer4(){
        ratings.Song song = new ratings.Song("Slippery", "Migos", "12345678");

        ratings.Reviewer reviewer = new ratings.Reviewer("123456");
        ratings.Reviewer reviewer2 = new ratings.Reviewer("123457");
        ratings.Reviewer reviewer3 = new ratings.Reviewer("123458");


        song.addRating(reviewer.rateSong(100));
        song.addRating(reviewer2.rateSong(4));
        song.addRating(reviewer3.rateSong(-1));

        song.removeRatingByReviewer(reviewer2);

        assertEquals(0.0, song.averageRating(), 0.001);
    }

    @Test
    public void testRemoveByReviewer5(){
        ratings.Song song = new ratings.Song("Slippery", "Migos", "12345678");

        ratings.Reviewer reviewer = new ratings.Reviewer("123456");
        ratings.Reviewer reviewer2 = new ratings.Reviewer("123457");
        ratings.Reviewer reviewer3 = new ratings.Reviewer("123458");


        song.addRating(reviewer.rateSong(2));
        song.addRating(reviewer2.rateSong(4));
        song.addRating(reviewer3.rateSong(5));

        song.removeRatingByReviewer(reviewer3);

        assertEquals(3.0, song.averageRating(), 0.001);
    }

    @Test
    public void testRemoveByReviewer6(){
        ratings.Song song = new ratings.Song("Slippery", "Migos", "12345678");

        ratings.Reviewer reviewer = new ratings.Reviewer("123456");

        song.addRating(reviewer.rateSong(2));
        song.addRating(reviewer.rateSong(4));
        song.addRating(reviewer.rateSong(5));

        song.removeRatingByReviewer(reviewer);

        assertEquals(4.5, song.averageRating(), 0.001);
    }

    @Test
    public void testRemoveByReviewer7(){
        ratings.Song song = new ratings.Song("Slippery", "Migos", "12345678");

        ratings.Reviewer reviewer = new ratings.Reviewer("123456");

        song.addRating(reviewer.rateSong(2));
        song.addRating(reviewer.rateSong(4));
        song.addRating(reviewer.rateSong(4));

        song.removeRatingByReviewer(reviewer);

        assertEquals(4.0, song.averageRating(), 0.001);
    }

    @Test
    public void testRemoveByReviewer8(){
        ratings.Song song = new ratings.Song("Slippery", "Migos", "12345678");

        ratings.Reviewer reviewer = new ratings.Reviewer("123456");
        ratings.Reviewer reviewer2 = new ratings.Reviewer("123457");

        song.addRating(reviewer.rateSong(2));
        song.addRating(reviewer.rateSong(4));
        song.addRating(reviewer.rateSong(3));

        song.removeRatingByReviewer(reviewer2);

        assertEquals(3.0, song.averageRating(), 0.001);
    }
}