#include <iostream>
#include <vector>
using namespace std;

int main() 
{
    int N;
    cin >> N;

    while (N--) 
    {
        int M;
        cin >> M;
        vector<int> bolt(M);
        for (int i = 0; i < M; ++i) cin >> bolt[i];

        int cycles = 0;

        while (true) 
        {
            bool all_zero = true;
            for (int a : bolt) {
                if (a != 0) {
                    all_zero = false;
                    break;
                }
            }

            if (all_zero) 
            {
                for (int i = 0; i < cycles; ++i) 
                    cout << 'z';
                cout << "ap!\n";
                break;
            }

            if (bolt.size() == 1) 
            {
                if (bolt[0] > 0) 
                    cout << "*fizzle*\n";
                else 
                    cout << "*bunny*\n";
                break;
            }

            vector<int> next;
            for (size_t i = 1; i < bolt.size(); ++i) 
                next.push_back(bolt[i] - bolt[i - 1]);

            bolt = next;
            ++cycles;
        }
    }

    return 0;
}
