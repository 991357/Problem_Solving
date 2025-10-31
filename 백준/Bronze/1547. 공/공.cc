#include <iostream>
using namespace std;

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int M;
    cin >> M;

    int ball = 1;

    for (int i = 0; i < M; i++) 
    {
        int X, Y;
        cin >> X >> Y;

        if (ball == X) 
            ball = Y;
        else if (ball == Y)
            ball = X;
    }

    cout << ball << "\n";
    
    return 0;
}
