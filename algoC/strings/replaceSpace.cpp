#include <string>
#include <iostream>
using namespace std;

void replace_space(char *str){

    //1. calc
    int spaces = 0;
    for (int i = 0; str[i] != '\0'; i++){
        if(str[i] == ' '){
            spaces +=1 ;
        }
    }

    int idx = strlen(str) + (2 * spaces);
    str[idx] = '\0';

    for (int i = strlen(str) - 1; i >=0; i--)
    {
        /* code */
    }
    
}