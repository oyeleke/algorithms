#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int maximumSubArray(vector<int> array)
{
    int n = array.size();
    int i = 0;
    int largest = 0;
    while (array[i] <= 0)
    {
        i++;
    }

    int temp_additions = 0;
    for (int j = i; j < n; j++)
    {
        temp_additions += array[j];
        if (temp_additions < 0)
        {
            temp_additions = 0;
        }
        largest = max(largest, temp_additions);
    }

    return largest;
}

int main()
{
    vector<int> a = {-1, 2, 3, 4, -2, 6, -8, 3};
    cout << maximumSubArray(a);

    return 0;
}