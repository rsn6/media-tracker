package util;

import edu.csueb.mediatracker.bean.Title;
import edu.csueb.mediatracker.bean.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBUtil {
       private static Connection getConnection(){
       Connection connection = null;
    try {
        String dbURL = "jdbc:mysql://localhost:3000/mediatracker";
        String username = "root";
        String password = "password";
        
        Class.forName("com.mysql.jdbc.Driver");
        
        connection = DriverManager.getConnection(
            dbURL, username, password);
        
        } catch(Exception e) {
                e.printStackTrace();
        }
        return connection;
    }

    public static List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        Connection conn = getConnection();
        String query = "SELECT firstname, lastname, email, password "
                + "FROM user";
        try{
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                String email = rs.getString("email");
                String pword = rs.getString("password");
                
                User u = new User(fname , lname, email, pword);
                users.add(u);
            }
            rs.close();
            stat.close();
            
        }catch(SQLException e){
            for (Throwable t : e)
                t.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return users;
    }

    public static void createUser(User user){
        //insert a new row in the user table
        Connection conn = getConnection();
        String query =
            "INSERT INTO user (firstname, lastname, email, password) " +
            "VALUES ('" + user.getFirstname() + "', " +
                    "'" + user.getLastname() + "', " +
                    "'" + user.getEmail()+ "', " +
                    "'" + user.getPassword()+ "')";
        
        try{
            Statement stat = conn.createStatement();
            int count = stat.executeUpdate(query);
            stat.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static List<Title> getTVTitles(){
        List<Title> tvtitles = new ArrayList<Title>();
        Connection conn = getConnection();
        String query = "SELECT tvname, tvgenre, tvyear, tv.email "
                + "FROM tv "
                + "WHERE tv.email = " + "'" + UserUtil.current + "'";

        try{
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("tvname");
                String genre = rs.getString("tvgenre");
                String year = rs.getString("tvyear");
                
                Title t = new Title(name, genre, year);
                tvtitles.add(t);
            }
            rs.close();
            stat.close();
            
        }catch(SQLException e){
            for (Throwable t : e)
                t.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return tvtitles;
    }

    public static List<Title> getMovieTitles(){
        List<Title> movietitles = new ArrayList<Title>();
        Connection conn = getConnection();
        String query = "SELECT mname, mgenre, myear, movie.email "
                + "FROM movie "
                + "WHERE movie.email = " + "'" + UserUtil.current + "'";
        try{
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("mname");
                String genre = rs.getString("mgenre");
                String year = rs.getString("myear");
                
                Title t = new Title(name, genre, year);
                movietitles.add(t);
            }
            rs.close();
            stat.close();
            
        }catch(SQLException e){
            for (Throwable t : e)
                t.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return movietitles;
    }
    
    public static void deleteTV(String name){
        Connection conn = getConnection();
        String query = "DELETE FROM tv WHERE email = '" + UserUtil.current + "' AND tvname = '" + name + "'";
        
        try{
            Statement stat = conn.createStatement();
            int count = stat.executeUpdate(query);
            stat.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
        }
    }
    
    public static void createTVTitle(Title title){
        Connection conn = getConnection();
        String query =
            "INSERT INTO tv (tv.email, tvname, tvgenre, tvyear) " +
            "VALUES ('" + UserUtil.current + "', " +
                    "'" + title.getName() + "', " +
                    "'" + title.getGenre()+ "', " +
                    "'" + title.getYear() + "')";

        try{
            Statement stat = conn.createStatement();
            int count = stat.executeUpdate(query);
            stat.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void createMovieTitle(Title title){
        Connection conn = getConnection();
        String query =
            "INSERT INTO movie (movie.email, mname, mgenre, myear) " +
            "VALUES ('" + UserUtil.current + "', " +
                    "'" + title.getName() + "', " +
                    "'" + title.getGenre()+ "', " +
                    "'" + title.getYear() + "')";
        
        try{
            Statement stat = conn.createStatement();
            int count = stat.executeUpdate(query);
            stat.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void deleteMovie(String name){
        Connection conn = getConnection();
        String query = "DELETE FROM movie WHERE email = '" + UserUtil.current + "' AND mname = '" + name + "'";
        
        try{
            Statement stat = conn.createStatement();
            int count = stat.executeUpdate(query);
            stat.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
        }
    }
    
    public static void updateTV(Title title){
        Connection conn = getConnection();
        String query = "UPDATE tv SET " + 
                    "tvname = " + "'" + title.getName() + "', " + 
                    "tvgenre = " + "'" + title.getGenre() + "', " + 
                    "tvyear = " + "'" + title.getYear() + "' " +
                    "WHERE email = " + "'" + UserUtil.current + "' AND tvname = '" + title.getName() + "'";
        System.out.println("query is : " + query);
        try{
            Statement stat = conn.createStatement();
            int count = stat.executeUpdate(query);
            stat.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void updateMovie(Title title){
        Connection conn = getConnection();
        String query = "UPDATE movie SET " + 
                    "mname = " + "'" + title.getName() + "', " + 
                    "mgenre = " + "'" + title.getGenre() + "', " + 
                    "myear = " + "'" + title.getYear() + "' " +
                    "WHERE email = " + "'" + UserUtil.current + "' AND mname = '" + title.getName() + "'";
        try{
            Statement stat = conn.createStatement();
            int count = stat.executeUpdate(query);
            stat.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
