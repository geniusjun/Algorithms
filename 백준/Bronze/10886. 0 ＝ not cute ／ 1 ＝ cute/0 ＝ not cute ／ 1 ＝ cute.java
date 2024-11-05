import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cute = 0;
        int noCute = 0;

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            if(a == 0){
                noCute++;
            } else if(a == 1){
                cute++;
            }
        }
        System.out.println((cute<noCute) ? "Junhee is not cute!" : "Junhee is cute!");
    }
}

