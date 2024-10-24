#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

string merge(string s, string e)
{
    string val;
    if (s + e > e + s)
    {
        val = s + e;
    }
    else
    {
        val = e + s;
    }
    return val;
}

// string smallestString(vector<string> array, int s, int e)
// {
//     int mid = ((e - s) / 2 + s);

//     if (s >= e)
//     {
//         return array[s];
//     }
//     string a = smallestString(array, s, mid);
//     string b = smallestString(array, mid + 1, e);
//     return merge(a, b);
// }

bool compare(string x, string y)
{
    return x + y < y + x;
}

int main()
{
    vector<string> arrn = {"a", "ab", "aba"};
    string arr[] = {"a", "ab", "aba"};
    int n = 3;
    // sort(arr, arr+n compare);
    sort(arr, arr + n, compare);
    // cout << smallestString(arrn, 0, arrn.size() - 1);

    for (string c : arr)
    {
        cout << c;
    }

    return 0;
}