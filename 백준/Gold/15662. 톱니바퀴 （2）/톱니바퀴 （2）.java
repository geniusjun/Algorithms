import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T, K, ret;
    static int[][] topnis;
    static List<Oper> opers;

    static class Oper {
        int topni;
        int dir;

        Oper(int topni, int dir) {
            this.topni = topni;
            this.dir = dir;
        }
    }

    static void rotate(int topni, int dir) {
        int[] dirs = new int[T];
        dirs[topni] = dir;

        // 왼쪽 전파
        for (int i = topni; i > 0; i--) {
            if (topnis[i - 1][2] == topnis[i][6]) {
                break;
            }
            dirs[i - 1] = -dirs[i];
        }

        // 오른쪽 전파
        for (int i = topni; i < T - 1; i++) {
            if (topnis[i + 1][6] == topnis[i][2]) {
                break;
            }
            dirs[i + 1] = -dirs[i];
        }

        for (int i = 0; i < T; i++) {
            if (dirs[i] == -1) {
                noneClockRotate(i);
            } else if (dirs[i] == 1) {
                clockRotate(i);
            }
        }
    }


    static void clockRotate(int topni) {
        int last = topnis[topni][7];
        for (int i = 7; i > 0; i--) {
            topnis[topni][i] = topnis[topni][i - 1];
        }
        topnis[topni][0] = last;
    }

    static void noneClockRotate(int topni) {
        int first = topnis[topni][0];
        for (int i = 1; i < 8; i++) {
            topnis[topni][i - 1] = topnis[topni][i];
        }
        topnis[topni][7] = first;
    }

    static int findS() {
        int sum = 0;
        for (int i = 0; i < T; i++) {
            if (topnis[i][0] == 1) {
                sum++;
            }
        }

        return sum;
    }

    // 1 ~ T
    // N : 0
    // S : 1
    // 2, 6 값이 옆 톱니바퀴랑 같은지 다른지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        topnis = new int[T][8];

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                topnis[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        opers = new ArrayList<>();
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int topni = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            opers.add(new Oper(topni, dir));
        }

        for (int i = 0; i < opers.size(); i++) {
            rotate(opers.get(i).topni, opers.get(i).dir);
        }

        ret = findS();

        System.out.println(ret);
    }
}