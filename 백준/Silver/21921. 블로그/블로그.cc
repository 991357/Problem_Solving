#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main()
{
    int N, X, max;

    cin >> N >> X;

    max = 0;

    vector<int> visitorVec;
    for (int i = 0; i < N; i++)
    {
        int n;
        cin >> n;
        visitorVec.push_back(n);
    }

    int cnt = 0;
    int end = 0;
    int sum = 0;

    int visitorMax = 0;
    int sameCnt = 0;

    for (int i = 0; i < N; i++)
    {
        while (cnt != X)
        {
            sum += visitorVec[end];
            end++;
            cnt++;
        }
        
        if (visitorMax < sum)
        {
            visitorMax = sum;
            sameCnt = 1;
        }
        else if (visitorMax == sum)
            sameCnt++;

        cnt--;
        sum -= visitorVec[i];

        if (end == N)
            break;
    }

    if (visitorMax == 0)
        cout << "SAD";
    else
        cout << visitorMax << "\n" << sameCnt;

    return 0;
}