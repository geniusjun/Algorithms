#include <bits/stdc++.h>

using namespace std;

vector<int> adj[54];
int n, temp, x, root;

int dfs(int here) {
	int ret = 0;
	int child = 0;
	for (int there : adj[here]) {
		if (there == x) continue;
		ret += dfs(there);
		child++;
	}
	if (child == 0) return 1;
	return ret;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> temp;
		if (temp == -1)root = i;
		else adj[temp].push_back(i);
	}

	cin >> x;

	if (root == x) {
		cout << 0 << '\n';
		return 0;
	}
		cout << dfs(root) << '\n';

	return 0;
}