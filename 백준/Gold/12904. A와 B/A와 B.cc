#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string S, T;
    cin >> S >> T;

    int cnt = 0, res = 0;
    string original = T;

    while (true)
    {
        if (S == original)
        {
            res = 1;
            break;
        }

        if (cnt >= T.size())
            break;

        if (original[original.size() - 1] == 'A')
        {
            original.resize(original.size() - 1);
            cnt++;
            continue;
        }
        else
        {
            original.resize(original.size() - 1);
            reverse(original.begin(), original.end());
            cnt++;
            continue;
        }
    }

    cout << res;

    return 0;
}