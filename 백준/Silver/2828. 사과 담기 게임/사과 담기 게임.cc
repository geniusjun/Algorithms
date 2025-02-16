#include <bits/stdc++.h>

using namespace std;

const int dx[] = { -1,1 };
int N, M, J, l, r, ret, temp;
int sx;

int a[12];
int main() {

	cin >> N >> M;
	cin >> J;
	l = 1;
	for (int i = 0; i < J; i++) {
		r = l + M - 1;
		cin >> temp;
		if (temp >= l && temp <= r) continue;
		else {
			if (temp < l) {
				ret += (l - temp);
				l = temp;
			}
			else {
				l += (temp - r);
				ret += (temp - r);
			}
		}
	}
		cout << ret << '\n';
	return 0;
}