#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 200001 // 최대 친구 수 2 * 100,000
#define TABLE_SIZE 100003 // 해시 테이블 크기 (소수 추천)

typedef struct Node {
    char* name;
    int id;
    struct Node* next;
} Node;

Node* hashTable[TABLE_SIZE];
int parent[MAX];
int size[MAX];
int idCounter = 0;

// 해시 함수 (djb2 변형)
unsigned int hash(const char* str) {
    unsigned long hash = 5381;
    while (*str)
        hash = ((hash << 5) + hash) + (*str++); // hash * 33 + c
    return hash % TABLE_SIZE;
}

// 문자열을 정수 ID로 매핑
int getId(const char* name) {
    unsigned int idx = hash(name);
    Node* curr = hashTable[idx];
    while (curr) {
        if (strcmp(curr->name, name) == 0)
            return curr->id;
        curr = curr->next;
    }

    // 새로운 이름이면 등록
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->name = strdup(name);
    newNode->id = idCounter;
    newNode->next = hashTable[idx];
    hashTable[idx] = newNode;

    parent[idCounter] = idCounter;
    size[idCounter] = 1;

    return idCounter++;
}

// Union-Find: find
int find(int x) {
    if (x != parent[x])
        parent[x] = find(parent[x]);
    return parent[x];
}

// Union-Find: union
int unionSet(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
        parent[y] = x;
        size[x] += size[y];
    }
    return size[x];
}

// 메모리 정리
void freeHashTable() {
    for (int i = 0; i < TABLE_SIZE; i++) {
        Node* curr = hashTable[i];
        while (curr) {
            Node* tmp = curr;
            curr = curr->next;
            free(tmp->name);
            free(tmp);
        }
        hashTable[i] = NULL;
    }
}

int main() {
    int T, F;
    char name1[21], name2[21];
    scanf("%d", &T);

    while (T--) {
        scanf("%d", &F);
        idCounter = 0;
        freeHashTable(); // 초기화

        for (int i = 0; i < F; i++) {
            scanf("%s %s", name1, name2);
            int id1 = getId(name1);
            int id2 = getId(name2);
            printf("%d\n", unionSet(id1, id2));
        }
    }
    return 0;
}
