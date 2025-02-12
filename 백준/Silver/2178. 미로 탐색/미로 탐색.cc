#include <bits/stdc++.h>

using namespace std;
int a[104][104];
int visited[104][104];
int N, M, y, x;
string s;
pair<int, int> p;
const int dy[] = { -1, 0 , 1, 0 };
const int dx[] = { 0, 1, 0, -1 };




int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> s;
		for (int j = 0; j < M; j++) {
			a[i][j] = s[j] - '0';
		}
	}

	queue<pair<int, int>> q;
	visited[0][0] = 1;
	q.push({0,0});
	while (q.size()) {
		tie(y, x) = q.front(); q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			if (visited[ny][nx] || !a[ny][nx]) continue;
			visited[ny][nx] = visited[y][x] + 1;
			q.push({ ny,nx });
		}
	}

	cout << visited[N-1][M-1] << '\n';
	return 0;
}