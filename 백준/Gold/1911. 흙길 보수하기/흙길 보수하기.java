import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, L, ret;
    static Water[] waters;

    static class Water {
        int l;
        int r;

        Water(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    // N개의 물웅덩이
    // 길이가 L인 널판지 충분히
    // 모든 물웅덩이를 덮기 위한 최소 널판지 갯수?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        waters = new Water[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            waters[i] = new Water(l, r);
        }

        Arrays.sort(waters, (o1, o2) -> {
            return o1.l - o2.l;
        });

        ret = 0;
        int nul = 0; // 마지막으로 널판지가 덮힌 위치
        // [1, 4)
        for (int i = 0; i < N; i++) {
            int l = waters[i].l;
            int r = waters[i].r;

            if (nul < l) { // 마지막 널판지 위치가 새로운 웅덩이에 닿지도 못할때
                nul = l;
            }

            if (nul >= r) { // 이미 널판지로 덮혀있다는 뜻
                continue;
            }

            int len = r - nul;
            int cnt = len / L;
            if (len % L != 0) {
                cnt++;
            }
            ret += cnt;
            nul += L * cnt;
        }
        System.out.println(ret);
    }
}