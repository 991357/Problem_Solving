#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <climits>

using namespace std;

int turn = 1;

void dfs(int start, vector<int>& checkVec, vector<vector<int>> &numVec)
{
    if (checkVec[start])
        return;

    checkVec[start] = turn++;
    
    for (int i = 0; i < numVec[start].size(); i++)
        dfs(numVec[start][i], checkVec, numVec);
}

int main()
{
    int N, M, K;
    cin >> N >> M >> K;

    vector<vector<int>> numVec(N + 1);

    for (int i = 0; i < M; i++)
    {
        int fir, sec;
        cin >> fir >> sec;

        numVec[fir].push_back(sec);
        numVec[sec].push_back(fir);
    }

    for (int i = 1; i <= N; i++)
        sort(numVec[i].begin(), numVec[i].end());

    vector<int> checkVec(N+1);

    dfs(K, checkVec, numVec);
    
    for (int i = 1; i <= N; i++)
        cout << checkVec[i] << "\n";

    return 0;
}
