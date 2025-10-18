#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        int a, b, c;
        cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0) break;

        int arr[3] = {a, b, c};
        sort(arr, arr + 3);

        if (arr[0] + arr[1] <= arr[2]) {
            cout << "Invalid\n";
        } else if (arr[0] == arr[1] && arr[1] == arr[2]) {
            cout << "Equilateral\n";
        } else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
            cout << "Isosceles\n";
        } else {
            cout << "Scalene\n";
        }
    }
    return 0;
}
