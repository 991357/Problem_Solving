#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int bfs(int turn, int target, vector<vector<int>> &friendsVec, vector<int> &baconVec, int N)
{
    deque<pair<int, int>> bfsQ;
    vector<bool> visitedVec(N + 1);
    visitedVec[turn] = true;
    bfsQ.push_back({turn, 0});

    while(!bfsQ.empty())
    {
        auto cur = bfsQ.front();
        bfsQ.pop_front();

        if(cur.first == target)
            return cur.second;

        for(int i = 0; i < friendsVec[cur.first].size(); i++)
        {
            if(!visitedVec[friendsVec[cur.first][i]])
            {
                visitedVec[friendsVec[cur.first][i]] = true;
                bfsQ.push_back({friendsVec[cur.first][i], cur.second + 1});
            }
        }
    }

    return 0;
}

int findFriends(vector<vector<int>> &friendsVec, vector<int> &baconVec, int turn, int N)
{
    int sum = 0;
    for(int i = 1; i <= N; i++)
    {
        if(i != turn)
        {
            // turn에서 i까지 몇번만에 도달할 수 있는지?
            int res = bfs(turn, i, friendsVec, baconVec, N);
            //cout << turn << "에서 " << i << "까지 도달하는데 걸리는 값 " << res << "\n";
            sum += res;
        }
    }

    return sum;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, M;
    cin >> N >> M;

    vector<vector<int>> friendsVec(N + 1);

    for(int i = 0; i < M; i++)
    {
        int f, s;
        cin >> f >> s;
        friendsVec[f].push_back(s);
        friendsVec[s].push_back(f);
    }

    vector<pair<int, int>> minNumVec;
    for(int i = 1; i <= N; i++)
    {
        vector<int> baconVec(N + 1);
        baconVec[i] = true;
        int res = findFriends(friendsVec,baconVec, i, N);

        minNumVec.push_back({i, res});
    }

    sort(minNumVec.begin(), minNumVec.end(), [](const pair<int,int>& a, pair<int,int>& b)
    {
        if(a.second != b.second)
            return a.second < b.second;
        return a.first < b.first;
    });

    cout << minNumVec[0].first;
    
    return 0;
}   