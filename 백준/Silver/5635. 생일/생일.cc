#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Person
{
    string name;
    int day;
    int month;
    int year;
};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<Person> personVec;
    for(int i = 0; i < N; i++)
    {
        string name;
        int day, month, year;

        cin >> name >> day >> month >> year;
        personVec.push_back({name, day, month, year});
    }

    sort(personVec.begin(), personVec.end(), [](const Person& a, const Person& b)
    {
        if(a.year != b.year)
            return a.year > b.year;
        else if(a.month != b.month)
            return a.month > b.month;
        return a.day > b.day;
    });

    cout << personVec[0].name << "\n" << personVec[N - 1].name;

    return 0;
}   