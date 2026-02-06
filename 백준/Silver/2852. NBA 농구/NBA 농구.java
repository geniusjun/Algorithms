import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class MinuteAndSecond {
        int minute;
        int second;

        MinuteAndSecond(int minute, int second) {
            this.minute = minute;
            this.second = second;
        }

        public void plus(MinuteAndSecond time) {
            this.minute += time.minute;
            this.second += time.second;
            if (this.second > 60) {
                this.second -= 60;
                this.minute++;
            }
        }

        public void minusMinute(int dMinute) {
            this.minute -= dMinute;
        }

        public void minusSecond(int dSecond) {
            if (this.second < dSecond) {
                this.minute--;
                this.second += 60;
                this.second -= dSecond;
            } else {
                this.second -= dSecond;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        MinuteAndSecond winningStratTime = null;
        MinuteAndSecond oneTeamTime = new MinuteAndSecond(0, 0);
        MinuteAndSecond twoTeamTime = new MinuteAndSecond(0, 0);

        int oneTeam = 0;
        int twoTeam = 0;
        boolean isFirst = false;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] times = st.nextToken().split(":");
            MinuteAndSecond time = new MinuteAndSecond(Integer.parseInt(times[0]), Integer.parseInt(times[1]));

            if (team == 1) {
                oneTeam++;
            } else {
                twoTeam++;
            }

            if (oneTeam > twoTeam) {
                if (!isFirst) {
                    winningStratTime = time;
                    isFirst = true;
                }

            } else if (twoTeam > oneTeam) {
                if (!isFirst) {
                    winningStratTime = time;
                    isFirst = true;
                }

            } else {
                isFirst = false;
                if (team == 1) { // 2팀이 이기고 있었다가 1팀이 득점해서 비긴 상황
                    time.minusMinute(winningStratTime.minute);
                    time.minusSecond(winningStratTime.second);
                    twoTeamTime.plus(new MinuteAndSecond(time.minute, time.second));
                } else { // 1팀이 이기고 있었다가 2팀이 득점해서 비긴 상황
                    time.minusMinute(winningStratTime.minute);
                    time.minusSecond(winningStratTime.second);
                    oneTeamTime.plus(new MinuteAndSecond(time.minute, time.second));
                }
            }
        }
        MinuteAndSecond lastTime = new MinuteAndSecond(48, 0);
        if (oneTeam > twoTeam) { // 마지막에 어떤팀이 이기고 있는 경우 처리
            lastTime.minusMinute(winningStratTime.minute);
            lastTime.minusSecond(winningStratTime.second);
            oneTeamTime.plus(new MinuteAndSecond(lastTime.minute, lastTime.second));
        } else if (twoTeam > oneTeam) {
            lastTime.minusMinute(winningStratTime.minute);
            lastTime.minusSecond(winningStratTime.second);
            twoTeamTime.plus(new MinuteAndSecond(lastTime.minute, lastTime.second));
        }

        if (oneTeamTime.minute < 10) {
            System.out.print("0" + oneTeamTime.minute + ":");
        } else {
            System.out.print(oneTeamTime.minute + ":");
        }
        if (oneTeamTime.second < 10) {
            System.out.println("0" + oneTeamTime.second);
        } else {
            System.out.println(oneTeamTime.second);
        }

        if (twoTeamTime.minute < 10) {
            System.out.print("0" + twoTeamTime.minute + ":");
        } else {
            System.out.print(twoTeamTime.minute + ":");
        }

        if (twoTeamTime.second < 10) {
            System.out.println("0" + twoTeamTime.second);
        } else {
            System.out.println(twoTeamTime.second);
        }
    }
}