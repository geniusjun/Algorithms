#include <bits/stdc++.h>
using namespace std;
int N, ret;
string s;
int main() {

	cin >> N;
	
	for (int i = 0; i < N; i++) {
		cin >> s;
		stack<char> stk;
		for (char a : s) {
			if (stk.size() && a == stk.top()) stk.pop();
			else stk.push(a);
		}
		if (stk.size() == 0) ret++;
	}
		
	cout << ret << '\n';
	return 0;
}