#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> answer;
vector<bool> checkVec;

bool dfs(string cur, vector<vector<string>> tickets, int useCnt)
{
    answer.push_back(cur);    
    
    if(useCnt == tickets.size())
        return true;
    
    vector<pair<string, int>> tempVec;
    for(int i = 0; i < tickets.size(); i++)
    {
        if(tickets[i][0] == cur && !checkVec[i])
            tempVec.push_back({tickets[i][1], i});
    }
    
    sort(tempVec.begin(), tempVec.end());
    
    for(auto &p : tempVec)
    {
        checkVec[p.second] = true;
        
        if(dfs(p.first, tickets, useCnt + 1))
            return true;
        
        checkVec[p.second] = false;
    }
    
    answer.pop_back();
    return false;
}

vector<string> solution(vector<vector<string>> tickets) 
{
    checkVec.resize(tickets.size(), false);
    answer.clear();
    
    dfs("ICN", tickets, 0);
    
    return answer;
}