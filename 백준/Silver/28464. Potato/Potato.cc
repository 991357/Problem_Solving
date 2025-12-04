#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    deque<int> deq;

    for (int i = 0; i < N; i++)
    {
        int n;
        cin >> n;
        deq.push_back(n);
    }
    sort(deq.begin(), deq.end());

    int bak = 0, sung = 0;
    bool bakTurn = true;

    while (!deq.empty())
    {
        if (bakTurn)
        {
            bak += deq.back();
            deq.pop_back();
            bakTurn = false;
        }
        else
        {
            sung += deq.front();
            deq.pop_front();
            bakTurn = true;
        }
    }

    cout << sung << " " << bak;
}
