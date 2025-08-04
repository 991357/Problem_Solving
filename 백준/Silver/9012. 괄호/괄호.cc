#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	for (int test_case = 0; test_case < T; test_case++)
	{
		string value;
		cin >> value;

		int needRight = 0;

		for (int i = 0; i < value.size(); i++)
		{
			if (value[i] == '(')
			{
				needRight++;
			}
			else
				needRight--;

			if (needRight < 0)
				break;
		}

		if (needRight == 0)
			cout << "YES\n";
		else
			cout << "NO\n";
	}

	return 0;
}