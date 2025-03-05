#include <bits/stdc++.h>

using namespace std;
string s;
int flag;
bool isZ;
int main() {
	
	cin >> s;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] == 'c') {
			if (s[i + 1] == '=' || s[i + 1] == '-') flag++;
		}
		else if (s[i] == 'd') {
			if (i+2 < s.size() && s[i + 1] == 'z' && s[i+2] =='=') {
				flag += 2;
				isZ = true;
			}
			else if (s[i + 1] == '-') flag++;
		}
		else if (s[i] == 'l') {
			if (s[i + 1] == 'j') flag++;
		}
		else if (s[i] == 'n') {
			if (s[i + 1] == 'j') flag++;
		}
		else if (s[i] == 's') {
			if (s[i + 1] == '=') flag++;
		}

		else if (s[i] == 'z') {
			if (s[i + 1] == '=' && !isZ) flag++;
			isZ = false;
		}
	}

	cout << s.size() - flag << '\n';
	return 0;
}