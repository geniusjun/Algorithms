#include <bits/stdc++.h>

using namespace std;

int N, cnt;
string s, temp;
vector<string> v;

void go() {
	while (1) {
		if (temp.size() && temp.front() == '0') temp.erase(temp.begin());
		else break;
	}
	if (temp.size() == 0) temp = "0";
	return;
}
bool cmp(string a, string b) {
	if (a.size() == b.size()) return a < b;
		return a.size() < b.size();
}
int main() {

	cin >> N;

	while (N--) {
		cin >> s;
		temp = "";
		for (int i = 0; i < s.size(); i++) {
			if ((!(s[i] - 'a' >= 0 && s[i] - 'a' <= 25))) {
				temp += s[i];
			}
			else {
				if (temp != "") {
					go();
					v.push_back(temp);
				}
				temp = "";
			}
		}
		if (temp != "") {
			go();
			v.push_back(temp);
		}
	}


	sort(v.begin(), v.end(), cmp);
	for (string a : v) cout << a << '\n';
	return 0;
}