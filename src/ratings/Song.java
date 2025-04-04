package ratings;

public class Song extends Ratable{
    private String artist;
    private String songID;

    public Song(String title, String artist, String songID){
        super.setTitle(title);
        this.songID = songID;
        this.artist = artist;
    }

    public String getArtist(){
        return this.artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getSongID(){
        return this.songID;
    }

    public void setSongID(String songID){
        this.songID = songID;
    }
}