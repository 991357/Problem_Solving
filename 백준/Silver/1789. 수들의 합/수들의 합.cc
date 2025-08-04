#include <iostream>
#include <vector>

using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	unsigned long long a;
	cin >> a;

	unsigned long long sum = 0, plusCount = 0;

	while (true)
	{
		sum += plusCount;

		if (sum > a)
		{
			plusCount--;
			break;
		}

		plusCount++;
	}
	cout << plusCount;
}