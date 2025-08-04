#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int a, b, c;

	cin >> a >> b >> c;

	int reward = 0;

	if (a == b && b == c && a == c)
		reward = 10000 + a * 1000;
	else if (a == b || a == c)
		reward = 1000 + a * 100;
	else if (b == c)
		reward = 1000 + c * 100;
	else
	{
		reward = max(max(a, b), c);
		reward *= 100;
	}

	cout << reward;

	return 0;
}