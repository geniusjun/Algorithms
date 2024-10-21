import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        while (true){
            String input = sc.nextLine();
            if(input.equals("#")) break;
            char[] charArray = input.toCharArray();
            int count = 0;
            for(int i = 0; i< charArray.length; i++){
                if(charArray[i] == 'a' || charArray[i] == 'A'|| charArray[i] == 'e'|| charArray[i] == 'E'
                        || charArray[i] == 'i'|| charArray[i] == 'I'|| charArray[i] == 'o' || charArray[i] == 'O'
                        || charArray[i] == 'u' || charArray[i] == 'U')
                {
                    count++;
                }
                }
            System.out.println(count);
        }

    }
}

