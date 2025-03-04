#include <bits/stdc++.h>
using namespace std;

string s;
int a[26], flag, temp;
int mx = -987654321;
int main() {

	cin >> s;

	for (int i = 0; i < s.size(); i++) {
		s[i] = tolower(s[i]);
	}

	for (int i = 0; i < s.size(); i++) {
		a[s[i] - 'a']++;
	} 
	for (int i = 0; i < 26; i++) {
		if (a[i] >= mx) {
			mx = a[i];
			temp = i;
		}
	}
	for (int i = 0; i < 26; i++) {
		if (a[i] == mx) {
			flag++;
		}
	}

	if (flag >= 2) {
		cout << "?" << '\n';
	}
	else {
		cout << (char)toupper((temp + 'a')) << '\n';
	}


	return 0;
}