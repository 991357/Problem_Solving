#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N, K;
	cin >> N >> K;

	if (N == 1)
	{
		cout << 1;
	}
	else
	{
		vector<int> primeVec;

		for (int i = 1; i <= sqrt(N); i++)
		{
			if (N % i == 0)
			{
				primeVec.push_back(i);

				if (i != N / i)
					primeVec.push_back(N / i);
			}
		}
		sort(primeVec.begin(), primeVec.end());
		 
		if (primeVec.size() < K)
			cout << 0;
		else
			cout << primeVec[K - 1];
	}

	return 0;
}