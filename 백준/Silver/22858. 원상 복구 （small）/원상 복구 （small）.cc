#include <iostream>
#include <vector>

using namespace std;

int main() 
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int N, K;

	cin >> N >> K;

	vector<int> SVec;
	for (int i = 0; i < N; i++)
	{
		int num = 0;
		cin >> num;
		SVec.push_back(num - 1);
	}
	
	vector<int> DVec;
	for (int i = 0; i < N; i++)
	{
		int num = 0;
		cin >> num;
		DVec.push_back(num - 1);
	}

	vector<int> answerVec;

	for (int i = 0; i < K; i++)
	{
		answerVec.clear();
		answerVec.resize(N);

		for (int j = 0; j < N; j++)
			answerVec[DVec[j]] = SVec[j];

		SVec = answerVec;
	}

	for (int i = 0; i < answerVec.size(); i++)
		cout << answerVec[i] + 1 << " ";

	return 0;
}