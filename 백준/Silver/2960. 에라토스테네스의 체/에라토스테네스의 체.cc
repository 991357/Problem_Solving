#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

bool isPrime(int num)
{
	int count = 0;
	for (int i = 1; i <= sqrt(num); i++)
	{
		if (num % i == 0)
		{
			count++;

			if (i != num / i)
				count++;
		}
	}

	if (count == 2)
		return true;
	else
		return false;
}

int main()
{
	int N, K;

	cin >> N >> K;

	int k_Count = 0;

	vector<int> numVec;
	for (int i = 2; i <= N; i++)
		numVec.push_back(i);

	bool isEnd = false;
	int findIndex = 0;
	while (numVec.size() >= 1)
	{
		for (int i = 0; i < numVec.size(); i++)
		{
			if (isPrime(numVec[findIndex]))
			{
				int eraseNum = numVec[findIndex];
				int count = numVec.size();

				for (int j = eraseNum; j <= N; j += eraseNum)
				{
					auto it = find(numVec.begin(), numVec.end(), j);
					if (it != numVec.end())
					{
						numVec.erase(it);
						k_Count++;
					}

					if (k_Count == K)
					{
						cout << j;
						isEnd = true;
						break;
					}
				}
				findIndex = 0;
			}
			else
			{
				findIndex++;
			}
		}
		if (isEnd)
			break;
	}

	return 0;
}