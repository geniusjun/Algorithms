#include <bits/stdc++.h>

using namespace std;

string s;
int main() {

	getline(cin, s);

	for (int i = 0; i < s.size(); i++) {
		if ((int)s[i] >= 65 && (int)s[i] <= 90 ) {
			if (s[i] > 77) {
				s[i] = s[i] - 13;
			}
			else {
				s[i] = s[i] + 13;
			}
		}
		else if ((int)s[i] >= 97 && (int)s[i] <= 122) {
			if (s[i] > 109) {
				s[i] = s[i] - 13;
			}
			else {
				s[i] = s[i] + 13;
			}
		}
	}
	cout << s << '\n';


	return 0;
}