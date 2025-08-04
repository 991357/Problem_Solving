#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;

	vector<int> cardVec(N);
	
	for (int& n : cardVec)
		cin >> n;

	int blackJackNumber = 0;

	for (int i = 0; i < cardVec.size(); i++)
	{
		for (int j = i + 1; j < cardVec.size(); j++)
		{
			for (int k = j + 1; k < cardVec.size(); k++)
			{
				int temp = cardVec[i] + cardVec[j] + cardVec[k];

				if (temp > blackJackNumber && temp <= M)
					blackJackNumber = temp;
			}
		}
	}

	cout << blackJackNumber;

	return 0;
}