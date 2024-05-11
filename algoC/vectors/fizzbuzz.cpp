#include <vector>
#include <string>
#include <iostream>
using namespace std;

// Complete this method, don't write main
vector<string> fizzbuzz(int n)
{
    vector<string> result;

    for (int i = 1; i <= n; i++)
    {

        if (i % 15 == 0)
        {
            result.push_back("FizzBuzz");
        }
        else if (i % 5 == 0)
        {
            result.push_back("Buzz");
        }
        else if (i % 3 == 0)
        {
            result.push_back("Fizz");
        }
        else
        {
            result.push_back(std::to_string(i));
        }
    }

    return result;
}

int main()
{
    vector<string> result = fizzbuzz(15);
    for (string x : result)
    {
        cout << x << ",";
    }
    return 0;
}