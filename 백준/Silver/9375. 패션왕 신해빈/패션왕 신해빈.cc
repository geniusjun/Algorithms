#include <bits/stdc++.h>

using namespace std;
int T, n;	
string a, b;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> T;
	while (T--) {
		map<string, int> mp;
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> a >> b;
			mp[b]++;
		}
		long long ret = 1;
		for (auto c : mp) {
			ret *= ((long long)c.second + 1);
		}
		ret--;
		cout << ret << '\n';
	}
	return 0;
}