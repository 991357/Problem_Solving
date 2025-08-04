#include <iostream>
#include <stack>

using namespace std;

int main()
{
	int T;
	cin >> T;

	int count = 0;

	for (int i = 0; i < T; i++)
	{
		string value;
		cin >> value;

		stack<char> tempStack;

		for (int i = 0; i < value.size(); i++)
		{
			if (tempStack.size() == 0)
				tempStack.push(value[i]);
			else
			{
				if (value[i] != tempStack.top())
					tempStack.push(value[i]);
				else
					tempStack.pop();
			}
		}

		if (tempStack.size() == 0)
			count++;
	}

	cout << count;
}