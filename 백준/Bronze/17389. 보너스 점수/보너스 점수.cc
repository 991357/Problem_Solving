#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	vector<char> problemVec(N);
	for (char& c : problemVec)
		cin >> c;

	int bonus = 0, sum = 0;
	for (int i = 0; i < problemVec.size(); i++)
	{
		if (problemVec[i] == 'X')
			bonus = 0;
		else
		{
			sum += i + 1 + bonus;
			bonus++;
		}
	}

	cout << sum;

	return 0;
}