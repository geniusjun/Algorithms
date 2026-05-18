import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호 발음하기 {

    static boolean isOkay(String line){
        boolean isSatis = false;
        // 모음 체크
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (isMo(c)) {
                isSatis = true;
                break;
            }
        }

        // 모음 3개 or 자음 3개 연속으로 오는 체크
        int moCnt = 0;
        int jaCnt = 0;
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            if(isMo(c)){
                if(jaCnt == 0){
                    moCnt++;
                } else{
                    moCnt++;
                    jaCnt = 0;
                }
            } else{
                if(moCnt == 0){
                    jaCnt++;
                } else{
                    jaCnt++;
                    moCnt = 0;
                }
            }
            if(jaCnt >= 3 || moCnt >= 3){
                isSatis = false;
                break;
            }
        }
        // 같은 글자 연속으로 두개 오는지 체크
        for(int i = 0; i < line.length() - 1; i++){
            char c = line.charAt(i);
            if(c == line.charAt(i+1) && (c != 'e' && c != 'o')){
                isSatis = false;
                break;
            }
        }

        return isSatis;
    }

    static boolean isMo(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String word = br.readLine();
            if(word.equals("end")){
                break;
            }

            if(isOkay(word)){
                System.out.println("<" + word + ">" + " is acceptable.");
            } else{
                System.out.println("<" + word + ">" + " is not acceptable.");
            }
        }
    }
}