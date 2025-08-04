import java.io.IOException;

public class MovieTest
{
    public static void main(String[] args) throws IOException
    {
/*        // A 2개의 영화를 생성하고 출력
        Movie movie_1 = new Movie(1, "movie_1", "Lee", "GAG", 120);
        Movie movie_2 = new Movie(2, "movie_2", "KIM", "HORROR", 92);

        System.out.println(movie_1.title);
        System.out.println(movie_2.title);

        // B  MovieManager 생성 후 영화 등록, 출력
        MovieManager movieManager = new MovieManager();

        movieManager.movieList.add(movie_1);
        movieManager.movieList.add(movie_2);

        for (Movie m : movieManager.movieList)
            System.out.println(m.title);

        // C MovieManager 객체를 이용하여 영화 제목 검색
        System.out.println(movieManager.searchByTitle("movie_1").id);
        System.out.println(movieManager.searchByTitle("movie_1").director);
        System.out.println(movieManager.searchByTitle("movie_1").runningTime);
        System.out.println(movieManager.searchByTitle("movie_1").genre);*/

        // SeriesMovie 테스트
        SeriesMovie sm = new SeriesMovie(1, "시리즈 영화", "감독", "장르", 120, 2, "에피소드_1");
        System.out.println(sm.toString());
    }
}
