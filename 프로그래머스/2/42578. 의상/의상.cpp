#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) 
{
    map<string, int> clothsMap;
    
    for (int i = 0; i < clothes.size(); i++) 
    {
        string category = clothes[i][1];
        clothsMap[category]++;
    }
        
    int answer = 1;
    
    for (auto& it : clothsMap) 
        answer *= (it.second + 1);
    
    return answer - 1;
}