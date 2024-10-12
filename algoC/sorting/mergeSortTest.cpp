#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

void mergeee(vector<int> &array, int s, int e)
{
    int i = s;
    int m = ((e - s) / 2 + s);
    int j = m + 1;
    vector<int> temp;

    while (i <= m and j <= e)
    {
        if (array[i] < array[j])
        {
            temp.push_back(array[i]);
            i++;
        }
        else
        {
            temp.push_back(array[j]);
            j++;
        }
    }

    while (i <= m)
    {
        temp.push_back(array[i++]);
    }

    while (j <= e)
    {
        temp.push_back(array[j++]);
    }
    int k = 0;
    for (int idx = s; idx <= e; idx++)
    {
        array[idx] = temp[k];
        k++;
    }

    for (int x : array)
    {
        cout << x << ",";
    }
    cout << endl;
    cout << s << " : " << e << endl;
    return;
}

void mergeeSort(vector<int> &array, int s, int e)
{
    int mid = ((e - s) / 2 + s);
    cout << s << " : " << mid << " : " << e << endl;

    if (s >= e)
    {
        return;
    }
    mergeeSort(array, s, mid);
    mergeeSort(array, mid + 1, e);
    return mergeee(array, s, e);
}

int main()
{

    vector<int> arr = {10, 5, 2, 0, 7, 6, 4};
    int s = 0;
    int e = arr.size() - 1;

    mergeeSort(arr, s, e);
    for (int x : arr)
    {
        cout << x << ",";
    }
}
