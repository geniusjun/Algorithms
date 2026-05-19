import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 수학숙제 {

    static int N;
    static List<String> list;

    static String removeZero(String input){
        int idx = 0;

        while(idx < input.length() - 1 && input.charAt(idx) == '0'){
            idx++;
        }

        return input.substring(idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < input.length(); j++){
                char c = input.charAt(j);

                if(c >= '0' && c <= '9'){
                    sb.append(c);
                } else{
                    if(sb.length() > 0){
                        list.add((removeZero(sb.toString())));
                        sb = new StringBuilder();
                    }
                }
            }

            if(sb.length() > 0){
                list.add((removeZero(sb.toString())));
            }
        }

        list.sort((o1, o2) ->{
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}