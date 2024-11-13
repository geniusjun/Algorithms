import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[8];
        String a = "";
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
            a += String.valueOf(arr[i]);
        }
        if(a.equals("12345678")){
            System.out.println("ascending");
        } else if(a.equals("87654321")){
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}