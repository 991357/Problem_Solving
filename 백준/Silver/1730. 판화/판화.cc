#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;
	vector<vector<char>> canvasVec;
	for (int i = 0; i < T; i++)
	{
		vector<char> tempVec;

		for (int j= 0; j < T; j++)
			tempVec.push_back('.');

		canvasVec.push_back(tempVec);
	}

	string value;
	cin >> value;

	int col = 0, row = 0;

	for (int i = 0; i < value.size(); i++)
	{
		bool isLast = false;

		if (value[i] == 'U')
		{
			if (col != 0)
			{
				if (canvasVec[col][row] == '-' || canvasVec[col][row] == '+')
					canvasVec[col][row] = '+';
				else
					canvasVec[col][row] = '|';

				isLast = false;
				col--;
				if (col < 0)
				{
					isLast = true;
					col = 0;
				}

				if (!isLast)
				{
					if (canvasVec[col][row] == '-' || canvasVec[col][row] == '+')
						canvasVec[col][row] = '+';
					else
						canvasVec[col][row] = '|';
				}
			}
		}
		else if (value[i] == 'D')
		{
			if (col != T - 1)
			{
				if (canvasVec[col][row] == '-' || canvasVec[col][row] == '+')
					canvasVec[col][row] = '+';
				else
					canvasVec[col][row] = '|';

				isLast = false;
				col++;
				if (col > T - 1)
				{
					isLast = true;
					col = T - 1;
				}

				if (!isLast)
				{
					if (canvasVec[col][row] == '-' || canvasVec[col][row] == '+')
						canvasVec[col][row] = '+';
					else
						canvasVec[col][row] = '|';
				}
			}
		}
		else if (value[i] == 'R')
		{
			if (row != T - 1)
			{
				if (canvasVec[col][row] == '|' || canvasVec[col][row] == '+')
					canvasVec[col][row] = '+';
				else
					canvasVec[col][row] = '-';

				isLast = false;

				row++;

				if (row > T - 1)
				{
					isLast = true;
					row = T - 1;
				}

				if (!isLast)
				{
					if (canvasVec[col][row] == '|' || canvasVec[col][row] == '+')
						canvasVec[col][row] = '+';
					else
						canvasVec[col][row] = '-';
				}
			}
		}
		else if (value[i] == 'L')
		{
			if (row != 0)
			{
				if (canvasVec[col][row] == '|' || canvasVec[col][row] == '+')
					canvasVec[col][row] = '+';
				else
					canvasVec[col][row] = '-';

				isLast = false;

				row--;

				if (row < 0)
				{
					isLast = true;
					row = 0;
				}

				if (!isLast)
				{
					if (canvasVec[col][row] == '|' || canvasVec[col][row] == '+')
						canvasVec[col][row] = '+';
					else
						canvasVec[col][row] = '-';
				}
			}
		}
	}

	for (int i = 0; i < canvasVec.size(); i++)
	{
		for (int j = 0; j < canvasVec[i].size(); j++)
			cout << canvasVec[i][j];
		cout << "\n";
	}

	return 0;
}