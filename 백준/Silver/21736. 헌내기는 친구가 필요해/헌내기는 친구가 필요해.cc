#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    
    cin >> N >> M;

    vector<vector<char>> mapVec(N, vector<char>(M));
    pair<int, int> startPos;

    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < M; j++)
        {
            char c;
            cin >> c;
            mapVec[i][j] = c;

            if(c == 'I')
                startPos = {i, j};
        }
    }

    deque<pair<int, int>> bfsQ;
    vector<vector<bool>> checkVec(N, vector<bool>(M));
    checkVec[startPos.first][startPos.second] = true;
    bfsQ.push_back({startPos.first, startPos.second});

    int personCnt = 0;

    while(!bfsQ.empty())
    {
        auto cur = bfsQ.front();
        bfsQ.pop_front();

        for(int i = 0; i < 4; i++)
        {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !checkVec[nx][ny] && mapVec[nx][ny] != 'X')
            {
                checkVec[nx][ny] = true;

                if(mapVec[nx][ny] == 'P')
                    personCnt++;
                bfsQ.push_back({nx, ny});
            }
        }
    }

    if(personCnt == 0)
        cout << "TT";
    else
        cout << personCnt;

    return 0;
}
