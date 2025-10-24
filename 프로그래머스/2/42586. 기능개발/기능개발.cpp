#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds)
{
    vector<int> answer;
    int n = progresses.size();
    int lastDistributeIdx = 0;
    
    while(lastDistributeIdx < n)
    {
        // 한 단계 전진
        for(int i = 0; i < n; i++)
        {
            if(progresses[i] < 100)
                progresses[i] += speeds[i];
        }
        
        // 배포 가능한 작업 개수 세기
        int cnt = 0;
        for(int i = lastDistributeIdx; i < n; i++)
        {
            if(progresses[i] >= 100)
            {
                cnt++;
                lastDistributeIdx++;
            }
            else
                break;
        }
        
        if(cnt > 0)
            answer.push_back(cnt);
    }
    
    return answer;
}