import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, ret;
    static int[][] points;
    static List<Integer> link;
    static Set<Integer> set;

    static void go(List<Integer> teams, int idx) {
        if (idx >= N) {
            return;
        }
        if (teams.size() == N / 2) {
            set = new HashSet<>(teams);
            link = new ArrayList<>();
            for (int i = 0; i < N; i++) { // 상대팀 만들기
                if (!set.contains(i)) {
                    link.add(i);
                }
            }

            int linkSum = 0;
            for (int i = 0; i < link.size(); i++) { // link 팀 합산
                int me = link.get(i);
                for (int j = i + 1; j < link.size(); j++) {
                    int partner = link.get(j);
                    linkSum += points[me][partner];
                    linkSum += points[partner][me];
                }
            }
            int startSum = 0;
            for (int i = 0; i < teams.size(); i++) { // start팀 합산
                int me = teams.get(i);
                for (int j = i + 1; j < teams.size(); j++) {
                    int partner = teams.get(j);
                    startSum += points[me][partner];
                    startSum += points[partner][me];
                }
            }
            ret = Math.min(ret, Math.abs(linkSum - startSum));
            return;
        }

        // 미포함
        go(teams, idx + 1);
        // 포함
        teams.add(idx);
        go(teams, idx + 1);
        teams.remove(teams.size() - 1);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        points = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = Integer.MAX_VALUE;
        List<Integer> teams = new ArrayList<>();
        go(teams, 0);

        System.out.println(ret);
    }
}
