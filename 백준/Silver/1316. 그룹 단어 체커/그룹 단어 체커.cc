#include <bits/stdc++.h>

using namespace std;
int n, ret, a[26];
string s;
bool isGroup;
int main() {
	
	cin >> n;
	while (n--) {
		isGroup = 1;
		memset(a, 0, sizeof(a));
		cin >> s;

		if (s.size() == 1) {
			ret++;
			continue;
		}

		for (int i = 0; i < s.size()-1; i++) {
			if (s[i] == s[i + 1] && a[s[i] - 'a'] == 0) {

			}
			else {
				if (a[s[i] - 'a'] == 0) {
					a[s[i] - 'a']++;
				}
				else {
					isGroup = 0;
					break;
				}
			}
		}
		if (s[s.size() - 1] != s[s.size() - 2]) {
			if (a[s[s.size() - 1] - 'a'] != 0) isGroup = 0;
		}

		if (isGroup) {
			ret++;
		}
	}

	cout << ret << '\n';
	return 0;
}