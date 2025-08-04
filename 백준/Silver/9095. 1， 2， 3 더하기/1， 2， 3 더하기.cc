#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	int dp[12] = { 0,1,2,4 };

	for (int i = 4; i < 12; i++)
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

	for (int test_case = 0; test_case < T; test_case++)
	{
		int value;
		cin >> value;

		cout << dp[value] << "\n";
	}
	return 0;
}