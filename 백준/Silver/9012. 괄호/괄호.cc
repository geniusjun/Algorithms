#include <bits/stdc++.h>

using namespace std;

int T, open, close;
bool isNo;
string s;
int main() {
	cin >> T;
	while (T--) {
		cin >> s;
		open = 0;
		close = 0;
		isNo = 0;
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == '(') open++;
			else if (s[i] == ')') close--;

			if (open + close < 0) {
				cout << "NO" << '\n';
				isNo = 1;
				break;
			}
		}
		if (isNo) continue;

		if (open + close == 0) cout << "YES" << '\n';
		else cout << "NO" << '\n';

	}
	return 0;
}