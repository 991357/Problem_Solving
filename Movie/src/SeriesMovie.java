public class SeriesMovie extends Movie
{
    int seriesNum;
    String episode;

    // 생성자: 부모 생성자 호출 필수
    public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode)
    {
        super(id, title, director, genre, runningTime); // Movie 생성자 호출
        this.seriesNum = seriesNum;
        this.episode = episode;
    }

    public int getSeriesNum()
    {
        return seriesNum;
    }

    public void setSeriesNum(int seriesNum)
    {
        this.seriesNum = seriesNum;
    }

    public String getEpisode()
    {
        return episode;
    }

    public void SetEpisode(String episode)
    {
        this.episode = episode;
    }

    @Override
    public String toString()
    {
        return super.toString() + " seriesNumber : " + seriesNum + " episode : " + episode;
    }
}
