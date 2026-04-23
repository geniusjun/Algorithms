import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(a + " ");
                a = (a + 1) % 10;
                if(a == 0){
                    a++;
                }
            }
            System.out.println();
        }
        
    }
}