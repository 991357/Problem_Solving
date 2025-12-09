#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    vector<int> numVec(N);

    for (int i = 0; i < N; i++)
    {
        int n;
        cin >> n;
        numVec[i] = n;
    }

    sort(numVec.begin(), numVec.end());

    long long x = 0;

    for (int i = 0; i < N; i++) 
    {
        if (numVec[i] > x + 1)
            break;

        x += numVec[i];
    }

    cout << x + 1;
}

