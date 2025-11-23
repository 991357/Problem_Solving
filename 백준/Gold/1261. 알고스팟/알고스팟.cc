#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

// 세로가 N, 가로가 M

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

struct Node
{
    int x,y,cost;
};

struct Cmp 
{
    bool operator()(const Node& a, const Node& b) const
    {
        return a.cost > b.cost;
    }
};

int dst(int x, int y, vector<vector<int>> &mapVec)
{
    priority_queue<Node, vector<Node>, Cmp> dstQ;
    dstQ.push({ 0, 0, 0 });
    vector<vector<int>> costVec(x, vector<int>(y, 987654321));
    costVec[0][0] = 0;

    while (!dstQ.empty())
    {
        auto cur = dstQ.top();
        dstQ.pop();

        if (cur.cost > costVec[cur.x][cur.y]) continue;
        if (cur.x == x - 1 && cur.y == y - 1) 
            return cur.cost;

        for (int i = 0; i < 4; i++)
        {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < x && ny < y)
            {
                int nCost = cur.cost + mapVec[nx][ny];

                if (nCost < costVec[nx][ny])
                {
                    costVec[nx][ny] = nCost;
                    dstQ.push({ nx, ny, nCost });
                }
            }
        }
    }
    return -1;
}

int main()
{
    int N, M;

    cin >> N >> M;

    vector<vector<int>> mapVec(M, vector<int>(N));
    
    for (int i = 0; i < M; i++)
    {
        string str;
        cin >> str;

        for (int j = 0; j < str.length(); j++)
            mapVec[i][j] = str[j] - '0';
    }

    int res = dst(M, N, mapVec);

    cout << res;

    return 0;
}
