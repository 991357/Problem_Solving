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

    int sum = 0;
    int visitorMax = 0;
    int sameCnt = 0;

    for (int i = 0; i < X; i++)
        sum += visitorVec[i];

    visitorMax = sum;
    sameCnt = 1;

    for (int i = X; i < N; i++)
    {
        sum = sum - visitorVec[i - X] + visitorVec[i];

        if (visitorMax < sum)
        {
            visitorMax = sum;
            sameCnt = 1;
        }
        else if (visitorMax == sum)
            sameCnt++;
    }

    if (visitorMax == 0)
        cout << "SAD";
    else
        cout << visitorMax << "\n" << sameCnt;

    return 0;
}