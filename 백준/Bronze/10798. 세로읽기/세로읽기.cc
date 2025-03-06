#include <bits/stdc++.h>

using namespace std;
int n;
char a[5][15];
string s;
int main() {
	ios_base::sync_with_stdio;
	cout.tie(NULL); cin.tie(NULL);

	while (n < 5) {

		cin >> s;

		for (int i = 0; i < s.size(); i++) {
			a[n][i] = s[i];
		}
		n++;
	}

	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 5; j++) {
			if (a[j][i] == '\0') continue;
			cout << a[j][i];
		}
	}

	return 0;
}
