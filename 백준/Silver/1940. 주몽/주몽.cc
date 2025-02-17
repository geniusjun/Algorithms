#include <bits/stdc++.h>

using namespace std;

int N, M, ret;
int a[15004], visited[15004];
int main() {

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}

	for (int i = 0; i < N; i++) {
		for (int j = i+1; j < N; j++) {
			if (a[i] + a[j] == M && visited[i] == 0 && visited[j] == 0) {
				ret++;
				visited[i] = 1, visited[j] = 1;
			}
		}
	}

	cout << ret << '\n';

	return 0;
}