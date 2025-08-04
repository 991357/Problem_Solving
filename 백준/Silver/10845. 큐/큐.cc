#include <iostream>
#include <queue>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int T; cin >> T;

	queue<int> numQueue;

	for (int i = 0; i < T; i++)
	{
		string value; cin >> value;

		if (value == "push")
		{
			int num; cin >> num;
			numQueue.push(num);
		}
		else if (value == "pop")
		{
			if (numQueue.size() == 0)
			{
				cout << -1 << "\n";
			}
			else
			{
				cout << numQueue.front() << "\n";
				numQueue.pop();
			}
		}
		else if (value == "size")
		{
			cout << numQueue.size() << "\n";
		}
		else if (value == "empty")
		{
			if (numQueue.size() == 0)
				cout << 1 << "\n";
			else
				cout << 0 << "\n";
		}
		else if (value == "front")
		{
			if (numQueue.size() == 0)
				cout << -1 << "\n";
			else
				cout << numQueue.front() << "\n";
		}
		else if (value == "back")
		{
			if (numQueue.size() == 0)
				cout << -1 << "\n";
			else
				cout << numQueue.back() << "\n";
		}
	}

	return 0;
}