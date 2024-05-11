#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> threesum(vector<int> arr, int sum)
{

    sort(arr.begin(), arr.end());
    int n = arr.size();
    vector<vector<int>> result;

    for (int i = 0; i <= n - 3; i++)
    {
        int j = i + 1;
        int k = n - 1;

        while (j < k)
        {
            int current_sum = arr[i] + arr[j] + arr[k];

            if (current_sum == sum)
            {
                result.push_back({arr[i], arr[j], arr[k]});
                j++;
                k--;
            }
            else if (current_sum > sum)
            {
                k--;
            }
            else
            {
                j++;
            }
        }
    }

    return result;
}

int main()
{

    std::vector<int> arr{1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
    int S = 18;
    auto results = threesum(arr, S);

    cout << "s"
         << results.size() << endl;
    for (auto v : results)
    {
        for (auto s : v)
        {
            cout << s << ",";
        }
        cout << endl;
    }

    return 0;
}