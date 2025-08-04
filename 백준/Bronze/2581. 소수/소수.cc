#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

bool isPrime(int num)
{
	if (num < 2)
		return false;

	int count = 0;
	for (int i = 1; i <= num; i++)
	{
		if (num % i == 0)
			count++;
	}

	if (count == 2)
		return true;
	else
		return false;
}

int main()
{
	int M, N;
	cin >> M >> N;

	int sum = 0, min = 0;

	for (int i = M; i <= N; i++)
	{
		if (isPrime(i))
		{
			sum += i;

			if (min == 0)
				min = i;
		}
	}

	if (sum == 0)
		cout << -1;
	else
	{
		cout << sum << "\n" << min;
	}


	return 0;
}