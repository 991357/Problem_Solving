#include <iostream>
#include <vector>

using namespace std;

int R, C;

int dr[4] = { -1, 1, 0, 0 };
int dc[4] = { 0, 0, -1, 1 };

int DFS(vector<vector<int>>& mapVec, vector<vector<bool>>& checkVec, vector<vector<int>>& dp, int before, int r, int c)
{
    if (dp[r][c] != -1)
        return dp[r][c];

    checkVec[r][c] = true;

    // b
    if (r == R - 1 && c == C - 1)
    {
        // 도달했음
        checkVec[r][c] = false;
        return 1;
    }

    // i
    dp[r][c] = 0;
    for (int i = 0; i < 4; i++)
    {
        int nr = r + dr[i];
        int nc = c + dc[i];

        if (nr >= 0 && nc >= 0 && nr < R && nc < C && before > mapVec[nr][nc] && !checkVec[nr][nc])
            dp[r][c] += DFS(mapVec, checkVec, dp, mapVec[nr][nc], nr, nc);
    }
    checkVec[r][c] = false;

    return dp[r][c];
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> R >> C;

    vector<vector<int>> mapVec(R, vector<int>(C));

    for (int r = 0; r < R; r++)
    {
        for (int c = 0; c < C; c++)
        {
            int n;
            cin >> n;
            mapVec[r][c] = n;
        }
    }

    vector<vector<bool>> checkVec(R, vector<bool>(C));
    vector<vector<int>> dp(R, vector<int>(C, -1));

    cout << DFS(mapVec, checkVec, dp, mapVec[0][0], 0, 0);
}