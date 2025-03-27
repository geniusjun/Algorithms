#include <bits/stdc++.h>

using namespace std;

int parent[500001];
int n, m, result;

int find(int child) {
	if (parent[child] != child)
		parent[child] = find(parent[child]); // 여기 포인트.  부모노드로 find해나가야지

	return parent[child];
}

void unionSet(int small, int big) {
	int	a = find(small);
	int b = find(big);

	if (a != b)
		parent[b] = a;
}

int main() {

	ios_base::sync_with_stdio(NULL);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	//주어진 0~n-1까지의 숫자들을 각각 자기자신이 루트노드가 되게끔 초기화
	for (int i = 0; i < n; i++) {
		parent[i] = i;
	}

	//이제 M줄만큼 연결될 두 점이 주어짐
	for (int i = 1; i <= m; i++) {
		int a, b;
		cin >> a >> b;

		if (find(a) == find(b)) {
			result = i;
			break;
		}
		else {
			unionSet(a, b);
		}
	}

	cout << result << '\n';
	return 0;
}