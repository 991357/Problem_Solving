#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    priority_queue<int> maxPq;
    priority_queue<int, vector<int>, greater<int>> minPq;

    for (int i = 0; i < N; i++)
    {
        int n;
        cin >> n;

        // 첫 입력이거나 중간값보다 작으면 최대힙
        if (maxPq.empty() || n <= maxPq.top())
            maxPq.push(n);
        else
            minPq.push(n);

        if (maxPq.size() > minPq.size() + 1)
        {
            minPq.push(maxPq.top());
            maxPq.pop();
        }
        else if (minPq.size() > maxPq.size())
        {
            maxPq.push(minPq.top());
            minPq.pop();
        }

        if (!minPq.empty() && (maxPq.top() > minPq.top()))
        {
            int maxTop = maxPq.top();
            int minTop = minPq.top();
            
            maxPq.pop();
            minPq.pop();
            
            maxPq.push(minTop);
            minPq.push(maxTop);
        }

        cout << maxPq.top() << "\n";
    }

    return 0;
}