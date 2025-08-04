#include <iostream>
#include <vector>
#include <string>
#include <iomanip>

using namespace std;

int toSeconds(string time) {
    int min = stoi(time.substr(0, 2));
    int sec = stoi(time.substr(3, 2));
    return min * 60 + sec;
}

string toMMSS(int totalSec) {
    int min = totalSec / 60;
    int sec = totalSec % 60;
    string minStr = (min < 10 ? "0" : "") + to_string(min);
    string secStr = (sec < 10 ? "0" : "") + to_string(sec);
    return minStr + ":" + secStr;
}

int main() 
{
    int N;
    cin >> N;

    vector<pair<int, int>> goals; // (team, time in sec)

    for (int i = 0; i < N; i++)
    {
        int team;
        string time;
        cin >> team >> time;
        goals.push_back({ team, toSeconds(time) });
    }

    int score1 = 0, score2 = 0;
    int leadTime1 = 0, leadTime2 = 0;
    int lastTime = 0;

    for (auto& g : goals) 
    {
        int team = g.first;
        int curTime = g.second;

        // 누가 이기고 있었는가?
        if (score1 > score2) 
            leadTime1 += (curTime - lastTime);
        else if (score2 > score1) 
            leadTime2 += (curTime - lastTime);

        // 점수 갱신
        if (team == 1) score1++;
        else score2++;

        lastTime = curTime;
    }

    // 마지막 득점 이후부터 경기 종료(48:00)까지 처리
    if (score1 > score2)
        leadTime1 += (48 * 60 - lastTime);
    else if (score2 > score1)
        leadTime2 += (48 * 60 - lastTime);

    cout << toMMSS(leadTime1) << endl;
    cout << toMMSS(leadTime2) << endl;

    return 0;
}
