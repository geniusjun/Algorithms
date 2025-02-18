#include <bits/stdc++.h>

using namespace std;

string s;
int main() {

	while (1) {
		bool flag = 1;
		bool isvowel = 0;
		int vowelcnt = 0;
		int consonantcnt = 0;
		cin >> s;
		if (s == "end") break;

		for (int i = 0; i < s.size(); i++) {
			if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
				isvowel = 1;
				vowelcnt++;
				consonantcnt = 0;
			}
			else {
				consonantcnt++;
				vowelcnt = 0;
			}

			if (i < s.size()- 1 && s[i] == s[i+1] && s[i] != 'e' && s[i] != 'o') flag = 0;
			

			if (consonantcnt == 3 || vowelcnt == 3) flag = 0;
		}

		if (isvowel && flag) {
			cout << "<" << s << ">" << " is acceptable." << '\n';
		}
		else {
			cout << "<" << s << ">" << " is not acceptable." << '\n';
		}
		
	}

	return 0;
}