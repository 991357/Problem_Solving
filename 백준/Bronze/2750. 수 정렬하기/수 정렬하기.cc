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
	vector<int> numVec(N);
	for (int& n : numVec)
		cin >> n;

	sort(numVec.begin(), numVec.end());

	for (int n : numVec)
		cout << n << "\n";

	return 0;
}