#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> parentVec;

struct Edge
{
    int x, y, w;

    bool operator<(const Edge& other) const { return w < other.w; };
};

int find(int a)
{
    if (a == parentVec[a]) return a;
    return parentVec[a] = find(parentVec[a]);
}

void unionSet(int a, int b)
{
    int aRoot = find(a);
    int bRoot = find(b);

    parentVec[bRoot] = aRoot;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int V, E;
    cin >> V >> E;

    vector<Edge> edgeVec;

    parentVec.assign(V+1, 0); 
    for (int i = 1; i <= V; i++)
        parentVec[i] = i;


    for (int i = 0; i < E; i++)
    {
        int A, B, C;
        cin >> A >> B >> C;

        edgeVec.push_back({ A, B, C });
    }

    // 간선 정렬
    sort(edgeVec.begin(), edgeVec.end());

    // mst
    int cnt = 0, sum = 0;

    for (int i = 0; i < E; i++)
    {
        if (find(edgeVec[i].x) != find(edgeVec[i].y))
        {
            unionSet(edgeVec[i].x, edgeVec[i].y);
            cnt++;
            sum += edgeVec[i].w;

            if (cnt == V - 1)
                break;
        }
    }

    cout << sum;
    return 0;
}