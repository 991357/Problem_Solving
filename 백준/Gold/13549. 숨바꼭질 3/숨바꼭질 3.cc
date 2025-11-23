#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <climits>

int dx[2] = { -1, 1 };

using namespace std;

int bfs(int N, int K)
{
    deque<pair<int, int>> bfsDeq;
    vector<int> distVec(100001, INT_MAX);
    distVec[N] = 0;
    bfsDeq.push_back({ N, 0 });

    while (!bfsDeq.empty())
    {
        auto cur = bfsDeq.front();
        bfsDeq.pop_front();

        int curPos = cur.first;
        int d = cur.second;

        // 이미 더 짧은 경로로 온 적 있으면 스킵
        if (d > distVec[curPos])
            continue;

        if (curPos == K)
            return d;

        // 순간 이동
        int mulNx = curPos * 2;
        if (mulNx >= 0 && mulNx < 100001)
        {
            if (distVec[mulNx] > d)
            {
                distVec[mulNx] = d;
                bfsDeq.push_front({ mulNx, d });
            }
        }

        // 양 옆으로 1칸
        for (int i = 0; i < 2; i++)
        {
            int nx = curPos + dx[i];

            if (nx >= 0 && nx < 100001)
            {
                if (distVec[nx] > d + 1)
                {
                    distVec[nx] = d + 1;
                    bfsDeq.push_back({ nx, d + 1 });
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
    cout.tie(NULL);

    int N, K;
    cin >> N >> K;

    int res = bfs(N, K);

    cout << res;

    return 0;
}
