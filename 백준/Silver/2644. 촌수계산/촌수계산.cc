#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int res = 0;
bool isStop = false;

void dfs(int fir, int sec, int cnt, int start, vector<vector<int>> &relativeVec, vector<bool> &checkVec)
{
    if (start == sec)
    {
        res = cnt;
        isStop = true;
        return;
    }

    // 여긴 이제 방문했다
    checkVec[start] = true;

    for (int i = 0; i < relativeVec[start].size(); i++)
    {
        if (isStop)
            return;
        if(!checkVec[relativeVec[start][i]])
            dfs(fir, sec, cnt + 1, relativeVec[start][i], relativeVec, checkVec);
    }
}

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N; 
    cin >> N;

    int fir, sec;
    cin >> fir >> sec;

    int M;
    cin >> M;

    vector<vector<int>> relativeVec(N+1);

    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;

        relativeVec[a].push_back(b);
        relativeVec[b].push_back(a);
    }

    vector<bool> checkVec(N + 1);

    dfs(fir, sec, 0, fir ,relativeVec, checkVec);

    if (res == 0)
        cout << -1;
    else
        cout << res;

    return 0;
}