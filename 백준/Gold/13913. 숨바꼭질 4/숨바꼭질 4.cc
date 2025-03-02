#include <bits/stdc++.h>

using namespace std;
#define prev aa
#define next aaa
const int MAX = 200004;
int s, d, ret;
int visited[MAX];
int prev[MAX];
vector<int> v;
int main() {

	cin >> s >> d;

	visited[s] = 1;
	queue<int> q;
	q.push(s);
	while (q.size()) {
		int now = q.front();
		q.pop();
		if (now == d) {
			ret = visited[d];
			break;
		}
		for (int next : {now - 1, now + 1, now * 2}) {
			if (next >= 0 && next <= MAX) {
				if (!visited[next]) { 
					visited[next] = visited[now] + 1;
					prev[next] = now;
					q.push(next);
				}
			}
		}
	}
	for (int i = d; i != s; i = prev[i]) {
		v.push_back(i);
	}
	v.push_back(s);
	cout << ret - 1 << '\n';
	reverse(v.begin(), v.end());
	for (int a : v) cout << a << " ";

	return 0;
}