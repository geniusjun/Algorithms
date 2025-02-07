#include <bits/stdc++.h>
using namespace std;
int N, K;
int temp;
int psum[100004];
int ret = -10000004;
int main() {

	cin >> N >> K;

	for (int i = 1; i <= N; i++) {
		cin >> temp;
		psum[i] = psum[i - 1] + temp;
	}

	for (int i = K; i <= N; i++) {
		ret = max(ret, psum[i] - psum[i - K]);
	}
	cout << ret << '\n';


	return 0;
}