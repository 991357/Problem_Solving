#include <iostream>
#include <vector>

using namespace std;

struct Area
{
    int value;
    bool isCheck;
};

int bingoCnt;

void FindAndCheck(int n, vector<vector<Area>>& bingoVec)
{
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            if (bingoVec[i][j].value == n)
            {
                bingoVec[i][j].isCheck = true;
                return;
            }
        }
    }
}

bool CheckBingo(vector<vector<Area>>& bingoVec)
{
    int cntTemp = 0;

    // 가로로 만들어진 빙고
    for (int i = 0; i < 5; i++)
    {
        bool isBingo = true;
        for (int j = 0; j < 5; j++)
        {
            if (!bingoVec[i][j].isCheck)
            {
                isBingo = false;
                break;
            }
        }
        if (isBingo)
            cntTemp++;
    }

    // 세로로 만들어진 빙고
    for (int i = 0; i < 5; i++)
    {
        bool isBingo = true;
        for (int j = 0; j < 5; j++)
        {
            if (!bingoVec[j][i].isCheck)
            {
                isBingo = false;
                break;
            }
        }
        if (isBingo)
            cntTemp++;
    }

    // 대각으로 만들어진 빙고
    bool isBingo = true;
    for (int i = 0; i < 5; i++)
    {
        if (!bingoVec[i][i].isCheck)
        {
            isBingo = false;
            break;
        }
    }
    if (isBingo)
        cntTemp++;

    bool isBingo_ = true;
    for (int i = 4; i >= 0; i--)
    {
        if (!bingoVec[i][4-i].isCheck)
        {
            isBingo_ = false;
            break;
        }
    }
    if (isBingo_)
        cntTemp++;

    if (cntTemp >= 3)
        return true;
    else
        return false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    bingoCnt = 0;

    vector<vector<Area>> bingoVec(5, vector<Area>(5));
    vector<vector<int>> callVec(5, vector<int>(5));

    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            int n;
            cin >> n;
            bingoVec[i][j] = { n, false };
        }
    }

    int turn = 1;
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            int n;
            cin >> n;

            FindAndCheck(n, bingoVec);

            if (turn >= 12)
            {
                if (CheckBingo(bingoVec))
                {
                    cout << turn;
                    return 0;
                }
            }
            turn++;
        }
    }
}