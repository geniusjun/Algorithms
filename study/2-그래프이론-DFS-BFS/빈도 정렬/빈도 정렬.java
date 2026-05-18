import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 빈도정렬 {

    static int N, C;
    static Map<Integer, Node> map;

    static class Node{
        int num;
        int count;
        int firstIdx;

        Node(int num, int count, int firstIdx){
            this.num = num;
            this.count = count;
            this.firstIdx = firstIdx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(!map.containsKey(num)){
                map.put(num, new Node(num, 1, i));
            } else{
                map.get(num).count++;
            }
        }

        List<Node> list = new ArrayList<>(map.values());
        list.sort((o1, o2) ->{
            if(o1.count == o2.count){
                return o1.firstIdx - o2.firstIdx;
            } else{
                return o2.count - o1.count;
            }
        });

        for(int i = 0; i < list.size(); i++){
            int cnt = list.get(i).count;
            for(int j = 0; j < cnt; j++){
                System.out.print(list.get(i).num + " ");
            }
        }



    }
}