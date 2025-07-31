public class Main
{
    static int N = 5;

    public static void main(String[] args)
    {
        int arr[][] = new int[N][N];
        int count = 1;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                arr[i][j] = count;
                count++;
            }
        }

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
            {
                System.out.println("현재 위치 : " + x + " : " + y);

                for (int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < N && ny < N)
                        System.out.println("인접한 위치 발견 : " + nx + " , " +ny + " => "+ arr[nx][ny]);
                }
            }
        }
    }
}