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

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            while(a<b){
                int temp = arr[a-1];
                arr[a-1] = arr[b-1];
                arr[b-1] = temp;
                a++;
                b--;
            }

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
