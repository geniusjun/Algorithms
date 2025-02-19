#include <bits/stdc++.h>

using namespace std;

int N, flag;
int a;
int main() {
	cin >> N;
	while (1) {
		if (flag == N) break;
		a++;
		string str = to_string(a);
		
		auto six = str.find("666");
		if (six != string::npos) flag++;
	}
	cout << a << '\n';

	return 0;
}