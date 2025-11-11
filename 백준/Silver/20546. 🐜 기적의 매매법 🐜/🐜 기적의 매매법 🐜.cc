#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int cash;
	cin >> cash;

	vector<int> dateVec;

	for (int i = 0; i < 14; i++)
	{
		int value;
		cin >> value;
		dateVec.push_back(value);
	}

	int jCash = cash, sCash = cash;
	int jStock = 0, sStock = 0;

	int sPlusCount = 0, sMinusCount = 0;

	for (int i = 0; i < dateVec.size(); i++)
	{
		// 준현이 ~
		int jTemp = 0;
		if (jCash / dateVec[i] > 0)
		{
			jTemp = jCash / dateVec[i];
			jStock += jTemp;
			jCash -= dateVec[i] * jTemp;
		}

		// 성민이~
		if (i != 0)
		{
			if (dateVec[i - 1] < dateVec[i])
			{
				sMinusCount = 0;
				sPlusCount++;
			}
			else
			{
				sPlusCount = 0;
				sMinusCount++;
			}
		}

		if (sPlusCount == 3)
		{
			sPlusCount = 0;
			// 전량 매도
			if (sStock != 0)
			{
				sCash += dateVec[i] * sStock;
				sStock = 0;
			}
		}
		else if (sMinusCount == 3)
		{
			sMinusCount = 0;
			// 전량 매수
			int sTemp = 0;

			sTemp = sCash / dateVec[i];
			sStock += sTemp;
			sCash -= dateVec[i] * sTemp;
		}
	}

	int J = jCash + dateVec[dateVec.size() - 1] * jStock;
	int S = sCash + dateVec[dateVec.size() - 1] * sStock;

	if (J > S)
		cout << "BNP";
	else if (S > J)
		cout << "TIMING";
	else
		cout << "SAMESAME";

	return 0;
}