#include <iostream>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;
    list<int> numList;

    for (int i = 1; i <= N; i++)
        numList.push_back(i);
    
    vector<int> answer;
    while (!numList.empty())
    {
        // K번
        for (int i = 0; i < K-1; i++)
        {
            int num = numList.front();
            numList.pop_front();

            numList.push_back(num);
        }

        // 제일 앞에꺼 빼기
        answer.push_back(numList.front());
        numList.pop_front();
    }

    cout << "<";
    for (int i = 0; i < answer.size(); i++)
    {
        if (i != answer.size() - 1)
            cout << answer[i] << ", ";
        else
            cout << answer[i];
    }
    cout << ">";

    return 0;
}