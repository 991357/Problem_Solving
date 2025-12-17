#include <iostream>
#include <set>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    char type;

    cin >> N >> type;

    set<string> nameSet;

    for(int i = 0; i < N; i++)
    {
        string name;
        cin >> name;

        nameSet.insert(name);
    }

    int ans = 0;
    if(type == 'Y')
        ans = nameSet.size() / 1;
    else if(type == 'F')
        ans = nameSet.size() / 2;
    else
        ans = nameSet.size() / 3;
    
    cout << ans;

    return 0;
}
