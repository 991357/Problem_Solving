#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <tuple>

using namespace std;

struct Node
{
    int x, y, d;

    bool operator<(const Node& other) const { return d > other.d; };
};

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int dijkstra(vector<vector<int>> map, int N)
{
    priority_queue<Node> dstQ;
    dstQ.push({0,0,map[0][0]});
    vector<vector<int>> dist(N, vector<int>(N, 123456789));
    dist[0][0] = map[0][0];

    while (!dstQ.empty())
    {
        Node cur = dstQ.top();
        dstQ.pop();

        if (dist[cur.x][cur.y] < cur.d) continue;

        if (cur.x == N - 1 && cur.y == N - 1)
            return cur.d;

        for (int i = 0; i < 4; i++)
        {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N)
            {
                int nd = cur.d + map[nx][ny];

                if (dist[nx][ny] > nd)
                {
                    dist[nx][ny] = nd;
                    dstQ.push({ nx, ny, nd });
                }
            }
        }
    }
    return -1;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int tc = 1;
    while (true)
    {
        int N = 0;
        cin >> N;

        if (N == 0)
            break;

        vector<vector<int>> map(N, vector<int>(N));

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int num = 0;
                cin >> num;
                map[i][j] = num;
            }
        }
        cout << "Problem " << tc << ": " << dijkstra(map, N) << "\n";

        tc++;
    }

    return 0;
}