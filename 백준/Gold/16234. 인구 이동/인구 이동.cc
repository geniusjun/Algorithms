#include <bits/stdc++.h>

using namespace std;

const int dy[] = { -1,0,1,0 };
const int dx[] = { 0,1,0,-1 };
int N, L, R, ret;
int a[51][51], visited[51][51];
bool isOpen;
vector<pair<int, int>> v;

void go(int y, int x) {
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
		if (!visited[ny][nx] && (abs(a[ny][nx] - a[y][x]) >= L) && (abs(a[ny][nx] - a[y][x]) <= R))
		{
			v.push_back({ ny,nx });
			isOpen = 1;
			go(ny, nx);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> L >> R;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> a[i][j];
		}
	}

	do {
		v.clear();
		memset(visited, 0, sizeof(visited));
		isOpen = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					go(i, j);
				}
				if (v.size() > 0) {
					v.push_back({ i,j });
					int sum = 0;
					for (auto s : v) sum += a[s.first][s.second];
					for (auto d : v) a[d.first][d.second] = sum / v.size();
					v.clear();
				}
			}
		}
		if (isOpen) ret++;
	} while (isOpen);

	cout << ret << '\n';

	return 0;
}