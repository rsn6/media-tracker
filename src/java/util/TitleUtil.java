package util;

import edu.csueb.mediatracker.bean.Title;
import java.util.List;

public class TitleUtil {
    public static List<Title> getTVTitles(){
        return DBUtil.getTVTitles();
    }
    
    public static List<Title> getMovieTitles(){
        return DBUtil.getMovieTitles();
    }
    
    public static void removeTVTitle(String name){
        DBUtil.deleteTV(name);
    }
    
    public static void addTVTitle(Title t){
        DBUtil.createTVTitle(t);
    }
    
    public static void addMovieTitle(Title t){
        DBUtil.createMovieTitle(t);
    }
    
    public static void removeMovieTitle(String name){
        DBUtil.deleteMovie(name);
    }
    
    public static void updateTVTitle(Title t){
        DBUtil.updateTV(t);
    }
    
    public static void updateMovieTitle(Title t){
        DBUtil.updateMovie(t);
    }
}
