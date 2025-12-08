#include <iostream>
#include <vector>
#include <string>

using namespace std;

int dx[8] = { -1, -1, -1, 0, 1, 1, 1, 0 };
int dy[8] = { -1, 0, 1, 1, 1, 0, -1, -1 };

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (true)
    {
        int r, c;
        cin >> r >> c;

        if (r == 0 && c == 0)
            break;

        vector<vector<char>> mapVec(r, vector<char>(c));

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                char c;
                cin >> c;
                mapVec[i][j] = c;
            }
        }
        
        for (int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if (mapVec[i][j] == '.')
                {
                    int cnt = 0;
                    for (int k = 0; k < 8; k++)
                    {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < r && ny < c && mapVec[nx][ny] == '*')
                            cnt++;
                    }
                    mapVec[i][j] = (char)(cnt + '0');
                }
            }
        }

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
                cout << mapVec[i][j];
            cout << "\n";
        }
    }
}
