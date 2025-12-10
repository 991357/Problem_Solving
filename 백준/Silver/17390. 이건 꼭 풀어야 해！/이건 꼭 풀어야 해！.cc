#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, Q;
    cin >> N >> Q;

    vector<int> numVec(N);
    for (int i = 0; i < N; i++)
        cin >> numVec[i];

    sort(numVec.begin(), numVec.end());

    vector<long long> prefixSum(N + 1, 0);

    for (int i = 0; i < N; i++)
        prefixSum[i + 1] = prefixSum[i] + numVec[i];

    for (int i = 0; i < Q; i++)
    {
        int start, end;
        cin >> start >> end;

        cout << prefixSum[end] - prefixSum[start - 1] << "\n";
    }
}