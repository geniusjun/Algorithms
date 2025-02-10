#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int N, cnt;
ll M;
vector<int> v;
int main() {

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	for (int i = 0; i < v.size() - 1; i++) {
		for (int j = i+1; j < v.size(); j++) {
			if (v[i] + v[j] == M) cnt++;
		}
	}

	cout << cnt << '\n';
	return 0;
}