#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <algorithm>

using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int bfs(int startX, int startY, vector<vector<char>> &mapVec, int N, int M)
{
	vector<vector<bool>> checkVec(N, vector<bool>(M));
	queue<pair<int, pair<int, int>>> bfsQ;
	checkVec[startX][startY] = true;
	bfsQ.push({ startX, {startY, 0} });

	int maxDist = 0;

	while (!bfsQ.empty())
	{
		auto cur = bfsQ.front();
		bfsQ.pop();

		int x = cur.first;
		int y = cur.second.first;
		int d = cur.second.second;

		maxDist = max(maxDist, d);

		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M &&
				!checkVec[nx][ny] && mapVec[nx][ny] == 'L')
			{
				checkVec[nx][ny] = true;
				bfsQ.push({ nx, {ny, d + 1} });
			}
		}
	}

	return maxDist;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;

	vector<vector<char>> mapVec(N, vector<char>(M));
	for (int i = 0; i < N; i++)
	{
		string str;
		cin >> str;

		for (int j = 0; j < str.size(); j++)
			mapVec[i][j] = str[j];
	}

	int answer = 0;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (mapVec[i][j] == 'L')
			{
				int dist = bfs(i, j, mapVec, N, M);
				answer = max(answer, dist);
			}
		}
	}

	cout << answer;

	return 0;
}