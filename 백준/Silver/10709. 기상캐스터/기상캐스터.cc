#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int H, W;
	cin >> H >> W;

	vector<vector<int>> cloudVec;

	for (int i = 0; i < H; i++)
	{
		vector<int> lineVec;
		for (int j = 0; j < W; j++)
		{
			char value;
			cin >> value;

			if (value == '.')
				lineVec.push_back(-1);
			else
				lineVec.push_back(0);
		}
		cloudVec.push_back(lineVec);
	}

	for (int i = 0; i < H; i++)
	{
		for (int j = 1; j < W; j++)
		{
			if (cloudVec[i][j] < 0)
			{
				if (cloudVec[i][j - 1] == 0)
					cloudVec[i][j] = 1;
				else if (cloudVec[i][j - 1] > 0)
					cloudVec[i][j] = cloudVec[i][j - 1] + 1;
			}
		}
	}

	for (int i = 0; i < cloudVec.size(); i++)
	{
		for (int j = 0; j < cloudVec[i].size(); j++)
			cout << cloudVec[i][j] << " ";

		cout << endl;
	}

	return 0;
}