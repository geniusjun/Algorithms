import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int temp = arr[j-1];
            arr[j-1] = arr[i-1];
            arr[i-1] = temp;
        }

        for (int i = 0; i < N; i++) {
            if(i == N-1){
                System.out.println(arr[N-1]);
                break;
            }
            System.out.print(arr[i]+ " ");
        }
        }
    }
