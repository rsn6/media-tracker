package edu.csueb.mediatracker.bean;


public class Title {
    private String name;
    private String genre;
    private String year;
    
    public Title(){
        
    }
    
    public Title(String name, String genre, String year){
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
