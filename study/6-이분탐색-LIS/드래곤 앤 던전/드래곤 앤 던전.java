import java.io.*;
import java.util.*;

public class 드래곤 앤 던전 {

    static long N, HATK, ret;
    static List<Room> list;

    static class Room{
        int ti;
        int ai;
        int hi;

        Room(int ti, int ai, int hi){
            this.ti = ti;
            this.ai = ai;
            this.hi = hi;
        }
    }

    static boolean isClear(long maxHp){
        long attack = HATK;
        long curHp = maxHp;
        for(int i = 0; i < list.size(); i++){
            Room room = list.get(i);
            if(room.ti == 1){ // 몬스터
                int curMonHp = room.hi;

                long hitCnt = (curMonHp - 1) / attack;
                curHp -= room.ai * hitCnt;

                if(curHp <= 0){
                    return false;
                }

            } else { // 2 -> 포션
                attack += room.ai;
                curHp += room.hi;
                curHp = Math.min(maxHp, curHp);
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        HATK = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int ti = Integer.parseInt(st.nextToken());
            int ai = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());
            list.add(new Room(ti, ai, hi));
        }

        long l = 1, r = Long.MAX_VALUE / 2;
        ret = r;

        while(l <= r){
            long mid = (l + r) / 2;
            if(isClear(mid)){
                ret = Math.min(mid, ret);
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }

        System.out.println(ret);

    }
}