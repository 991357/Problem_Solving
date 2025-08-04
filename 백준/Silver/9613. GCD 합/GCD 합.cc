#include <iostream>
#include <vector>

using namespace std;

int gcd(int a, int b)
{
	while (b != 0)
	{
		int temp = a % b;
		a = b;
		b = temp;
	}
	return a;
}

int main()
{
	int T;
	cin >> T;

	for (int i = 0; i < T; i++)
	{
		vector<int> numVec;
		int count;
		cin >> count;

		for (int i = 0; i < count; i++)
		{
			int value;
			cin >> value;

			numVec.push_back(value);
		}

		long long sum = 0;
		for (int i = 0; i < count; i++)
		{
			for (int j = i + 1; j < count; j++)
				sum += gcd(numVec[i], numVec[j]);
		}

		cout << sum << endl;
	}

	return 0;
}