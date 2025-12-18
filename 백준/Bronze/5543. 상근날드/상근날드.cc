#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> burgerVec;
    vector<int> drinkVec;

    for(int i = 0; i < 3; i++)
    {
        int n;
        cin >> n;
        burgerVec.push_back(n);
    }
    
    for(int i = 0; i < 2; i++)
    {
        int n;
        cin >> n;
        drinkVec.push_back(n);
    }

    sort(burgerVec.begin(), burgerVec.end());
    sort(drinkVec.begin(), drinkVec.end());

    cout << (burgerVec.front() + drinkVec.front()) - 50;

    return 0;
}

