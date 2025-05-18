#include <stdio.h>
#include <stdlib.h>

#define SIZE 200003
#define OFFSET 2147483648LL  // long long 사용

typedef struct Node {
    int key;
    struct Node* next;
} Node;

Node* hashTable[SIZE];

// 해시 함수 (long long으로 안전하게 처리)
int hash(int key) {
    long long adjusted = (long long)key + OFFSET;
    return adjusted % SIZE;
}

void insert(int key) {
    int h = hash(key);
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->key = key;
    newNode->next = hashTable[h];
    hashTable[h] = newNode;
}

int find(int key) {
    int h = hash(key);
    Node* cur = hashTable[h];
    while (cur != NULL) {
        if (cur->key == key) return 1;
        cur = cur->next;
    }
    return 0;
}

int main() {
    int N, M;
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        int a;
        scanf("%d", &a);
        insert(a);
    }

    scanf("%d", &M);
    for (int i = 0; i < M; i++) {
        int x;
        scanf("%d", &x);
        printf("%d\n", find(x));
    }

    return 0;
}
