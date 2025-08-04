#include <iostream>
#include <set>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    set<string> unheard;
    set<string> result;

    for (int i = 0; i < N; ++i) 
    {
        string name;
        cin >> name;
        unheard.insert(name);
    }

    for (int i = 0; i < M; ++i) 
    {
        string name;
        cin >> name;
        if (unheard.find(name) != unheard.end()) 
            result.insert(name); 
    }

    cout << result.size() << '\n';
    for (const string& name : result)
        cout << name << '\n'; 

    return 0;
}
