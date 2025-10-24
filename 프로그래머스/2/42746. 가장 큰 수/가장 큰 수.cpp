#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> numbers) 
{
    string answer = "";
    
    vector<string> numVec;
    for(int i = 0; i < numbers.size(); i++)
        numVec.push_back(to_string(numbers[i]));
    
    sort(numVec.begin(), numVec.end(), [](const string& a, const string& b){return a+b > b+a;});
    
    if(numVec[0] == "0")
        return "0";
    
    for(string& p : numVec)
        answer += p;

    return answer;
}