import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i<N; i++){
            A[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int count = 0;
        for (int k : A) {
            if(k == x){
                count++;
            }
        }
        System.out.println(count);


    }
}

