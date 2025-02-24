#include <iostream>
#include <string>

using namespace std;

int main() {
    string line;
    while (getline(cin, line)) {  // 여러 줄 입력 처리
        string result = "";  // 결과 문자열
        for (char c : line) {
            result += c;  // 한 글자씩 추가
            if (result.size() >= 3 && result.substr(result.size() - 3) == "BUG") {
                result.erase(result.size() - 3);  // "BUG"가 생기면 제거
            }
        }
        cout << result << '\n';  // 가공된 문자열 출력
    }
    return 0;
}