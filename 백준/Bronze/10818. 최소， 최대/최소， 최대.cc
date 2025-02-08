#include <bits/stdc++.h>
using namespace std;
int nums[1000001]; 

int main(void) {
    ios::sync_with_stdio(false); 
    cin.tie(NULL);               
    cout.tie(NULL); 
    int arrayCnt;
    cin >> arrayCnt;

    for (int i = 0; i < arrayCnt; i++) {
        cin >> nums[i];
    }

    int max = nums[0];  // 첫 번째 원소로 초기화
    int min = nums[0];

    for (int i = 1; i < arrayCnt; i++) {  // i = 1부터 시작
        if (max < nums[i]) {
            max = nums[i];
        }
        if (min > nums[i]) {
            min = nums[i];
        }
    }

    cout << min << " " << max;
    return 0;
}