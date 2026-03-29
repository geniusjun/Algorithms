import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, ret;

    static void go(int[][] maps, int idx) {
        if (idx == 5) {
            findMax(maps);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] next = move(maps, i);
            go(next, idx + 1);
        }
    }

    static void findMax(int[][] maps) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i][j] == 0) {
                    continue;
                }
                ret = Math.max(ret, maps[i][j]);
            }
        }
    }

    static int[][] move(int[][] maps, int dir) {
        int[][] next = maps;

        // 왼쪽으로 미는 로직이 동일하게끔 90도 회전해주기.
        // 90 회전 한번 하면 위로 밀기, 두번하면 왼쪽으로 밀기, 세번하면 아래로 밀기
        for (int i = 0; i < dir; i++) {
            next = rotate90(next);
        }

        // 왼쪽으로 밀기
        next = moveLeft(next);

        // 원상복귀 하기
        for (int i = 0; i < (4 - dir) % 4; i++) { // 위로 옮기려고 한번 돌렸으면, 원상복귀하려면 4번돌려줘야함.
            next = rotate90(next);
        }

        return next;
    }

    static int[][] rotate90(int[][] maps) {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N - i - 1] = maps[i][j];
            }
        }
        return rotated;
    }

    // 보드를 왼쪽으로 한번 이동
    static int[][] moveLeft(int[][] maps) {
        int[][] next = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] line = new int[N];

            for (int j = 0; j < N; j++) {
                line[j] = maps[i][j];
            }
            int[] moved = work(line);

            for (int j = 0; j < N; j++) {
                next[i][j] = moved[j];
            }
        }
        return next;
    }

    // 왼쪽으로 밀며 합치기
    static int[] work(int[] line) {
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (line[i] != 0) {
                nums.add(line[i]);
            }
        }
        int[] result = new int[N];
        int idx = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i + 1 < nums.size() && nums.get(i).equals(nums.get(i + 1))) {
                result[idx] = nums.get(i) * 2;
                i++;
                idx++;
            } else {
                result[idx] = nums.get(i);
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = Integer.MIN_VALUE;
        go(maps, 0);

        System.out.println(ret);
    }
}
