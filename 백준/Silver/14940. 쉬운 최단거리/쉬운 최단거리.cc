#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
vector<vector<int>> mapVec;
vector<vector<int>> answerVec;
vector<vector<bool>> checkVec;
int startPos[2];

struct Node
{
	int y, x, d;
};

int dy[4] = { -1, 1, 0, 0 };
int dx[4] = { 0, 0, -1, 1 };

void bfs()
{
	queue<Node> bfsQ;
	checkVec[startPos[0]][startPos[1]] = true;
	bfsQ.push({ startPos[0], startPos[1], 0 });

	while (!bfsQ.empty())
	{
		Node cur = bfsQ.front();
		bfsQ.pop();
		
		answerVec[cur.y][cur.x] = cur.d;

		for (int i = 0; i < 4; i++)
		{
			int ny = cur.y + dy[i];
			int nx = cur.x + dx[i];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n && !checkVec[ny][nx] && mapVec[ny][nx] != 0)
			{
				checkVec[ny][nx] = true;
				bfsQ.push({ ny, nx, cur.d + 1 });
			}
		}
	}
}

int main() 
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n >> m;

	mapVec.assign(n, vector<int>(m));
	answerVec.assign(n, vector<int>(m));
	checkVec.assign(n, vector<bool>(m));

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			int num = 0;
			cin >> num;
			mapVec[i][j] = num;

			if (num == 2)
			{
				startPos[0] = i;
				startPos[1] = j;
			}
		}
	}

	bfs();

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (mapVec[i][j] == 1 && answerVec[i][j] == 0)
				cout << -1 << " ";
			else
				cout << answerVec[i][j] << " ";
		}
		cout << "\n";
	}

	return 0;
}