#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	vector<int> heightVec(9);
	for (int& n : heightVec)
		cin >> n;

	int sum = 0;

	for (int n : heightVec)
		sum += n;

	bool isEnd = false;

	for (int i = heightVec.size() - 1; i > 0; i--)
	{
		for (int j = i - 1; j >= 0; j--)
		{
			if (sum - (heightVec[i] + heightVec[j]) == 100)
			{
				vector<int> numberVec;

				for (int k = 0; k < heightVec.size(); k++)
				{
					if (k == i || k == j)
						continue;

					numberVec.push_back(heightVec[k]);
				}
				sort(numberVec.begin(), numberVec.end());

				for (int n : numberVec)
					cout << n << "\n";

				isEnd = true;
				break;
			}
		}
		if (isEnd)
			break;
	}
	return 0;
}