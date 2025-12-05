#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int R, C;
vector<vector<char>> mapVec;
vector<vector<bool>> checkVec;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int sheepRes, wolfRes;

void bfs(int r, int c)
{
    queue<pair<int, int>> bfsQ;
    bfsQ.push({ r, c });

    checkVec[r][c] = true;

    int sheepCnt = 0, wolfCnt = 0;

    if (mapVec[r][c] == 'o') 
        sheepCnt++;
    else if (mapVec[r][c] == 'v')
        wolfCnt++;

    while (!bfsQ.empty())
    {
        auto cur = bfsQ.front();
        bfsQ.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !checkVec[nx][ny] && mapVec[nx][ny] != '#')
            {
                checkVec[nx][ny] = true;

                if (mapVec[nx][ny] == 'o') // 양
                    sheepCnt++;
                else if (mapVec[nx][ny] == 'v') // 늑대
                    wolfCnt++;

                bfsQ.push({ nx, ny });
            }
        }
    }

    if (sheepCnt > wolfCnt)
        sheepRes += sheepCnt;
    else
        wolfRes += wolfCnt;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> R >> C;

    mapVec.resize(R, vector<char>(C));
    checkVec.resize(R, vector<bool>(C));

    sheepRes = 0;
    wolfRes = 0;

    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
            cin >> mapVec[i][j];
    }

    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if (!checkVec[i][j] && mapVec[i][j] != '#')
                bfs(i, j);
        }
    }
    cout << sheepRes << " " << wolfRes;
}