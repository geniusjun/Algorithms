#include <bits/stdc++.h>

using namespace std;

const int dy[] = { -1, 0, 1, 0 };
const int dx[] = { 0, 1, 0 ,-1 };
int M, N, K, ret, xa, ya, xb, yb;
vector<int> v;
int a[102][102];
int visited[102][102];

void DFS(int y, int x) {
	visited[y][x] = 1;
	ret++;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
		if (!visited[ny][nx] && a[ny][nx] == 1) {
			DFS(ny, nx);
		}
	}
	return;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> M >> N >> K;

	fill(&a[0][0], &a[0][0] + 102 * 102, 1);

	for (int i = 0; i < K; i++) {
		cin >> xa >> ya >> xb >> yb;

		for (int i = ya; i < yb; i++) {
			for (int j = xa; j < xb; j++) {
				a[i][j] = 0;
				visited[i][j] = 1;
			}
		}
	}

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j] && a[i][j] == 1) {
				ret = 0;
				DFS(i, j);
				v.push_back(ret);
			}
		}
	}
	sort(v.begin(), v.end());
	cout << v.size() << '\n';
	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << " ";
	}

	return 0;
}