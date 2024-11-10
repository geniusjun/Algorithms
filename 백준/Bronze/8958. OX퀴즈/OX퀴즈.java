import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            int count = 0;
            int sum = 0;
            char[] arr = sc.nextLine().toCharArray();
            for (int j=0; j<arr.length; j++){
                if(arr[j] == 'O') {
                    count += 1;
                    sum += count;
                } else if(arr[j] == 'X'){
                    count = 0;
                }
            }
            System.out.println(sum);
        }

    }
}