#include <iostream>
#include <deque>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    deque<pair<int, int>> balDeq;

    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        balDeq.push_back({ i + 1, num });
    }

    int idx = 0;

    for (int i = 0; i < N; i++)
    {
        int balloonNum = balDeq[idx].first;
        int move = balDeq[idx].second;

        cout << balloonNum << " ";

        balDeq.erase(balDeq.begin() + idx);

        if (balDeq.empty())
            break;

        int size = balDeq.size();

        if (move > 0)
            idx = (idx + move - 1) % size;
        else
            idx = ((idx + move) % size + size) % size;
    }

    return 0;
}