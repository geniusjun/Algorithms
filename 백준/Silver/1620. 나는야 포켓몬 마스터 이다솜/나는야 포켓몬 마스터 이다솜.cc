#include <bits/stdc++.h>

using namespace std;
int N, M;
map<string, int> m;
string arr[100001];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		arr[i + 1] = s;
		m[s] = i + 1;
	}

	for (int i = 0; i < M; i++) {
		string s;
		cin >> s;
		if (atoi(s.c_str()) == 0) {
			cout << m[s] << '\n';
		}
		else {
			cout << arr[atoi(s.c_str())] << '\n';
		}
	}


	return 0;
}