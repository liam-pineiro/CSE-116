package ratings.datastructures;
import ratings.*;

public class SongBayesianRatingComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song a, Song b){
        if(a.bayesianAverageRating(2, 3) > b.bayesianAverageRating(2, 3)){
            return true;
        }
        return false;
    }
}
