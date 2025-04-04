package ratings.datastructures;
import ratings.*;

public class SongTitleComparator extends Comparator<Song>{
    @Override
    public boolean compare(Song a, Song b){
        if(a.getTitle().compareToIgnoreCase(b.getTitle()) < 0){
            return true;
        }
        return false;
    }
}
