#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> diffVec(5);
    for(int i = 0; i < 5; i++)
    {
        int diff;
        cin >> diff;
        diffVec[i] = diff;
    }

    vector<priority_queue<int, vector<int>, greater<int>>> problemVec(6);

    for(int i = 0; i < N; i++)
    {
        int d, t;
        cin >> d >> t;
        problemVec[d].push(t);
    }

    int sum = 0;

    for(int i = 1; i <= 5; i++)
    {
        // problemVec[i]에서 diff[i-1] 만큼 꺼내
        int before = problemVec[i].top();
        for(int j = 0; j < diffVec[i-1]; j++)
        {
            int cur = problemVec[i].top();
            sum += cur - before;
            sum += cur;
            before = cur;
            problemVec[i].pop();
        }
        sum += 60;
    }

    cout << sum - 60; 

    return 0;
}
