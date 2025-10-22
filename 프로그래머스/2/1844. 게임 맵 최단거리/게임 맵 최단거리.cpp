#include<vector>
#include<queue>

using namespace std;

struct Node
{
    int y, x, dist;
};

int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};

int bfs(vector<vector<int>> maps)
{
    queue<Node> bfsQ;
    int n = maps.size();
    int m = maps[0].size();
    vector<vector<bool>> checkVec;
    checkVec.assign(n, vector<bool>(m));
    
    checkVec[0][0] = true;
    bfsQ.push({0, 0, 1});
    
    int min = 123456789;
    
    while(!bfsQ.empty())  
    {
        Node cur = bfsQ.front();
        bfsQ.pop();
        
        if(cur.y == n-1 && cur.x == m-1)
        {
            return cur.dist;
        }
        
        for(int i = 0; i < 4; i++)
        {
            int ny = cur.y + dy[i];
            int nx = cur.x + dx[i];
            
            if(nx >= 0 && ny >= 0 && nx < m && ny < n && !checkVec[ny][nx] && maps[ny][nx] != 0)
            {
                checkVec[ny][nx] = true;
                bfsQ.push({ny, nx, cur.dist + 1});
            }
        }
    }
    
    return -1;
}

int solution(vector<vector<int> > maps)
{
    int answer = bfs(maps);
    
    return answer;
}