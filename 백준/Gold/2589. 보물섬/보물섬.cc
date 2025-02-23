#include <bits/stdc++.h>

using namespace std;

const int dy[] = { -1,0,1,0 };
const int dx[] = { 0,1,0,-1 };
char a[51][51];
int visited[51][51];
int n, m;
int mx = -1000;
vector<int> v;

int go(int y, int x) {
	queue<pair<int, int>> q;
	visited[y][x] = 1;
	q.push({ y,x });
	while (q.size()) {
		tie(y, x) = q.front(); q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
			if (a[ny][nx] == 'L' && !visited[ny][nx]) {
				visited[ny][nx] = visited[y][x] + 1;
				v.push_back(visited[ny][nx]);
				q.push({ ny,nx });
			}
		}
	}
	sort(v.begin(), v.end());
	if (v.size() > 0) {
		return v[(int)v.size() - 1];
	}
	else {
		return 0;
	}
}
int main() {

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] == 'L') {
				memset(visited, 0, sizeof(visited));
				v.clear();
				mx = max(go(i, j), mx);
			}
		}
	}
	cout << mx-1 << '\n';
	return 0;
}