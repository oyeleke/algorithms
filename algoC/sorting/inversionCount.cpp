#include <iostream>
#include <vector>

using namespace std;

int inversionCountTemp(vector<int> sample)
{
    int count = 0;
    int j = 0;
    int e = sample.size() - 1;

    while (j < e)
    {
        int k = j + 1;
        while (k <= e)
        {
            if (sample[j] > sample[k])
            {
                cout << sample[j] << " : " << sample[k] << endl;
                cout << j << " : " << k << endl;

                count++;
            }
            k++;
        }
        j++;
    }

    return count;
}

int merge(vector<int> &array, int s, int e)
{
    int i = s;
    int m = ((e - s) / 2 + s);
    int j = m + 1;
    vector<int> temp;
    int count = 0;

    while (i <= m and j <= e)
    {
        if (array[i] < array[j])
        {
            temp.push_back(array[i]);
            i++;
        }
        else
        {
            count += (m - i + 1);
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
    return count;
}

int inversion_count(vector<int> &array, int s, int e)
{
    if (s >= e)
    {
        return 0;
    }
    int mid = ((e - s) / 2 + s);
    int c1 = inversion_count(array, s, mid);
    int c2 = inversion_count(array, mid + 1, e);
    int c3 = merge(array, s, e);
    return c1 + c2 + c3;
}

int main()
{

    vector<int> arr = {0, 5, 2, 3, 1};
    int count = inversion_count(arr, 0, arr.size() - 1);
    cout << count << endl;
}