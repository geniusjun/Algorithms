import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[31];

        for (int i = 0; i < 28; i++) {
            int index = sc.nextInt();
            A[index]++;
        }
        for (int i = 1; i < 31; i++) {
            if (A[i] != 1) {
                System.out.println(i);
            }

        }
    }
}

