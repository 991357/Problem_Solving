#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

void bfs(int x, int y, vector<vector<bool>> &submergeVec)
{
    deque<pair<int, int>> bfsDeq;
    bfsDeq.push_back({ x, y });
    submergeVec[x][y] = true;

    while (!bfsDeq.empty())
    {
        auto cur = bfsDeq.front();
        bfsDeq.pop_front();

        int x = cur.first;
        int y = cur.second;

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < submergeVec.size() && ny < submergeVec.size() && !submergeVec[nx][ny])
            {
                submergeVec[nx][ny] = true;
                bfsDeq.push_back({ nx, ny });
            }
        }
    }
}

int getSafeCount(vector<vector<bool>> &submergeVec)
{
    int cnt = 0;

    for (int i = 0; i < submergeVec.size(); i++)
    {
        for (int j = 0; j < submergeVec.size(); j++)
        {
            if (!submergeVec[i][j])
            {
                bfs(i, j, submergeVec);
                cnt++;
            }
        }
    }

    return cnt;
}

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    
    int max = 0;
    int areaMax = 0;

    vector<vector<int>> areaVec(N, vector<int>(N));

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            int n;
            cin >> n;
            areaVec[i][j] = n;

            max = std::max(max, n);
        }
    }

    for (int i = 0; i < max; i++)
    {
        // i 이하는 다 물에 잠궈버려
        vector<vector<bool>> submergeVec(N, vector<bool>(N));
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < N; k++)
            {
                if (areaVec[j][k] <= i)
                    submergeVec[j][k] = true;
            }
        }

        int cnt = getSafeCount(submergeVec);
        areaMax = std::max(areaMax, cnt);
    }

    cout << areaMax;

    return 0;
}