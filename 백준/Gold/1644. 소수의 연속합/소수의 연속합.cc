#include <iostream>
#include <vector>
#include <string>
#include <cmath>

using namespace std;

vector<int> primeVec;

bool isPrime(int n)
{
	for (int i = 2; i <= sqrt(n); i++)
	{
		if (n % i == 0)
			return false;
	}
	return true;
}

void getPrime(int n)
{
	for (int i = 2; i <= n; i++)
	{
		if (isPrime(i))
			primeVec.push_back(i);
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	if (N == 1)
	{
		cout << 0;
		return 0;
	}

	int cnt = 0;

	getPrime(N);

	int start = 0, end = 1;

	while (start < end)
	{
		int sum = 0;

		for (int i = start; i < end; i++)
			sum += primeVec[i];

		if (sum == N)
		{
			cnt++;
			start++;
		}
		else if (sum > N)
			start++;
		else
			end++;

		if (end == primeVec.size() + 1)
			break;
	}

	cout << cnt;

	return 0;
}