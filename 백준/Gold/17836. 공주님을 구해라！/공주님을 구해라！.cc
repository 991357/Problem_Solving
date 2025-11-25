#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;
int N, M, T;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

struct Node
{
	int x, y, d;
	bool isSword;
};

int bfs(vector<vector<int>> &mapVec)
{
	deque<Node> bfsQ;
	vector<vector<vector<int>>> checkVec(N, vector<vector<int>>(M, vector<int>(2, INT_MAX)));
	checkVec[0][0][0] = 0;
	bfsQ.push_back({0, 0, 0, false});
	int min = INT_MAX;

	while (!bfsQ.empty())
	{
		auto cur = bfsQ.front();
		bfsQ.pop_front();

		if (mapVec[cur.x][cur.y] == 2)
		{
			cur.isSword = true;
		}

		// 더 오래 걸리는 길은 패스
		if (checkVec[cur.x][cur.y][cur.isSword] < cur.d)
			continue;

		if (cur.x == N - 1 && cur.y == M - 1)
			min = std::min(min, cur.d);

		for (int i = 0; i < 4; i++)
		{
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M)
			{
				if (cur.isSword)
				{
					if (mapVec[nx][ny] != 1)
					{
						int nd = cur.d + 1;
						if (checkVec[nx][ny][cur.isSword] > nd)
						{
							checkVec[nx][ny][cur.isSword] = nd;
							bfsQ.push_back({ nx, ny, nd, cur.isSword });
						}
					}
					else if(mapVec[nx][ny] == 1)
					{
						int nd = cur.d + 1;
						if (checkVec[nx][ny][cur.isSword] > nd)
						{
							checkVec[nx][ny][cur.isSword] = nd;
							bfsQ.push_back({ nx, ny, nd, cur.isSword });
						}
					}
				}
				else
				{
					if (mapVec[nx][ny] != 1)
					{
						int nd = cur.d + 1;
						if (checkVec[nx][ny][cur.isSword] > nd)
						{
							checkVec[nx][ny][cur.isSword] = nd;
							bfsQ.push_back({ nx, ny, nd, cur.isSword });
						}
					}
				}
			}
		}
	}

	return min == INT_MAX ? -1 : min;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M >> T;

	vector<vector<int>> mapVec(N, vector<int>(M));
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int n;
			cin >> n;
			mapVec[i][j] = n;
		}
	}

	int res = bfs(mapVec);

	if (res == -1)
		cout << "Fail";
	else
	{
		if (res > T)
			cout << "Fail";
		else
			cout << res;
	}

	return 0;
}