#include <bits/stdc++.h>
using namespace std;

vector<char> v;
string s;
int a, sum;
int main() {

	cin >> a;
	cin >> s;
	for (int i = 0; i < s.size(); i++) {
		sum += s[i] - '0';
	}

	cout << sum << '\n';


	return 0;
}