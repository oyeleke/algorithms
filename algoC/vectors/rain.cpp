#include <iostream>
#include <vector>
using namespace std;

int trappedWater(vector<int> heights)
{
    int water = 0;
    int n = heights.size();

    vector<int> left(n, 0);
    vector<int> right(n, 0);
    if (n <= 2)
    {
        return 0;
    }
    left[0] = heights[0];
    right[n - 1] = heights[n - 1];

    for (int i = 1; i < n; i++)
    {
        left[i] = (max(heights[i], left[i - 1]));
        right[n - i - 1] = max(heights[n - i - 1], right[n - i]);
    }

    for (int i = 0; i < n; i++)
    {
        water += min(right[i], left[i]) - heights[i];
    }

    return water;
}

int main()
{
    vector<int> water = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    cout << trappedWater(water) << endl;

    return 0;
}