#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int v[3];
    for (int i = 0; i < 3; i++) cin >> v[i];
    sort(v, v + 3);

    int a = v[0], b = v[1], c = v[2];

    if (b - a == c - b) {
        cout << c + (b - a);
    } else if (b - a < c - b) {
        cout << b + (b - a);
    } else {
        cout << a + (c - b);
    }

    return 0;
}
