import java.io.*;
import java.util.*;

public class Main {

    static int N, oneScore, twoScore, oneTime, twoTime;

    static int timeToSec(String time){
        String[] hourAndMin = time.split(":");
        int min = Integer.parseInt(hourAndMin[0]);
        int sec = Integer.parseInt(hourAndMin[1]);

        return (min * 60) + (sec);
    }

    static String secToTime(int time){
        int min = time / 60;
        int sec = time % 60;
        String ret = "";
        if(min < 10) {
            ret += "0";
            ret += String.valueOf(min);
        } else{
            ret += String.valueOf(min);
        }
        ret += ":";
        if(sec < 10){
            ret += "0";
            ret += String.valueOf(sec);
        } else{
            ret += String.valueOf(sec);
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        oneScore = 0;
        twoScore = 0;
        oneTime = 0;
        twoTime = 0;
        int oneRet = 0;
        int twoRet = 0;
        int team = 0;
        int now = 0;
        int lastTime = 0;
        while(N -- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            team = Integer.parseInt(st.nextToken());
            now = timeToSec(st.nextToken());

            if(oneScore > twoScore){
                oneRet += now - lastTime;
            } else if(oneScore < twoScore){
                twoRet += now - lastTime;
            }

            if(team == 1){
                oneScore++;
                oneTime = now;
            } else{
                twoScore++;
                twoTime = now;
            }

            lastTime = now;
        }

        if(oneScore > twoScore){
            oneRet += timeToSec("48:00") - lastTime;
        } else if(oneScore < twoScore){
            twoRet += timeToSec("48:00") - lastTime;
        }

        System.out.println(secToTime(oneRet));
        System.out.println(secToTime(twoRet));

    }
}