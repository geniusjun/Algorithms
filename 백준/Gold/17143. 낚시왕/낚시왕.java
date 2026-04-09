import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ret, Y, X, M;

    static class Shark {
        int s;
        int d;
        int z;

        Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static class After {
        int h;
        int d;

        After(int h, int d) {
            this.h = h;
            this.d = d;
        }
    }

    static Shark[][] makeMap(Shark[][] maps) {
        Shark[][] dMaps = new Shark[Y][X];

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (maps[i][j] != null) {
                    Shark shark = maps[i][j];
                    if (shark.d <= 2) { // 위 아래
                        After after = goY(i, shark.s, shark.d);
                        shark.d = after.d;
                        if (dMaps[after.h][j] != null) {
                            if (dMaps[after.h][j].z < shark.z) {
                                dMaps[after.h][j] = shark;
                            }
                        } else {
                            dMaps[after.h][j] = shark;
                        }
                    } else { // 좌우
                        After after = goX(j, shark.s, shark.d);
                        shark.d = after.d;
                        if (dMaps[i][after.h] != null) {
                            if (dMaps[i][after.h].z < shark.z) {
                                dMaps[i][after.h] = shark;
                            }
                        } else {
                            dMaps[i][after.h] = shark;
                        }
                    }
                }
            }
        }

        return dMaps;
    }

    static After goY(int here, int s, int d) {
        while (s-- > 0) {
            if (d == 1) { // 위
                if (here - 1 < 0) {
                    d = 2;
                    here++;
                } else {
                    here--;
                }
            } else { // 2 -> 아래
                if (here + 1 >= Y) {
                    d = 1;
                    here--;
                } else {
                    here++;
                }
            }
        }
        return new After(here, d);
    }

    static After goX(int here, int s, int d) {
        while (s-- > 0) {
            if (d == 3) { // -> 오른쪽
                if (here + 1 >= X) {
                    d = 4;
                    here--;
                } else {
                    here++;
                }

            } else { // 4 -> 왼쪽
                if (here - 1 < 0) {
                    d = 3;
                    here++;
                } else {
                    here--;
                }
            }
        }
        return new After(here, d);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Shark[][] maps = new Shark[Y][X];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (s == 1 || s == 2) {
                if (Y > 1) {
                    s %= (2 * (Y - 1));
                }
            } else if (s == 3 || s == 4) {
                if (X > 1) {
                    s %= (2 * (X - 1));
                }
            }
            maps[y][x] = new Shark(s, d, z);
        }

        ret = 0;
        // 왼 -> 오
        for (int i = 0; i < X; i++) {
            // 현재 x에서 땅과 가장 가까운 상어잡기
            for (int j = 0; j < Y; j++) {
                if (maps[j][i] != null) {
                    ret += maps[j][i].z;
                    maps[j][i] = null;
                    break; // 잡으면 바로 넘어가기
                }
            }

            // 상어 이동
            maps = makeMap(maps);
        }

        System.out.println(ret);
    }
}