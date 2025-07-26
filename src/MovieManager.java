import java.util.ArrayList;
import java.util.List;

public class MovieManager
{
    List<Movie> movieList = new ArrayList<>();
    List<SeriesMovie> seriesMovieList = new ArrayList<>();

    public void add(Movie movie)
    {
        movieList.add(movie);
    }

    public List<Movie> getMovies()
    {
        return movieList;
    }

    public List<SeriesMovie> getSeriesMovies()
    {
        return seriesMovieList;
    }

    public double getRunningTimeAvg()
    {
        double sum = 0;
        for (int i = 0; i < movieList.size(); i++)
            sum += movieList.get(i).runningTime;

        return sum / movieList.size();
    }

    public Movie searchByTitle(String title)
    {
        for (Movie m : movieList)
            if(m.title.equals(title))
                return m;

        return null;
    }


}
