#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    int beforeNumber = -1;
    int idx = 0;
    
    for(int i = 0; i < arr.size(); i++)
    {
        if(arr[i] != beforeNumber)
        {
            answer.push_back(arr[i]);
            beforeNumber = arr[i];
        }
    }
    
    return answer;
}