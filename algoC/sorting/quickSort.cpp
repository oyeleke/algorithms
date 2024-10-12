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

void quickSort(vector<int> &arr, int s, int e)
{
    if (s >= e)
    {
        return;
    }

    int p = partition(arr, s, e);
    cout << p << endl;
    quickSort(arr, s, p - 1);
    quickSort(arr, p + 1, e);
}

int main()
{
    vector<int> arr = {10, 5, 2, 0, 7, 6, 4}; // {2, 0,} i = -1
    int n = arr.size();
    quickSort(arr, 0, n - 1);
    for (int x : arr)
    {
        cout << x << ",";
    }
}