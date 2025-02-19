#include <bits/stdc++.h>

using namespace std;

const int dy[] = { -1, 0, 1, 0 };
const int dx[] = { 0, 1, 0, -1 };
int N, M, temp;
int ret = 100;
int a[10][10], visited[10][10];
vector<pair<int, int>> w;
vector<pair<int, int>> v;

void go(int y, int x) {
	if (!visited[y][x]) {
		visited[y][x] = 1; temp++;
	}
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
		if ((a[ny][nx] == 0) && !visited[ny][nx]) {
			visited[ny][nx] = 1;
			temp++;
			go(ny, nx);
		} 
	}
	return;
}
int main() {

	cin >> N >> M;
	// 연구소 입력받기
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> a[i][j];
			if (a[i][j] == 0) w.push_back({ i,j });
			else if (a[i][j] == 2) v.push_back({ i,j });
		}
	}
	for (int i = 0; i < w.size(); i++) {
		for (int j = i + 1; j < w.size(); j++) {
			for (int k = j + 1; k < w.size(); k++) {
				a[w[i].first][w[i].second] = 1;
				a[w[j].first][w[j].second] = 1;
				a[w[k].first][w[k].second] = 1;

				memset(visited, 0, sizeof(visited));
				int infected = 0;
				for (int h = 0; h < v.size(); h++) {
					temp = 0;
					go(v[h].first, v[h].second);
					infected += temp;
				}
				ret = min(ret, infected);
				a[w[i].first][w[i].second] = 0;
				a[w[j].first][w[j].second] = 0;
				a[w[k].first][w[k].second] = 0;
			}
		}
	}
	cout << w.size() - 3 - (ret - v.size()) << '\n';

	return 0;
}