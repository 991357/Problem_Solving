#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int E, S, M;
	cin >> E >> S >> M;

	int e_temp = 0, s_temp = 0, m_temp = 0, yearCount = 1;

	while (true)
	{
		e_temp++;
		s_temp++;
		m_temp++;

		if (e_temp > 15)
			e_temp = 1;
		if (s_temp > 28)
			s_temp = 1;
		if (m_temp > 19)
			m_temp = 1;

		if (e_temp == E && s_temp == S && m_temp == M)
			break;

		yearCount++;
	}

	cout << yearCount;

	return 0;
}