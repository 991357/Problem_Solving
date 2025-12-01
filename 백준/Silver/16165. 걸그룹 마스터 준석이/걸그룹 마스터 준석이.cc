#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

int N, M;

int main()
{
	cin >> N >> M;

	map<string, string> memberToGroup;
	map<string, vector<string>> groupToMembers;

	for (int i = 0; i < N; i++)
	{
		string groupName;
		cin >> groupName;
		int cnt;
		cin >> cnt;

		for (int j = 0; j < cnt; j++)
		{
			string memberName;
			cin >> memberName;

			memberToGroup[memberName] = groupName;
			groupToMembers[groupName].push_back(memberName); 
		}
	}

	// 문제
	for (int i = 0; i < M; i++)
	{
		string fName;
		cin >> fName;
		int type;
		cin >> type;

		if (type == 0)
		{
			if (groupToMembers.find(fName) != groupToMembers.end())
			{
				vector<string>& members = groupToMembers[fName];
				sort(members.begin(), members.end()); 

				for (const string& member : members)
				{
					cout << member << "\n";
				}
			}
		}
		else
		{
			auto it = memberToGroup.find(fName);

			if (it != memberToGroup.end())
				cout << it->second << "\n";
		}
	}

	return 0;
}