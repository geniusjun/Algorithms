#include <bits/stdc++.h>

using namespace std;
string s;
string pt;
pair<string, string> p;
int N, pos;
int main() {
	cin >> N;
	cin >> pt;
	
	pos = pt.find("*");
	
	p.first = pt.substr(0, pos);
	p.second = pt.substr(pos+1, pt.size()-p.first.size());


	for (int i = 0; i < N; i++) {
		cin >> s;
		if (p.first.size() + p.second.size() > s.size()) {
			cout << "NE" << '\n';
		}
		else if (s.substr(0,p.first.size()) == p.first && s.substr(s.size() - p.second.size(), p.second.size()) == p.second) {
			cout << "DA" << '\n';
		}
		else {
			cout << "NE" << '\n';
		}
	}
	return 0;
}