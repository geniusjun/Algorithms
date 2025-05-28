#include <stdio.h>

int parent[1001];

// Find 함수 (재귀 + 경로 압축)
int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

// Union 함수
void union_sets(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int N, M;
        scanf("%d %d", &N, &M);

        // 부모 배열 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int used = 0;

        for (int i = 0; i < M; i++) {
            int a, b;
            scanf("%d %d", &a, &b);

            // 사이클이 생기지 않도록 연결
            if (find(a) != find(b)) {
                union_sets(a, b);
                used++; // 간선 사용
            }
        }

        printf("%d\n", used); // 항상 N-1일 것
    }

    return 0;
}
