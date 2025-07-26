public class Movie
{
    int id;
    String title;
    String director;
    String genre;
    int runningTime;

    Movie(int id, String title, String director, String genre, int runningTime)
    {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int changeId)
    {
        id = changeId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String changeTitle)
    {
        title = changeTitle;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String changeDirector)
    {
        director = changeDirector;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String changeGenre)
    {
        genre = changeGenre;
    }

    public int getRunningTime()
    {
        return runningTime;
    }

    public void setRunningTime(int changeRunningTime)
    {
        runningTime = changeRunningTime;
    }

    public String toString()
    {
        return "id : " + id + " title : " + title + " director : " + director + " genre : " + genre + " runningTime : " + runningTime;
    }
}
