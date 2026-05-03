import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            arr[input.charAt(0) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++){
            if(arr[i] >= 5){
                sb.append((char)(i + 'a'));
            }
        }

        if(sb.isEmpty()){
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }
    }
}
