import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt(); // 수학 총 페이지
        int C = sc.nextInt();
        int D = sc.nextInt(); // 수학 일일 최대

        int kor;
        int math;

        if(A%C == 0){
            kor = A/C;
        } else{
            kor = A/C + 1;
        }

        if(B%D == 0){
            math = B/D;
        } else{
            math = B/D + 1;
        }

        if(kor>= math){
            System.out.println(L - kor);
        } else {
            System.out.println(L - math);
        }


    }
}

