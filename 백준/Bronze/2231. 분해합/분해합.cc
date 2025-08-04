#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	int num = 1;

	bool isFind = true;

	while (true)
	{
		string temp;
		temp = to_string(num);

		int sum = num;
		for (int i = 0; i < temp.size(); i++)
			sum += (int)(temp[i] - '0');

		if (sum == N)
			break;

		if (num == N)
		{
			isFind = false;
			break;
		}

		num++;
	}

	if (isFind)
		cout << num;
	else
		cout << 0;


	return 0;
}