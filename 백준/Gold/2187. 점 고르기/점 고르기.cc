#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

struct Point 
{
    int r, c, s;
};

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, A, B;
    cin >> N >> A >> B;

    vector<Point> pts(N);
    for (int i = 0; i < N; i++)
        cin >> pts[i].r >> pts[i].c >> pts[i].s;

    // 행으로 정렬
    sort(pts.begin(), pts.end(), [](const Point& a, const Point& b) {return a.r < b.r;});

    int ans = 0;

    // 행
    for (int i = 0; i < N; i++) 
    {
        vector<Point> cand;
        for (int j = i; j < N; j++) 
        {
            if (pts[j].r - pts[i].r > A - 1) 
                break;

            cand.push_back(pts[j]);
        }

        // 열로 정렬
        sort(cand.begin(), cand.end(), [](const Point& a, const Point& b) {return a.c < b.c;});

        // 열
        int L = 0;
        int size = cand.size();
        for (int R = 0; R < size; R++) 
        {
            while (cand[R].c - cand[L].c > B - 1)
                L++;

            int maxS = 0;
            int minS = INT_MAX;

            for (int k = L; k <= R; k++) 
            {
                maxS = max(maxS, cand[k].s);
                minS = min(minS, cand[k].s);
            }

            ans = max(ans, maxS - minS);
        }
    }

    cout << ans;

    return 0;
}
