#include <bits/stdc++.h>
using namespace std;

double M, N, temp, p, sum;
vector<double> v;
int main() {

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());
	M = v[v.size()-1];

	for (int i = 0; i < v.size(); i++) {
		v[i] = v[i] / M * 100;
	}

	for (double a : v) {
		sum += a;
	}
	p = sum / v.size();

	printf("%.2f", p);


	return 0;
}