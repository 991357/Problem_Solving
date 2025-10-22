#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int H, W, curCheeseCnt, beforeCheeseCnt, time;
vector<vector<int>> mapVec;
vector<vector<bool>> checkVec;

int dy[4] = { -1, 1, 0, 0 };
int dx[4] = { 0, 0, -1, 1 };

void PrintInfo()
{
	cout << "\n";

	// 맵
	for (int i = 0; i < mapVec.size(); i++)
	{
		for (int j = 0; j < mapVec[i].size(); j++)
			cout << mapVec[i][j] << " ";
		cout << "\n";
	}
}

void holeBfs()
{
	queue<pair<int, int>> bfsQ;
	bfsQ.push({ 0, 0 });
	checkVec.assign(H, vector<bool>(W));
	checkVec[0][0] = true;

	while (!bfsQ.empty())
	{
		pair<int, int> cur = bfsQ.front();
		bfsQ.pop();

		for (int i = 0; i < 4; i++)
		{
			int ny = cur.first + dy[i];
			int nx = cur.second + dx[i];

			if (nx >= 0 && ny >= 0 && nx < W && ny < H && !checkVec[ny][nx] && mapVec[ny][nx] == 0)
			{
				checkVec[ny][nx] = true;
				bfsQ.push({ ny, nx });
			}
		}
	}
}

int main() 
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> H >> W;
	curCheeseCnt = 0;
	beforeCheeseCnt = 0;
	time = 0;

	mapVec.assign(H, vector<int>(W));
	for (int i = 0; i < H; i++)
	{
		for (int j = 0; j < W; j++)
		{
			int num = 0;
			cin >> num;
			mapVec[i][j] = num;

			if (num == 1)
				curCheeseCnt++;
		}
	}

	while (curCheeseCnt != 0)
	{
		beforeCheeseCnt = curCheeseCnt;

		// 구멍 찾기
		holeBfs();

		int removeCnt = 0;
		// 치즈가 외부 공기와 맞닿아 있으면 0으로 바꿔야함
		for (int i = 0; i < H; i++)
		{
			for (int j = 0; j < W; j++)
			{
				if (mapVec[i][j] == 1)
				{
					for (int k = 0; k < 4; k++)
					{
						int ny = i + dy[k];
						int nx = j + dx[k];

						if (nx >= 0 && ny >= 0 && nx < W && ny < H && checkVec[ny][nx])
						{
							// 외부공기와 맞닿은 치즈
							mapVec[i][j] = 0;
							curCheeseCnt--;
							removeCnt++;
							break;
						}
					}
				}
			}
		}

		time++;
	}

	cout << time << "\n" << beforeCheeseCnt << "\n";

	return 0;
}