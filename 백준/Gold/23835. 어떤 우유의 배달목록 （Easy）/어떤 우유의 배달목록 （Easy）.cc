#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <sstream>
#include <algorithm>

using namespace std;

int N, Q;
vector<vector<int>> linkVec;
vector<int> milkCntVec;

vector<int> findPath(int st, int en)
{
	vector<int> parent(N + 1, -1);
	queue<int> q;
	q.push(st);
	parent[st] = st;

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();

		if (cur == en) break;

		for (int next : linkVec[cur])
		{
			if (parent[next] == -1)
			{
				parent[next] = cur;
				q.push(next);
			}
		}
	}

	// 경로 복원
	vector<int> path;
	int cur = en;
	while (cur != st)
	{
		path.push_back(cur);
		cur = parent[cur];
	}
	reverse(path.begin(), path.end());

	return path;
}

void deliverMilk(int st, int en)
{
	vector<int> path = findPath(st, en);

	for (int i = 0; i < path.size(); i++)
	{
		milkCntVec[path[i]] += (i + 1);
	}
}

vector<string> split(string str)
{
	vector<string> result;
	stringstream ss(str);
	string word;

	while (ss >> word)
	{
		result.push_back(word);
	}

	return result;
}

int main()
{
	cin >> N;

	linkVec.resize(N + 1);

	for (int i = 0; i < N - 1; i++)
	{
		int f, s;
		cin >> f >> s;
		linkVec[f].push_back(s);
		linkVec[s].push_back(f);
	}

	cin >> Q;
	milkCntVec.resize(N + 1);
	cin.ignore();

	for (int i = 0; i < Q; i++)
	{
		string line;
		getline(cin, line);
		vector<string> tempVec = split(line);

		if (tempVec[0] == "1")
		{
			int st = stoi(tempVec[1]);
			int en = stoi(tempVec[2]);
			deliverMilk(st, en);
		}
		else
		{
			int cntNum = stoi(tempVec[1]);
			cout << milkCntVec[cntNum] << "\n";
		}
	}

	return 0;
}