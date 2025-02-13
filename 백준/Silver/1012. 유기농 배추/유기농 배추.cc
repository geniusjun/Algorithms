#include <bits/stdc++.h>

using namespace std;

int T, N, M, K;
int a[52][52], visited[52][52];
const int dy[] = { -1, 0, 1, 0 };
const int dx[] = { 0, 1, 0, -1 };

void DFS(int y, int x) {
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
		if(a[ny][nx] == 1 && !visited[ny][nx]) DFS(ny, nx);
	}
	return;
}

int main() {
	cin >> T;
	while (T--) {
		cin >> N >> M >> K;
		memset(a, 0, sizeof(a));
		memset(visited, 0 , sizeof(a));
		int ret = 0;
		for (int i = 0; i < K; i++) {
			int y, x;
			cin >> y >> x;
			a[y][x] = 1;
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && a[i][j] == 1) {
					ret++;
					DFS(i, j);
				}
			}
		}
		cout << ret << '\n';
	}
	return 0;
}