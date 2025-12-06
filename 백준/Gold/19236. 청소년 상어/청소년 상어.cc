#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Fish
{
	int x, y, v, d;
	bool isFish;
};

struct Shark
{
	int x, y, d;
};

vector<pair<int, int>> directVec;
int res = 0;

void MoveFish(vector<vector<Fish>>& mapVec, Shark shark)
{
	// 번호 순서대로 물고기 이동 시켜
	for (int num = 1; num <= 16; num++)
	{
		// 현재 번호의 물고기
		int fx = -1, fy = -1;

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (mapVec[i][j].isFish && mapVec[i][j].v == num)
				{
					fx = i;
					fy = j;
					break;
				}
			}
			if (fx != -1) break;
		}

		// 이자리에 물고기가 없어요
		if (fx == -1)
			continue;

		Fish& cur = mapVec[fx][fy];
		int dTemp = cur.d;

		for (int i = 0; i < 8; i++)
		{
			int nx = fx + directVec[dTemp].first;
			int ny = fy + directVec[dTemp].second;

			// 이동 가능 쳌
			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 &&
				!(nx == shark.x && ny == shark.y))
			{
				cur.d = dTemp;

				Fish temp = mapVec[nx][ny];
				mapVec[nx][ny] = cur;
				mapVec[nx][ny].x = nx;
				mapVec[nx][ny].y = ny;

				mapVec[fx][fy] = temp;
				mapVec[fx][fy].x = fx;
				mapVec[fx][fy].y = fy;

				break;
			}
			else
			{
				dTemp++;

				if (dTemp == 8) 
					dTemp = 0;
			}
		}
	}
}

void DFS(vector<vector<Fish>> mapVec, Shark shark, int total)
{
	MoveFish(mapVec, shark);

	vector<pair<int, int>> possibleVec;
	int xTemp = shark.x;
	int yTemp = shark.y;

	while (true)
	{
		int nx = xTemp + directVec[shark.d].first;
		int ny = yTemp + directVec[shark.d].second;

		if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4)
		{
			if (mapVec[nx][ny].isFish)
			{
				possibleVec.push_back({ nx, ny });
			}
			xTemp = nx;
			yTemp = ny;
		}
		else
		{
			break;
		}
	}

	// 불가
	if (possibleVec.empty())
	{
		res = std::max(res, total);
		return;
	}

	for (auto& pos : possibleVec)
	{
		vector<vector<Fish>> nextMap = mapVec;
		Shark nextShark;

		nextShark.x = pos.first;
		nextShark.y = pos.second;
		nextShark.d = nextMap[pos.first][pos.second].d;

		int fishValue = nextMap[pos.first][pos.second].v;
		nextMap[pos.first][pos.second].isFish = false;

		DFS(nextMap, nextShark, total + fishValue);
	}
}

int main()
{
	vector<vector<Fish>> mapVec(4, vector<Fish>(4));

	// 방향
	directVec.push_back({ -1, 0 });
	directVec.push_back({ -1, -1 });
	directVec.push_back({ 0, -1 });
	directVec.push_back({ 1, -1 });
	directVec.push_back({ 1, 0 });
	directVec.push_back({ 1, 1 });
	directVec.push_back({ 0, 1 });
	directVec.push_back({ -1, 1 });

	for (int i = 0; i < 4; i++)
	{
		vector<int> listVec;
		for (int j = 0; j < 8; j++)
		{
			int n;
			cin >> n;
			listVec.push_back(n);
		}

		int yTemp = 0;
		for (int j = 0; j < listVec.size(); j++)
		{
			mapVec[i][yTemp] = { i, yTemp, listVec[j], listVec[j + 1] - 1, true };
			j++;
			yTemp++;
			if (j >= 6) break;
		}
	}

	// 처음 상어는 0, 0 에 있는 물고기를 먹고 그 방향을 가짐.
	Shark shark;
	shark.x = 0;
	shark.y = 0;
	shark.d = mapVec[0][0].d;
	int firstFish = mapVec[0][0].v;
	mapVec[0][0].isFish = false;

	DFS(mapVec, shark, firstFish);

	cout << res;

	return 0;
}