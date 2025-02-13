#include <bits/stdc++.h>

using namespace std;

const int dy[] = { -1,0,1,0 };
const int dx[] = { 0,1,0,-1 };

int a[102][102], visited[102][102];
int N, H, ret;
int mret = -100;
int m = 100;

void DFS(int y, int x) {
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
		if (!visited[ny][nx] && a[ny][nx] >= H) DFS(ny, nx);
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> a[i][j];
		}
	}
	while (m--) {
		memset(visited, 0, sizeof(visited));
		ret = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && a[i][j] >= H) {
					ret++; DFS(i, j);
				}
			}
		}
		mret = max(ret, mret);
		H++;
	}
	cout << mret << '\n';
	return 0;
}