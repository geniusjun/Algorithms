#include <bits/stdc++.h>

using namespace std;

int cnt[26];
string s;
int N;
bool isokay;
int main() {

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> s;
		cnt[s[0] - 'a']++;
	}

	for (int i = 0; i < 26; i++) {
		if (cnt[i] >= 5) {
			cout << (char)(i + 'a');
			isokay = true;
		}
	}

	if (!isokay) {
		cout << "PREDAJA" << '\n';
	}

	return 0;
}