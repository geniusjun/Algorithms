#include <bits/stdc++.h>

using namespace std;

const int dy[] = { -1, 0, 1, 0 };
const int dx[] = { 0, 1, 0, -1 };
int a[102][102], visited[102][102];
int n, m, cnt, t;
bool flag;
vector<pair<int, int>> v;
void go(int y, int x) {
	visited[y][x] = 1;
	if (a[y][x] == 1) {
		v.push_back({ y, x });
		return;
	}
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
		if (!visited[ny][nx]) go(ny, nx);
	}
	return;
}

int main() {

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
		}
	}

	while (true) {
		memset(visited, 0, sizeof(visited));
		v.clear();
		go(0, 0);
		cnt = v.size();
		for (auto b : v) {
			a[b.first][b.second] = 0;
		}
		bool flag = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != 0) flag = 1;
			}
		}
		t++;
		if (!flag) break;
	}
	cout << t << '\n' << cnt;
	return 0;
}