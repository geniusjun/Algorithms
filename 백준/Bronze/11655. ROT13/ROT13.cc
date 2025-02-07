#include <bits/stdc++.h>

using namespace std;
string s;
vector<char> v;
int main() {

	getline(cin, s);

	for (int i = 0; i < s.size(); i++) {
		if (s[i] - '0' >= 17 && s[i] - '0' < 30) {
			v.push_back(s[i] + 13);
		}
		else if (s[i] - '0' >= 30 && s[i] - '0' <= 43) {
			v.push_back(s[i] - 13);
		}
		else if (s[i] - '0' >= 49 && s[i] - '0' < 62) {
			v.push_back(s[i] + 13);
		}
		else if (s[i] - '0' >= 62 && s[i] - '0' <=75) {
			v.push_back(s[i] - 13);
		}
		else {
			v.push_back(s[i]);
		}
	}
	for (char i : v) {
		cout << i;
	}

	return 0;
}