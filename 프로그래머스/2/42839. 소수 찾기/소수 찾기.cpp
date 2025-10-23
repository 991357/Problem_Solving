#include <string>
#include <vector>
#include <set>
using namespace std;

int answer;
set<int> numSet;

bool IsPrime(int num)
{
    if (num < 2)
        return false;
    
    for (int i = 2; i * i <= num; i++)
    {
        if (num % i == 0)
            return false;
    }
    
    return true;
}

void Permutation(string number, string cur, vector<bool> &visited)
{
    if (!cur.empty())
    {
        int num = stoi(cur);
        numSet.insert(num);
    }

    for (int i = 0; i < number.size(); i++)
    {
        if (!visited[i])
        {
            visited[i] = true;
            Permutation(number, cur + number[i], visited);
            visited[i] = false;
        }
    }
}

int solution(string numbers) 
{
    answer = 0;
    numSet.clear();

    vector<bool> visited(numbers.size(), false);
    
    Permutation(numbers, "", visited);

    for (int num : numSet)
    {
        if (IsPrime(num))
            answer++;
    }

    return answer;
}
