#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	vector<vector<char>> posVec(T, vector<char>(T));
	for (int i = 0; i < T; i++)
	{
		for (int j = 0; j < T; j++)
		{
			cin >> posVec[i][j];
		}
	}

	int row = 0, col = 0;

	for (int i = 0; i < T; i++)
	{
		int count = 0;
		for (int j = 0; j < T; j++)
		{
			if (posVec[i][j] == '.')
				count++;
			if (posVec[i][j] == 'X' || j == T - 1)
			{
				if (count >= 2)
					row++;
				count = 0;
			}
		}
	}

	for (int j = 0; j < T; j++)
	{
		int count = 0;
		for (int i = 0; i < T; i++)
		{
			if (posVec[i][j] == '.')
				count++;
			if (posVec[i][j] == 'X' || i == T - 1)
			{
				if (count >= 2)
					col++;
				count = 0;
			}
		}
	}

	cout << row << " " << col;
	return 0;
}
