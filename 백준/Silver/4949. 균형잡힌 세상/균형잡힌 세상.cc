#include <bits/stdc++.h>

using namespace std;

string s;

int main() {


	while (1) {
		getline(cin, s);
		if (s == ".") break;
		stack<char> stk;
		bool check = 1;

		for (int i = 0; i < s.size(); i++) {
			if (s[i] == ')') {
				if (stk.size() == 0 || stk.top() == '[') {
					check = 0;
					break;
				}
				else {
					stk.pop();
				}
			}
			if (s[i] == ']') {
				if (stk.size() == 0 || stk.top() == '(') {
					check = 0;
					break;
				}
				else {
					stk.pop();
				}

			}
			if (s[i] == '(') stk.push(s[i]);
			if (s[i] == '[') stk.push(s[i]);
		}

		if (stk.empty() && check) {
			cout << "yes" << '\n';
		}
		else {
			cout << "no" << '\n';
		}
	}
	return 0;
}