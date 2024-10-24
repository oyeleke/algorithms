#include <iostream>
#include <algorithm>
#include <climits>
#include <vector>

using namespace std;

pair<int, int> minDifference1(vector<int> a, vector<int> b)
{
    int minDiff = INT_MAX;
    int pair1, pair2;

    for (int i = 0; i < a.size(); i++)
    {
        int d = a[i];

        for (int j = 0; j < b.size(); j++)
        {
            int absoluteValue = abs(a[i] - b[j]);

            if (absoluteValue < minDiff)
            {
                pair1 = a[i];
                pair2 = b[j];
                minDiff = absoluteValue;
            }
        }
    }

    return {pair1, pair2};
}

pair<int, int> minDifference1(vector<int> a, vector<int> b)
{
    int minDiff = INT_MAX;
    int pair1, pair2;
    sort(a.begin(), a.end());
    int n = a.size();

    for (int i = 0; i < b.size(); i++)
    {
        int d = b[i];

        int j = 0;
        int e = (n - 1);

        while (j < e)
        {
            int k = ((e - j) / 2) + j;

            if (d == a[k])
            {
                pair1 = a[k];
                pair2 = d;
                break;
            }
            else if (abs(a[k] - d) > minDiff)
            {
                e = k - 1;
            }
            else
            {
                minDiff = abs(a[k] - d);
                pair1 = a[k];
                pair2 = d;
            }
        }
    }
}

pair<int, int> minDifference(vector<int> a2, vector<int> a1)
{
    sort(a2.begin(), a2.end());
    vector<int> result;
    // iterate over 1 and do binary search
    int p1, p2;

    int diff = INT_MAX;

    for (int x : a1)
    {
        auto lb = lower_bound(a2.begin(), a2.end(), x) - a2.begin();

        if (lb >= 1 and x - a2[lb - 1] < diff)
        {
            diff = x - a2[lb - 1];
            p2 = a2[lb - 1];
            p1 = x;
        }

        if (lb != a2.size() and a2[lb] - x < diff)
        {
            diff = a2[lb] - x;
            p1 = x;
            p2 = a2[lb];
        }
    }

    return {p1, p2};
}