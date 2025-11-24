#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <map>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		int n;
		cin >> n;

		priority_queue<long> positivePq;
		priority_queue<long, vector<long>, greater<>> negativePq;
		map<long, long> cntMap;

		for (int i = 0; i < n; i++)
		{
			char type;
			long number;

			cin >> type >> number;

			if (type == 'I')
			{
				positivePq.push(number);
				negativePq.push(number);
				cntMap[number]++;
			}
			else
			{
				if (number == 1)
				{
					while (!positivePq.empty() && cntMap[positivePq.top()] == 0)
						positivePq.pop();

					if (!positivePq.empty())
					{
						cntMap[positivePq.top()]--;
						positivePq.pop();
					}
				}
				else
				{
					while (!negativePq.empty() && cntMap[negativePq.top()] == 0)
						negativePq.pop();

					if (!negativePq.empty())
					{
						cntMap[negativePq.top()]--;
						negativePq.pop();
					}
				}
			}
		}

		while (!positivePq.empty() && cntMap[positivePq.top()] == 0)
			positivePq.pop();
		while (!negativePq.empty() && cntMap[negativePq.top()] == 0)
			negativePq.pop();

		if (positivePq.empty() || negativePq.empty())
			cout << "EMPTY\n";
		else
			cout << positivePq.top() << " " << negativePq.top() << "\n";
	}

	return 0;
}