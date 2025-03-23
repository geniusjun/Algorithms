#include <stdio.h>

int parent[500001];

// Find with path compression
int find(int x) {
    if (parent[x] != x)
        parent[x] = find(parent[x]);
    return parent[x];
}

// Union two sets
void unionSets(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b)
        parent[b] = a;
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    // 각 노드를 자기 자신이 부모로 초기화
    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }

    int result = 0;
    for (int i = 1; i <= m; i++) {
        int a, b;
        // 현재 차례의 두 점을 입력받음
        scanf("%d %d", &a, &b);

        // 두 점이 이미 같은 집합에 있다면 사이클 발생
        if (find(a) == find(b)) {
            result = i;
            break;
        } else {
            unionSets(a, b);
        }
    }

    printf("%d\n", result);
    return 0;
}
