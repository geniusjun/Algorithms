#include <bits/stdc++.h>

using namespace std;

string s, ret;
int flag;
char cnt[200];
char mid;
int main() {
	cin >> s;
	for (int i = 0; i < s.size(); i++) {
		cnt[s[i]]++;
	}
	for (int i = 'Z'; i >= 'A'; i--) {
		if (cnt[i]) {
			if (cnt[i] % 2 == 1) {
				mid = (char)i; flag++;
				cnt[i]--;
			}
			if (flag == 2) break;
			for (int j = 0; j < cnt[i]; j += 2) {
				ret = char(i) + ret;
				ret += char(i);
			}
		}
	}
	if (mid)ret.insert(ret.begin() + ret.size() / 2, mid);
	if (flag == 2) cout << "I'm Sorry Hansoo\n";
	else cout << ret << '\n';


	return 0;
}