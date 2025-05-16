#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
typedef long long ll;

vector<ll> Arr;
vector<ll> SegmentTree;

// 세그먼트 트리 초기화
ll Make_SegmentTree(int Node, int Start, int End) {
    if (Start == End)
        return SegmentTree[Node] = Arr[Start];

    int Mid = (Start + End) / 2;
    ll Left_Result = Make_SegmentTree(Node * 2, Start, Mid);
    ll Right_Result = Make_SegmentTree(Node * 2 + 1, Mid + 1, End);
    return SegmentTree[Node] = Left_Result + Right_Result;
}

// 구간합 쿼리
ll Sum(int Node, int Start, int End, int Left, int Right) {
    if (Left > End || Right < Start) return 0;
    if (Left <= Start && End <= Right) return SegmentTree[Node];

    int Mid = (Start + End) / 2;
    ll Left_Result = Sum(Node * 2, Start, Mid, Left, Right);
    ll Right_Result = Sum(Node * 2 + 1, Mid + 1, End, Left, Right);
    return Left_Result + Right_Result;
}

// 단일 값 업데이트
void Update(int Node, int Start, int End, int Index, ll Diff) {
    if (Index < Start || Index > End) return;
    SegmentTree[Node] += Diff;

    if (Start != End) {
        int Mid = (Start + End) / 2;
        Update(Node * 2, Start, Mid, Index, Diff);
        Update(Node * 2 + 1, Mid + 1, End, Index, Diff);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, K;
    cin >> N >> M >> K;
    Arr.resize(N);

    for (int i = 0; i < N; ++i)
        cin >> Arr[i];

    int Tree_Height = (int)ceil(log2(N));
    int Tree_Size = (int)pow(2, Tree_Height + 1);
    SegmentTree.resize(Tree_Size);

    Make_SegmentTree(1, 0, N - 1);

    for (int i = 0; i < M + K; ++i) {
        int a, b;
        ll c;
        cin >> a >> b >> c;

        if (a == 1) {
            b -= 1; // 0-indexed
            ll Diff = c - Arr[b];
            Arr[b] = c;
            Update(1, 0, N - 1, b, Diff);
        } else if (a == 2) {
            cout << Sum(1, 0, N - 1, b - 1, c - 1) << '\n';
        }
    }

    return 0;
}
