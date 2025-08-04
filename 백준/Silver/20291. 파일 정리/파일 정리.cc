#include <iostream>
#include <map>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	map<string, int> extensionMap;

	for (int i = 0; i < T; i++)
	{
		string value;
		cin >> value;

		bool isStart = false;
		for (int i = 0; i < value.size(); i++)
		{
			if (value[i] != '.' && isStart == false)
				continue;

			if (value[i] == '.')
			{
				isStart = true;
				continue;
			}

			if (isStart)
			{
				string temp = "";
				for (int j = i; j < value.size(); j++)
				{
					temp += value[i];
					i++;
				}

				if (extensionMap.find(temp) != extensionMap.end())
					extensionMap[temp] += 1;
				else
					extensionMap[temp] = 1;
			}
		}
	}

	for (auto& pair : extensionMap) 
		cout << pair.first << " " << pair.second << '\n';
}