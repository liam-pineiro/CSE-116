package ratings;

import ratings.datastructures.*;
import java.util.ArrayList;

public class Playlist {
    private Comparator<Song> comparator;
    private BST<Song> songBST;
    private LinkedListNode<Song> songLLNode;

    public Playlist(Comparator<Song> comparator){
        this.comparator = comparator;
        this.songBST = new BST<>(comparator);
    }

    public void addSong(Song song){
        this.songBST.insert(song);
    }

    public BinaryTreeNode<Song> getSongTree(){
        return this.songBST.getRoot();
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> songs){
        if(songs == null){
            return null;
        }

        ArrayList<Song> songBTN = songs.inOrderTraversal(songs);

        for(Song song : songBTN){
            LinkedListNode<Song> newNode = new LinkedListNode<>(song, null);
            if (songLLNode == null) {
                songLLNode = newNode;
            } else {
                LinkedListNode<Song> current = songLLNode;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }
        return songLLNode;
    }
    public LinkedListNode<Song> getSongList(){
        return getSongList(getSongTree());
    }
}