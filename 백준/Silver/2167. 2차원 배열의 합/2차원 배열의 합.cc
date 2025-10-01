#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char** argv)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;

	cin >> N >> M;

	vector<vector<int>> arr;

	for (int i = 0; i < N; i++)
	{
		vector<int> tempVec;
		for (int j = 0; j < M; j++)
		{
			int value;
			cin >> value;
			tempVec.push_back(value);
		}
		arr.push_back(tempVec);
	}

	// prefix
	vector<vector<int>> prefix(N + 1, vector<int>(M + 1, 0));
	for (int i = 1; i <= N; i++) 
	{
		for (int j = 1; j <= M; j++) 
		{
			prefix[i][j] = arr[i - 1][j - 1]
				+ prefix[i - 1][j]
				+ prefix[i][j - 1]
				- prefix[i - 1][j - 1];
		}
	}

	int K;
	cin >> K;
	while (K--) 
	{
		int i, j, x, y;

		cin >> i >> j >> x >> y;

		int result = prefix[x][y]
			- prefix[i - 1][y]
			- prefix[x][j - 1]
			+ prefix[i - 1][j - 1];

		cout << result << "\n";
	}

	return 0;
}