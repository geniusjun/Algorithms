import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        int sum = 0;
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            sum += charArr[i] - '0';
        }
        System.out.println(sum);

    }
}