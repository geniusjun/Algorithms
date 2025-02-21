#include <bits/stdc++.h>

using namespace std;

int a[51][51];
int N, M, temp, cityChDis;
int disCh = 10000;
int ret = 1000000;
vector<pair<int, int>> home, ch;
vector<int> noch;
vector<int> chDis;

void dis(int y, int x) {
	disCh = 100000;
	for (int i = 0; i < noch.size(); i++) {
		disCh = min(disCh, (abs(y - ch[noch[i]].first) + abs(x - ch[noch[i]].second)));
	}
	chDis.push_back(disCh);
}

void combi(int start, vector<int> &b) {
	if (b.size() == M) {
		cityChDis = 0;
		chDis.clear();
		for (int i = 0; i < home.size(); i++) {
			dis(home[i].first, home[i].second);
		}
		for (int k : chDis) cityChDis += k;
		ret = min(ret, cityChDis);
		return;
	}
	for (int i = start + 1; i < ch.size(); i++) {
		b.push_back(i);
		combi(i, b);
		b.pop_back();
	}
}

int main() {

	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> temp;
			if (temp == 1) home.push_back({ i,j });
			else if (temp == 2) ch.push_back({ i,j });
			
			a[i][j] = temp;
		}
	}

	//폐업시키지 않을 치킨집의 인덱스 M개 noch에 담기
	combi(-1, noch);
	
	cout << ret << '\n';

	return 0;
}