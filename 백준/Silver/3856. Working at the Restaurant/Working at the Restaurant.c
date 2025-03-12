#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX 100000

int t = 51;
int m1 = 0;
int m2 = 0;

void DROP(int m) {
	m2 += m;
	printf("DROP 2 %d\n", m);
}

void TAKE(int m) {
	
	if (m1 >= m) {
		m1 -= m;
		printf("TAKE 1 %d\n", m);
	}
	else {
		if (m1 != 0) {
			printf("TAKE 1 %d\n", m1);
			m -= m1;
			m1 = 0;
		}
		printf("MOVE 2->1 %d\n", m2);
		if (m > m2) {
			return;
		}
		m1 = m2;
		m2 = 0;
		printf("TAKE 1 %d\n", m);
		m1 -= m;
	}

	return;

}

int main() {

	while (t--) {

		int n = 0;
		m1 = 0;
		m2 = 0;
		scanf("%d", &n);
		
		if (n == 0) break;

		for (int i = 0; i < n; i++) {
			char order[5];
			int m;
			scanf("%s %d", order, &m);

			if (strcmp(order, "DROP") == 0) {
				DROP(m);
			}
			else if (strcmp(order, "TAKE") == 0) {
				TAKE(m);
			}

			if (m1 + m2 > MAX) return 0;

		}

		printf("\n");

	}


   return 0;
}