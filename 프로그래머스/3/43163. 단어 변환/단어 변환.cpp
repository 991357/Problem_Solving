#include <string>
#include <vector>
#include <queue>
using namespace std;

void bfs(string begin, string target, vector<string> &words, int &answer)
{
    queue<pair<string, int>> bfsQ;
    vector<bool> visited(words.size(), false);
    bfsQ.push({begin, 0});

    while (!bfsQ.empty())
    {
        auto cur = bfsQ.front();
        
        bfsQ.pop();

        string beg = cur.first;
        int cost = cur.second;

        if (beg == target) 
        {
            answer = cost;
            return;
        }

        for (int i = 0; i < words.size(); i++)
        {
            if (visited[i])
                continue;

            int cnt = 0;
            
            for (int j = 0; j < beg.size(); j++)
            {
                if (beg[j] != words[i][j])
                    cnt++;
            }
                
            if (cnt == 1)
            {
                visited[i] = true;
                bfsQ.push({words[i], cost + 1});
            }
        }
    }
}

int solution(string begin, string target, vector<string> words)
{
    int answer = 0;
    
    bfs(begin, target, words, answer);
    
    return answer;
}
