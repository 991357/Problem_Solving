#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    long long sum = 0;
    long long xorVal = 0;
    
    int Q;
    cin >> Q;
    
    while(Q--)
    {
        int cmd;
        cin >> cmd;
        
        if(cmd == 1)
        {
            long long x;
            cin >> x;
            sum += x;
            xorVal ^= x;
        }
        else if(cmd == 2)
        {
            long long x;
            cin >> x;
            sum -= x;
            xorVal ^= x;
        }
        else if(cmd == 3)
            cout << sum << "\n";
        else if(cmd == 4)
            cout << xorVal << "\n";
    }
    
    return 0;
}