#include <iostream>
#include <queue>

using namespace std;

int N;
pair<int, int> startPos;
pair<int, int> endPos;

int dx[6] = { -2, -2, 0, 0, 2, 2 };
int dy[6] = { -1, 1, -2, 2, -1, 1 };

int main()
{
	cin >> N;

	int sx, sy, ex, ey;
	cin >> sx >> sy >> ex >> ey;

	startPos = { sx, sy };
	endPos = { ex, ey };

	deque<pair<int, pair<int, int>>> bfsQ;
	vector<vector<bool>> checkVec(N, vector<bool>(N));
	checkVec[startPos.first][startPos.second] = true;
	bfsQ.push_front({ startPos.first, {startPos.second, 0} });

	while (!bfsQ.empty())
	{
		auto cur = bfsQ.front();
		bfsQ.pop_front();
		int d = cur.second.second;

		if (cur.first == endPos.first && cur.second.first == endPos.second)
		{
			cout << d;
			return 0;
		}

		for (int i = 0; i < 6; i++)
		{
			int nx = cur.first + dx[i];
			int ny = cur.second.first + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N && !checkVec[nx][ny])
			{
				checkVec[nx][ny] = true;
				bfsQ.push_back({ nx,{ny, d + 1} });
			}
		}
	}

	cout << -1;

	return 0;
}