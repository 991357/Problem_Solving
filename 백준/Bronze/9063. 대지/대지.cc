#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    int minX = 10001, maxX = -10001;
    int minY = 10001, maxY = -10001;

    for (int i = 0; i < N; i++) {
        int x, y;
        cin >> x >> y;
        minX = min(minX, x);
        maxX = max(maxX, x);
        minY = min(minY, y);
        maxY = max(maxY, y);
    }

    int area = (maxX - minX) * (maxY - minY);
    cout << area << "\n";

    return 0;
}
