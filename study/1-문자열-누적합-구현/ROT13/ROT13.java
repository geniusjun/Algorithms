import java.io.*;

public class ROT13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        // a : 97, A : 65
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // 소문자
            if(c - 0 >= 97 && c - 0 <= 122){
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            } else if(c - 0 >= 65 && c-0 <= 90){ // 대문자
                sb.append((char) ((c + - 'A' + 13) % 26 + 'A'));
            } else{
                sb.append(c);
            }
        }

        System.out.print(sb);
    }
}
