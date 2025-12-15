#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, J, H;

    cin >> N >> J >> H;

    vector<int> numVec;
    for(int i = 1; i <= N; i++)
        numVec.push_back(i);

    int curRound = 1;
    bool isEnd = false;
    
    while(true)
    {
        vector<int> tempVec;

        for(int i = 0; i < numVec.size(); i += 2)
        {
            if(i == numVec.size() - 1)
            {
                tempVec.push_back(numVec[i]);
                break;
            }

            // 만약 i랑 i+1이 지민이랑 한수야
            if((numVec[i] == J && numVec[i + 1] == H) || (numVec[i] == H && numVec[i + 1] == J))
            {
                cout << curRound;
                return 0;
            }
            
            if(numVec[i] == J || numVec[i] == H) // 만약 i가 J거나 H임 그럼 얜 무조건 이겨
                tempVec.push_back(numVec[i]);
            else if(numVec[i + 1] == J || numVec[i + 1] == H) // 만약 i + 1이 J거나 H라면 무조건 이겨
                tempVec.push_back(numVec[i + 1]);                
            else // 둘 다 아니라면 아무나 이겨도 됨
                tempVec.push_back(numVec[i]);
        }
        curRound++;

        if(tempVec.size() == 1)
            break;
        else
        {
            numVec.clear();
            numVec = tempVec;
        }
    }

    cout << -1;

    return 0;
}   