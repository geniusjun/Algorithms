import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int X = A*B*C;
        String s = String.valueOf(X);
        String[] arr1 = s.split("");
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(Integer.parseInt(arr1[i]) == 0){
                arr[0]++;
            }
            for (int j = 1; j < 10; j++) {
                if(Integer.parseInt(arr1[i]) == j && !(Integer.parseInt(arr1[i]) == 0)){
                    arr[j]++;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }


    }
}