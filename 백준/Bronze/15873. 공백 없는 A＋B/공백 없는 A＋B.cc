#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    cin >> s;
    int A = 0, B = 0;
    if(s.size() == 2) { // 둘 다 한 자리
        A = s[0] - '0';
        B = s[1] - '0';
    }
    else if(s.size() == 3) { // 한 쪽은 10, 다른 한 쪽은 한 자리
        if(s.substr(0,2) == "10") { // 앞이 10인 경우
            A = 10;
            B = s[2] - '0';
        }
        else { // 뒤가 10인 경우
            A = s[0] - '0';
            B = 10;
        }
    }
    else if(s.size() == 4) { // A와 B 모두 10
        A = 10;
        B = 10;
    }
    cout << A + B;
    return 0;
}