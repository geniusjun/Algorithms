#include <bits/stdc++.h>

using namespace std;

int A, B, C;
vector<pair<int, int>> v;
int arr[101];
int sum;
int main() {
	cin >> A >> B >> C;

	for (int i = 0; i < 3; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back({a,b});
	}
	
	for (int i = 0; i < 3; i++) {
		for (int j = v[i].first; j < v[i].second; j++) {
			arr[j]++;
		}
	}

	for (int i = 0; i < 101; i++) {
		if (arr[i] == 1) {
			sum += A;
		}
		else if (arr[i] == 2) {
			sum += 2*B;
		}
		else if (arr[i] == 3) {
			sum += 3*C;
		}
	}

	cout << sum << endl;


	return 0;
}