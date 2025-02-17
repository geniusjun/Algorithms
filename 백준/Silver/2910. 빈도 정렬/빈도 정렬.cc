#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int N, C;
int cnt[1004];
map<int, int> mp, mp2;
vector<pair<int, int>> v;

bool cmp(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first) {
		return 	mp2[a.second] < mp2[b.second];
	}
	return a.first > b.first;
}

int main() {
	cin >> N >> C;

	for (int i = 1; i <= N; i++) {
		cin >> cnt[i]; mp[cnt[i]]++;
		if (mp2[cnt[i]] == 0) mp2[cnt[i]] = i;
	}
	for (auto it : mp) {	
		v.push_back({ it.second, it.first });
	}
	sort(v.begin(), v.end(), cmp);

	for (auto i : v) {
		for (int j = 0; j < i.first; j++) {
			cout << i.second << " ";
		}
	}


	return 0;
}