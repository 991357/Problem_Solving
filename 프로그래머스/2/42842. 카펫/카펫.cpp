#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) 
{
    int total = brown + yellow;

    for (int i = 3; i <= total / i; i++) 
    {
        if (total % i != 0) 
            continue;
        
        int width = total / i;

        if ((width - 2) * (i - 2) == yellow)
            return {width, i};
    }
    
    return {};
}