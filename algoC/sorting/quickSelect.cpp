#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int> &arr, int i, int k)
{
    int temp = arr[k];
    arr[k] = arr[i];
    arr[i] = temp;
}

int partition(vector<int> &arr, int s, int e)
{

    int i = s - 1;

    for (int j = s; j < e; j++)
    {
        if (arr[j] < arr[e])
        {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, e);
    return i + 1;
}

int quickSelect(vector<int> &arr, int s, int e, int k)
{

    int p = partition(arr, s, e);
    int ans = p + 1;
    if (p == k)
    {
        return arr[p];
    }
    else if (k > p)
    {
        return quickSelect(arr, ans, e, k);
    }
    else
    {
        return quickSelect(arr, s, p - 1, k);
    }
}

int main()
{
    vector<int> arr = {10, 5, 2, 0, 7, 6, 4};
    int n = arr.size();

    cout << quickSelect(arr, 0, n - 1, 1) << ",";
}