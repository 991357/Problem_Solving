#include <string>
#include <vector>
#include <iostream>
using namespace std;

int maxCnt;

void simulation(int k, int sel[], vector<vector<int>> &dungeons)
{
    int cnt = 0;
    int kTemp = k;

    for (int i = 0; i < dungeons.size(); i++)
    {
        if (dungeons[sel[i]][0] <= kTemp)
        {
            kTemp -= dungeons[sel[i]][1];
            cnt++;
        }
    }

    if (maxCnt < cnt)
        maxCnt = cnt;
}

void recursive(int idx, int n, vector<int> &arr, vector<int> &sel, vector<bool> &visited, int k, vector<vector<int>> dungeons)
{
    if (idx == n)
    {
        simulation(k, sel.data(), dungeons);
        return;
    }

    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
        {
            visited[i] = true;
            sel[idx] = arr[i];
            recursive(idx + 1, n, arr, sel, visited, k, dungeons);
            visited[i] = false;
        }
    }
}

int solution(int k, vector<vector<int>> dungeons)
{
    maxCnt = -1;
    int n = dungeons.size();

    vector<int> arr(n), sel(n);
    vector<bool> visited(n, false);

    for (int i = 0; i < n; i++)
        arr[i] = i;

    recursive(0, n, arr, sel, visited, k, dungeons);

    return maxCnt;
}
