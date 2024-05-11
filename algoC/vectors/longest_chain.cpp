#include <unordered_set>
#include <iostream>
#include <vector>
using namespace std;

int longestChain(vector<int> arr)
{
    int n = arr.size();
    int longest = 0;
    unordered_set<int> s;

    for (auto v : arr)
    {
        s.insert(v);
    }

    for (int i = 0; i < n; i++)
    {
        int j = arr[i];
        if (s.find(j - 1) == s.end())
        {
            int count = 0;
            while (s.find(j) != s.end())
            {
                j++;
                count++;
            }
            longest = max(count, longest);
        }
    }

    return longest;
}

int main()
{

    vector<int> arr{9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6};
    cout << longestChain(arr);
    return 0;
}