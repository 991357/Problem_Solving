#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool ok(int x, const vector<int>& K) 
{
    while (x > 0) 
    {
        int d = x % 10;

        if (find(K.begin(), K.end(), d) == K.end())
            return false;

        x /= 10;
    }
    return true;
}

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, kCnt;
    cin >> N >> kCnt;

    vector<int> K(kCnt);

    for (int i = 0; i < kCnt; i++)
        cin >> K[i];

    for (int i = N; i >= 1; i--) 
    {
        if (ok(i, K)) 
        {
            cout << i;
            break;
        }
    }

    return 0;
}
