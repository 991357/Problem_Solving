#include <inttypes.h>
#include <iostream>
#include <string>
#include <vector>

using namespace  std;

bool isNumK(int num, int K)
{
    return num == K ? true : false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    string pos = " ";

    cin >> N >> K;

    vector<vector<int>> snailVec;

    for (int i = 0; i < N; i++)
    {
        vector<int> tempVec;
        for (int j = 0; j < N; j++)
            tempVec.push_back(0);

        snailVec.push_back(tempVec);
    }

    int value = N * N;
    int colIndex = 0, rowIndex = 0, maxIndex = N - 1;

    for (int i = 0; i < N; i++)
    {
        snailVec[i][rowIndex] = value;

        if (isNumK(value, K))
            pos = to_string(i + 1) + " " + to_string(rowIndex + 1);

        value--;
        colIndex++;
    }

    rowIndex = 1;
    colIndex--;
    bool isLeftTurn = false;

    for (int i = 0; i < N + (N - 2); i++)
    {
        if (!isLeftTurn)
        {
            for (int j = 0; j < maxIndex; j++)
            {
                snailVec[colIndex][rowIndex] = value;
                if (isNumK(value, K))
                    pos = to_string(colIndex + 1) + " " + to_string(rowIndex + 1);
                value--;
                rowIndex++;
            }
            colIndex--;
            rowIndex--;
            for (int j = maxIndex; j > 0; j--)
            {
                snailVec[colIndex][rowIndex] = value;
                if (isNumK(value, K))
                    pos = to_string(colIndex + 1) + " " + to_string(rowIndex + 1);
                value--;
                colIndex--;
            }
            rowIndex--;
            colIndex++;
            isLeftTurn = true;
        }
        else
        {
            for (int i = 0; i < maxIndex; i++)
            {
                snailVec[colIndex][rowIndex] = value;
                if (isNumK(value, K))
                    pos = to_string(colIndex + 1) + " " + to_string(rowIndex + 1);

                value--;
                rowIndex--;
            }
            colIndex++;
            rowIndex++;
            for (int i = 0; i < maxIndex; i++)
            {
                snailVec[colIndex][rowIndex] = value;
                if (isNumK(value, K))
                    pos = to_string(colIndex + 1) + " " + to_string(rowIndex + 1);
                value--;
                colIndex++;
            }
            rowIndex++;
            colIndex--;
            isLeftTurn = false;
        }
        maxIndex--;

    }

    for (int i = 0; i < snailVec.size(); i++)
    {
        for (int j = 0; j < snailVec[i].size(); j++)
            cout << snailVec[i][j] << " ";
        cout << "\n";
    }
    cout << pos;

    return 0;
}