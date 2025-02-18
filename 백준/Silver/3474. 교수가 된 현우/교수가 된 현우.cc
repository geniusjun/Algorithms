#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int T, ret;
ll N;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> N;
		ret = 0;
		for (ll i = 5; i <= N; i *= 5) {
			ret += N / i;
		}
		cout << ret << '\n';
	}

	return 0;
}