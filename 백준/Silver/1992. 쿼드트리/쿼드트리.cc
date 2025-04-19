#include <bits/stdc++.h>

using namespace std;
char a[101][101];
string s;
int N;

string quard(int y, int x, int size) {
	if (size == 1) return string(1, a[y][x]);
	char b;
	b = a[y][x];
	string ret = "";
	for (int i = y; i < y + size; i++) {
		for (int j = x; j < x + size; j++) {
			if (b != a[i][j]) {
				ret += "(";
				ret += quard(y, x, size / 2);
				ret += quard(y, x + size / 2, size / 2);
				ret += quard(y + size / 2, x, size / 2);
				ret += quard(y + size / 2, x + size / 2, size / 2);
				ret += ")";
				return ret;
			}
		}
	}
	return string(1, a[y][x]);
}
int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> s;
		for (int j = 0; j < N; j++) {
			a[i][j] = s[j];
		}
	}
	cout << quard(0, 0, N) << '\n';

	return 0;
}
