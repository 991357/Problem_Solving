#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<pair<int,int>> roomVec;

    for(int i = 0; i < N; i++)
    {
        int f, s;
        cin >> f >> s;
        roomVec.push_back({f, s});
    }
    
    sort(roomVec.begin(), roomVec.end(), [](const pair<int,int>& a, const pair<int,int>& b)
    {
        if(a.second != b.second)
            return a.second < b.second;
        return a.first < b.first;
    });

    int cnt = 0, endTime = 0;

    for(int i = 0; i < roomVec.size(); i++)
    {
        
        if(roomVec[i].first >= endTime) // 회의를 시작할 수 있는 상태
        {
            cnt++;
            endTime = roomVec[i].second;
        }
    }

    cout << cnt;

    return 0;
}   