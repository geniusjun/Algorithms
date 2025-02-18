#include <bits/stdc++.h>

using namespace std;

char a[104][104];
int ret[104][104];
int H, W, temp;
bool isC;
int main() {
	cin >> H >> W;

	for (int i = 0; i < H; i++) {
		temp = 0;
		isC = 0;
		for (int j = 0; j < W; j++) {
			cin >> a[i][j];
			if (a[i][j] == '.' && !isC) {
				ret[i][j] = -1;
			}
			else if (a[i][j] == '.' && isC) {
				ret[i][j] = ++temp;
			}
			else if (a[i][j] == 'c') {
				ret[i][j] = 0;
				isC = 1;
				temp = 0;
			}
		}
	}

	for (int i = 0; i < H; i++) {
		for (int j = 0; j < W; j++) {
			cout << ret[i][j] << " ";
		}
		cout << '\n';
	}
	return 0;
}