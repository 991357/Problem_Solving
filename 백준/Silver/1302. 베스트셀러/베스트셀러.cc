#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    map<string, int> bookMap;
    for (int i = 0; i < N; i++)
    {
        string book = "";
        cin >> book;
        bookMap[book]++;
    }

    // 가장 많이 팔린 책 찾기
    int max = 0;
    for (auto& book : bookMap)
    {
        if (book.second > max)
            max = book.second;
    }

    // 가장 많이 팔린 책 집어 넣기
    vector<string> bookVec;
    for (auto& book : bookMap)
    {
        if (book.second == max)
            bookVec.push_back(book.first);
    }

    sort(bookVec.begin(), bookVec.end());

    cout << bookVec[0];

    return 0;
}