#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string str;
    cin >> str;

    int oneCnt = 0;
    int zeroCnt = 0;
    vector<int> oneVec;
    vector<int> zeroVec;
    for (int i = 0; i < str.size(); i++)
    {
        oneVec.push_back(str[i] - '0');
        zeroVec.push_back(str[i] - '0');
    }

    // 다 1로
    for (int i = 0; i < str.size(); i++)
    {
        if (oneVec[i] == 0)
        {
            while (i < str.size() && oneVec[i] == 0)
            {
                oneVec[i] = 1;
                i++;
            }
            i--; 
            oneCnt++;
        }
    }

    // 다 0으로
    for (int i = 0; i < str.length(); i++)
    {
        if (zeroVec[i] == 1)
        {
            while (i < str.size() && zeroVec[i] == 1)
            {
                zeroVec[i] = 0;
                i++;
            }
            i--;
            zeroCnt++;
        }
    }

    if (zeroCnt < oneCnt)
        cout << zeroCnt;
    else
        cout << oneCnt;

    return 0;
}