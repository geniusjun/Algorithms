#include <bits/stdc++.h>

using namespace std;

vector<int> adj[10001];
vector<int> v;
int visited[10001];
int N, M, A, B, ret;
int mx = -100;

void go(int here) {
	visited[here] = 1;
	ret++;
	for (int there : adj[here]) {
		if (visited[there]) continue;
		go(there);
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		cin >> A >> B;
		adj[B].push_back(A);
	}

	for (int i = 1; i <= N; i++) {
		memset(visited, 0, sizeof(visited));
		go(i);
		if (ret > mx) {
			mx = ret;
			v.clear();
			v.push_back(i);
		}
		else if (ret == mx) {
			v.push_back(i);
		}
		ret = 0;
	}

	sort(v.begin(), v.end());

	for (int a : v) cout << a << " ";


	return 0;
}