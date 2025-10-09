#include <iostream>
#include <vector>

using namespace std;

string isbn;
int sum = 0;

int main()
{
    ios::sync_with_stdio(0), cin.tie(0);

    cin >> isbn;

    bool isStarEven;

    for (int i = 0; i < 13; ++i)
    {
        bool isEven = i % 2;

        if (isbn[i] == '*')
        {
            isStarEven = isEven;
        }
        else
        {
            sum += (isbn[i] - '0') * (isEven ? 3 : 1);
        }
    }

    sum %= 10;

    if (isStarEven)
    {
        for (int i = 0; i < 10; ++i)
        {
            if ((sum + i * 3) % 10 == 0)
            {
                cout << i;
                break;
            }
        }
    }
    else
    {
        cout << (10 - sum) % 10;
    }
    return 0;
}