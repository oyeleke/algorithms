#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

vector<int> pairSum(vector<int> arr, int S)
{
    unordered_set<int> s;
    vector<int> result;
    for (int i : arr)
    {
        int x = S - i;
        if (s.find(x) != s.end())
        {
            result.push_back(i);
            result.push_back(x);
            return result;
        }
        s.insert(i);
    }
    return result;
}

int main()
{

    std::vector<int> arr{10, 5, 2, 3, -6, 9, 11};
    int S = 4;
    auto p = pairSum(arr, S);

    if (p.size() == 0)
    {
        cout << "No such pair" << endl;
    }
    else
    {
        cout << p[0] << "," << p[1] << endl;
    }

    return 0;
}