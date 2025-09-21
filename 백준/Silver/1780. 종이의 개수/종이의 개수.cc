#include <iostream>
#include <vector>

using namespace std;

int N;
vector<vector<int>> arr;
int paper1, paper2, paper3;

bool CheckPaper(int x, int y, int size)
{
	int type = arr[x][y];

	for (int i = x; i < x + size; i++)
	{
		for (int j = y; j < y + size; j++)
		{
			if (arr[i][j] != type)
				return false;
		}
	}
	return true;
}

void division(int x, int y, int size)
{
	if (CheckPaper(x, y, size))
	{
		if (arr[x][y] == -1) paper1++;
		else if (arr[x][y] == 0) paper2++;
		else if (arr[x][y] == 1) paper3++;

		return;
	}

	int newSize = size / 3;

	for (int i = x; i < x + size; i += newSize)
	{
		for (int j = y; j < y + size; j += newSize)
			division(i, j, newSize);
	}
}

int main(int argc, char** argv)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	arr.assign(N, vector<int>(N));

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cin >> arr[i][j];
		}
	}

	division(0, 0, N);
	cout << paper1 << "\n" << paper2 << "\n" << paper3;
}