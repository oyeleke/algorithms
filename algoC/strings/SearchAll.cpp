#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> stringSearch(string big, string small)
{
    // store the occurrences in the result vector
    int index = 0;
    vector<int> result = {};

    while (index > -1)
    {
        index = big.find(small, index);
        if (index > -1)
        {
            result.push_back(index);
            index++;
        }
    }
    return result;
}

int main(int argc, char const *argv[])
{
    string big = "I liked the movie, acting in movie was great!";
    string small = "movie";
    vector<int> result = stringSearch(big, small);
    for (int s : result)
    {
        cout << s << endl;
    }

    return 0;
}
