package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import ratings.*;
import ratings.datastructures.*;

public class TestDataStructures2 {

    @Test
    public void testGetSongList1() {
        SongTitleComparator comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);

        assertNull(playlist.getSongList());
    }

    @Test
    public void testGetSongList2() {
        int count = 0;
        SongTitleComparator comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);
        Playlist playlist2 = new Playlist(comparator);

        Song song1 = new Song("Survival Tactics", "12345670", "Joey Bada$$");
        Song song2 = new Song("TEMPTATION", "12345671", "Joey Bada$$");
        Song song3 = new Song("SAY MY GRACE", "12345672", "Offset");
        Song song4 = new Song("CANT SAY", "12345673", "Travis Scott");
        Song song5 = new Song("Grenade", "12345674", "Bruno Mars");
        Song song6 = new Song("Embarrased", "12345675", "Don Toliver");
        Song song7 = new Song("Nightcrawler", "12345676", "Travis Scott");
        Song song8 = new Song("Pipe Down", "12345677", "Drake");
        Song song9 = new Song("Heaven's EP", "12345678", "J Cole");
        Song song10 = new Song("a lot", "12345679", "21 Savage");

        Song song11 = new Song("Survival Tactics", "12345670", "Joey Bada$$");
        Song song12 = new Song("TEMPTATION", "12345671", "Joey Bada$$");
        Song song13 = new Song("SAY MY GRACE", "12345672", "Offset");
        Song song14 = new Song("CANT SAY", "12345673", "Travis Scott");
        Song song15 = new Song("Grenade", "12345674", "Bruno Mars");
        Song song16 = new Song("Embarrased", "12345675", "Don Toliver");
        Song song17 = new Song("Nightcrawler", "12345676", "Travis Scott");
        Song song18 = new Song("Pipe Down", "12345677", "Drake");
        Song song19 = new Song("Heaven's EP", "12345678", "J Cole");
        Song song20 = new Song("a lot", "12345679", "21 Savage");

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.addSong(song4);
        playlist.addSong(song5);
        playlist.addSong(song6);
        playlist.addSong(song7);
        playlist.addSong(song8);
        playlist.addSong(song9);
        playlist.addSong(song10);

        playlist2.addSong(song11);
        playlist2.addSong(song12);
        playlist2.addSong(song13);
        playlist2.addSong(song14);
        playlist2.addSong(song15);
        playlist2.addSong(song16);
        playlist2.addSong(song17);
        playlist2.addSong(song18);
        playlist2.addSong(song19);
        playlist2.addSong(song20);

        LinkedListNode<Song> list = new LinkedListNode<>(song1, null);
        list = new LinkedListNode<>(song2, list);
        list = new LinkedListNode<>(song3, list);
        list = new LinkedListNode<>(song4, list);
        list = new LinkedListNode<>(song5, list);
        list = new LinkedListNode<>(song6, list);
        list = new LinkedListNode<>(song7, list);
        list = new LinkedListNode<>(song8, list);
        list = new LinkedListNode<>(song9, list);
        list = new LinkedListNode<>(song10, list);


        LinkedListNode<Song> list2 = new LinkedListNode<>(song11, null);
        list2 = new LinkedListNode<>(song12, list2);
        list2 = new LinkedListNode<>(song13, list2);
        list2 = new LinkedListNode<>(song14, list2);
        list2 = new LinkedListNode<>(song15, list2);
        list2 = new LinkedListNode<>(song16, list2);
        list2 = new LinkedListNode<>(song17, list2);
        list2 = new LinkedListNode<>(song18, list2);
        list2 = new LinkedListNode<>(song19, list2);
        list2 = new LinkedListNode<>(song20, list2);

        if (list.size() == list2.size()) {
            while (list != null && list2 != null) {
                if (list.getValue().getSongID().equals(list2.getValue().getSongID())) {
                    if (list.getValue().getTitle().equals(list2.getValue().getTitle())) {
                        if (list.getValue().getArtist().equals(list2.getValue().getArtist())) {
                            count++;
                        }
                    }
                }
                list = list.getNext();
                list2 = list2.getNext();
            }
        }
        assertEquals(count, playlist.getSongList().size());
    }

    @Test
    public void testGetSongList3() {
        int count = 0;
        SongTitleComparator comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);
        Playlist playlist2 = new Playlist(comparator);

        Song song1 = new Song("Survival Tactics", "12345670", "Joey Bada$$");
        Song song2 = new Song("TEMPTATION", "12345671", "Joey Bada$$");
        Song song3 = new Song("SAY MY GRACE", "12345672", "Offset");
        Song song4 = new Song("CANT SAY", "12345673", "Travis Scott");
        Song song5 = new Song("Grenade", "12345674", "Bruno Mars");
        Song song6 = new Song("Embarrased", "12345675", "Don Toliver");
        Song song7 = new Song("Nightcrawler", "12345676", "Travis Scott");
        Song song8 = new Song("Pipe Down", "12345677", "Drake");
        Song song9 = new Song("Heaven's EP", "12345678", "J Cole");
        Song song10 = new Song("a lot", "12345679", "21 Savage");

        Song song11 = new Song("Survival Tactics", "12345670", "Joey Bada$$");
        Song song12 = new Song("TEMPTATION", "12345671", "Joey Bada$$");
        Song song13 = new Song("SAY MY GRACE", "12345672", "Offset");
        Song song14 = new Song("CANT SAY", "12345673", "Travis Scott");
        Song song15 = new Song("Grenade", "12345674", "Bruno Mars");
        Song song16 = new Song("Embarrased", "12345675", "Don Toliver");
        Song song17 = new Song("Nightcrawler", "12345676", "Travis Scott");
        Song song18 = new Song("Pipe Down", "12345677", "Drake");
        Song song19 = new Song("Heaven's EP", "12345678", "J Cole");
        Song song20 = new Song("a lot", "12345679", "21 Savage");

        playlist.addSong(song10);
        playlist.addSong(song9);
        playlist.addSong(song8);
        playlist.addSong(song7);
        playlist.addSong(song6);
        playlist.addSong(song5);
        playlist.addSong(song4);
        playlist.addSong(song3);
        playlist.addSong(song2);
        playlist.addSong(song1);

        playlist2.addSong(song11);
        playlist2.addSong(song12);
        playlist2.addSong(song13);
        playlist2.addSong(song14);
        playlist2.addSong(song15);
        playlist2.addSong(song16);
        playlist2.addSong(song17);
        playlist2.addSong(song18);
        playlist2.addSong(song19);
        playlist2.addSong(song20);

        LinkedListNode<Song> list = new LinkedListNode<>(song10, null);
        list = new LinkedListNode<>(song9, list);
        list = new LinkedListNode<>(song8, list);
        list = new LinkedListNode<>(song7, list);
        list = new LinkedListNode<>(song6, list);
        list = new LinkedListNode<>(song5, list);
        list = new LinkedListNode<>(song4, list);
        list = new LinkedListNode<>(song3, list);
        list = new LinkedListNode<>(song2, list);
        list = new LinkedListNode<>(song1, list);


        LinkedListNode<Song> list2 = new LinkedListNode<>(song11, null);
        list2 = new LinkedListNode<>(song12, list2);
        list2 = new LinkedListNode<>(song13, list2);
        list2 = new LinkedListNode<>(song14, list2);
        list2 = new LinkedListNode<>(song15, list2);
        list2 = new LinkedListNode<>(song16, list2);
        list2 = new LinkedListNode<>(song17, list2);
        list2 = new LinkedListNode<>(song18, list2);
        list2 = new LinkedListNode<>(song19, list2);
        list2 = new LinkedListNode<>(song20, list2);

        if (list.size() == list2.size()) {
            while (list != null) {
                while (list2 != null) {
                    if (list.getValue().getSongID().equals(list2.getValue().getSongID())) {
                        if (list.getValue().getTitle().equals(list2.getValue().getTitle())) {
                            if (list.getValue().getArtist().equals(list2.getValue().getArtist())) {
                                count++;
                            }
                        }
                    }
                    list2 = list2.getNext();
                }
                list = list.getNext();

                list2 = new LinkedListNode<>(song11, null);
                list2 = new LinkedListNode<>(song12, list2);
                list2 = new LinkedListNode<>(song13, list2);
                list2 = new LinkedListNode<>(song14, list2);
                list2 = new LinkedListNode<>(song15, list2);
                list2 = new LinkedListNode<>(song16, list2);
                list2 = new LinkedListNode<>(song17, list2);
                list2 = new LinkedListNode<>(song18, list2);
                list2 = new LinkedListNode<>(song19, list2);
                list2 = new LinkedListNode<>(song20, list2);
            }
        }
        assertEquals(count, playlist.getSongList().size());
    }

    @Test
    public void testGetSongList4(){
        Playlist playlist = new Playlist(new SongBayesianRatingComparator());

        Song song1 = new Song("sweet sweet", "12345678", "Travis Scott");
        Song song2 = new Song("All Falls Down", "12345677", "Kanye West");
        Song song3 = new Song("Tip Toe", "12345676", "Sleepy Hallow");
        Song song4 = new Song("bank account", "12345675", "Baby Keem");

        //song1 bayAv: 5+5+3+3 = 16/4 = 4
        song1.addRating(new Rating("14360", 5));
        song1.addRating(new Rating("14361", 5));

        //song2 bayAv: 4+3+3+3 = 13/4 = 3
        song2.addRating(new Rating("14362", 4));
        song2.addRating(new Rating("14363", 3));

        //song3 bayAv: 1+5+3+3 = 12/4 = 3
        song3.addRating(new Rating("14364", 1));
        song3.addRating(new Rating("14365", 5));

        //song4 bayAv: 1+2+3+3 = 9/4 = 2
        song4.addRating(new Rating("14366", 1));
        song4.addRating(new Rating("14367", 2));

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.addSong(song4);

        LinkedListNode<Song> computed = playlist.getSongList();

        //List order: song1, song2, song3, song4

        LinkedListNode<Song> expected = new LinkedListNode<>(song4, null);
        expected = new LinkedListNode<>(song3, expected);
        expected = new LinkedListNode<>(song2, expected);
        expected = new LinkedListNode<>(song1, expected);

        compareLists(computed, expected);
    }

    public void compareLists(LinkedListNode<Song> computed, LinkedListNode<Song> expected){
        if(computed != null && expected != null){
            compareListsHelper(computed, expected);
            if(computed.getNext() != null && expected.getNext() != null){
                computed = computed.getNext();
                expected = expected.getNext();
                compareLists(computed, expected);
            }
        }
    }

    public void compareListsHelper(LinkedListNode<Song> computed, LinkedListNode<Song> expected){
        assertEquals(expected.getValue().getTitle(), computed.getValue().getTitle());
        assertEquals(expected.getValue().getArtist(), computed.getValue().getArtist());
        assertEquals(expected.getValue().getSongID(), computed.getValue().getSongID());
    }

    @Test
    public void testGetSongTree(){
        Playlist playlist = new Playlist(new SongTitleComparator());

        Song song1 = new Song("sweet sweet", "12345678", "Travis Scott");
        Song song2 = new Song("All Falls Down", "12345677", "Kanye West");
        Song song3 = new Song("Tip Toe", "12345676", "Sleepy Hallow");
        Song song4 = new Song("bank account", "12345675", "Baby Keem");

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.addSong(song4);

        assertEquals(song1, playlist.getSongTree().getValue());
    }

    @Test
    public void testGetSongTree2(){
        Playlist playlist = new Playlist(new SongTitleComparator());

        Song song1 = new Song("sweet sweet", "12345678", "Travis Scott");
        Song song2 = new Song("All Falls Down", "12345677", "Kanye West");
        Song song3 = new Song("Tip Toe", "12345676", "Sleepy Hallow");
        Song song4 = new Song("bank account", "12345675", "Baby Keem");

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.addSong(song4);

        BST<Song> songBST = new BST<Song>(new SongTitleComparator());

        songBST.insert(song1);
        songBST.insert(song2);
        songBST.insert(song3);
        songBST.insert(song4);

        assertEquals(songBST.getRoot().getValue(), playlist.getSongTree().getValue());
        assertEquals(songBST.getRoot().getLeft().getValue(), playlist.getSongTree().getLeft().getValue());
        assertEquals(songBST.getRoot().getRight().getValue(), playlist.getSongTree().getRight().getValue());
    }
}