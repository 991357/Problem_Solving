#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

vector<string> changeVec = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

string toEnglish(int num)
{
    if (num < 10)
        return changeVec[num];
    else
        return changeVec[num / 10] + " " + changeVec[num % 10];
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int M, N;
    cin >> M >> N;

    vector<pair<string, int>> numVec;

    for (int i = M; i <= N; i++)
        numVec.push_back({ toEnglish(i), i });

    sort(numVec.begin(), numVec.end());

    int cnt = 0;
    for (int i = 0; i < numVec.size(); i++)
    {
        cout << numVec[i].second << " ";
        cnt++;

        if (cnt == 10)
        {
            cnt = 0;
            cout << "\n";
        }
    }
}