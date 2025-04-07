#include <bits/stdc++.h>

using namespace std;

vector<int> preOrder;

void postOrder(int start, int end) {
	if (start >= end) {
		return;
	}
	
	int root = preOrder[start];
	int idx = start + 1;

	while (idx < end && preOrder[idx] < root)
		idx++;

	postOrder(start + 1, idx);
	postOrder(idx, end);

	cout << root << '\n';


}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int value;

	while (cin >> value) {
		preOrder.push_back(value);
	}

	postOrder(0, preOrder.size());

}