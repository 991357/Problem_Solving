#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <climits>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<priority_queue<int, vector<int>, greater<int>>> numPq(N);

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            int n;
            cin >> n;
            numPq[i].push(n);
        }
    }

    vector<int> tempVec(N);
    int diffMin = INT_MAX;

    // 초기값 설정
    for (int i = 0; i < N; i++)
    {
        tempVec[i] = numPq[i].top();
        numPq[i].pop();
    }

    while (true)
    {
        int min = INT_MAX;
        int max = 0;
        int minIdx = 0;

        for (int i = 0; i < N; i++)
        {
            if (tempVec[i] < min)
            {
                min = tempVec[i];
                minIdx = i;
            }
            max = std::max(max, tempVec[i]);
        }

        int diff = max - min;
        diffMin = std::min(diffMin, diff);

        if (numPq[minIdx].size() == 0)
            break;

        tempVec[minIdx] = numPq[minIdx].top();
        numPq[minIdx].pop();
    }

    cout << diffMin;

    return 0;
}