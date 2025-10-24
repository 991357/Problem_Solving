#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int bfs(int N, int M, vector<vector<int>> map)
{
	queue<tuple<int, int, int>> bfsQ;
	bfsQ.push(make_tuple(0, 0, 1));
	vector<vector<bool>> check(N, vector<bool>(M));
	check[0][0] = true;

	while (!bfsQ.empty())
	{
		auto cur = bfsQ.front();
		bfsQ.pop();
		int x = get<0>(cur);
		int y = get<1>(cur);
		int d = get<2>(cur);

		if (x == N - 1 && y == M - 1)
		{
			return d;
		}

		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M && !check[nx][ny] && map[nx][ny] != 0)
			{
				check[nx][ny] = true;
				bfsQ.push(make_tuple(nx, ny, d + 1));
			}
		}
	}

	return -1;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;

	vector<vector<int>> map(N, vector<int>(M));
	for (int i = 0; i < N; i++)
	{
		string line = "";
		cin >> line;
		for (int j = 0; j < line.size(); j++)
			map[i][j] = line[j] - '0';
	}
	cout << bfs(N, M, map);
}