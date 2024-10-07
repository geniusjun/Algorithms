#include<bits/stdc++.h>
using namespace std;

int main(){
	int a, b;
	cin >> a >> b;
	int c = (b/100);
	int d = (b - (c*100)) / 10;
	int e = b - ((c*100)+(d*10));
	cout << e * a << '\n';
	cout << d * a << '\n';
	cout << c * a << '\n';
	cout << (e*a) + ((d*10)*a) + ((c*100)*a);
	
	return 0;
}