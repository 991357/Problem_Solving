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

	for (int i = 0; i < T; i ++)
	{
		vector<int> numVec(10);

		for (int& n : numVec)
			cin >> n;

		sort(numVec.begin(), numVec.end());
		cout << numVec[7] << "\n";
	}
}