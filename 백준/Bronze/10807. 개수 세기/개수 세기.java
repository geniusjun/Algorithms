import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A[] = new int[201];
        int N = sc.nextInt();

        for(int i = 0; i<N; i++){
            int index = sc.nextInt();
            A[index+100]++;
        }
        int x = sc.nextInt();
        System.out.println(A[x+100]);
    }
}
