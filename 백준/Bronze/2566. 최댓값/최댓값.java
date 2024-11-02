import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[9][9];
        int v = 0;
        int h = 0;
        int max = arr[0][0];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
                if(max<= arr[i][j]){
                    max = arr[i][j];
                    v = j+1;
                    h = i+1;
                }
            }
            System.out.println();
        }
        System.out.println(max);
        System.out.println(h + " " + v);


    }
}



