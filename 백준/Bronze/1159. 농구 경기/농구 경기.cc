#include <bits/stdc++.h>

using namespace std;


int arr[26];
vector<char> v;
bool isprogram = false;
int N;
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		arr[s[0] - 'a']++;
	}	
	for (int i = 0; i < 26; i++) {
		if (arr[i] >= 5) {
			v.push_back(i + 'a');
		}
	}

		if (v.size() == 0) {
			cout << "PREDAJA" << endl;
			return 0;
		}
		else {
			for (int i = 0; i < v.size(); i++) {
				cout << v[i] << "";
			}
		}

	return 0;
}