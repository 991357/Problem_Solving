#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;

	vector<int> numVec(N);
	for (int& n : numVec)
		cin >> n;

	vector<int> prefix(N + 1);
	prefix[0] = 0;
	for (int i = 1; i <= N; i++)
		prefix[i] = prefix[i - 1] + numVec[i - 1];

	int sum = 0;
	for (int i = 0; i < M; i++)
	{
		int start, end;
		cin >> start >> end;

		cout << prefix[end] - prefix[start - 1] << "\n";
	}
}