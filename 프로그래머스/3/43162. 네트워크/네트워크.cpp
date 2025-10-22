#include <string>
#include <vector>
using namespace std;

void dfs(int idx, const vector<vector<int>>& computers, vector<bool>& visitedVec)
{
    visitedVec[idx] = true;

    for (int i = 0; i < computers[idx].size(); i++)
    {
        if (computers[idx][i] == 1 && !visitedVec[i])
            dfs(i, computers, visitedVec);
    }
}

int solution(int n, vector<vector<int>> computers)
{
    int answer = 0;
    vector<bool> visitedVec(n, false);

    for (int i = 0; i < n; i++)
    {
        if (!visitedVec[i])
        {
            dfs(i, computers, visitedVec);
            answer++;
        }
    }

    return answer;
}
