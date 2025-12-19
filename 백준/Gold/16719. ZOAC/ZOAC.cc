#include <iostream>
#include <string>
#include <vector>

using namespace std;

string str;
vector<bool> visited;

void recursive(int l, int r)
{
    if (l > r) return;

    // 가장 작은 문자랑 위치
    char mn = 'Z' + 1;
    int idx = -1;

    // 가장 작은 문자를 찾아
    for (int i = l; i <= r; i++)
    {
        if (!visited[i] && str[i] < mn)
        {
            mn = str[i];
            idx = i;
        }
    }

    visited[idx] = true;

    // 출력
    for (int i = 0; i < str.size(); i++)
    {
        if (visited[i])
            cout << str[i];
    }
    cout << '\n';

    recursive(idx + 1, r);
    recursive(l, idx - 1);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> str;
    visited.resize(str.size(), false);

    recursive(0, str.size() - 1);

    return 0;
}
