#include <string>
#include <vector>

using namespace std;

void dfs(vector<int> &numbers, int target, int &answer, int idx, int res)
{
    if(idx == numbers.size())
    {
        if(res == target)
            answer++;
        return;
    }

    dfs(numbers, target, answer, idx + 1, res + numbers[idx]);
    dfs(numbers, target, answer, idx + 1, res - numbers[idx]);
}

int solution(vector<int> numbers, int target) 
{
    int answer = 0;
    
    dfs(numbers, target, answer, 0, 0);
    
    return answer;
}