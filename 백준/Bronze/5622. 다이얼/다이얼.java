import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            int value = input.charAt(i) - 'A';

            if (value >= 0 && value <= 2) {
                count += 3;
            } else if (value >= 3 && value <= 5) {
                count += 4;
            } else if (value >= 6 && value <= 8) {
                count += 5;
            } else if (value >= 9 && value <= 11) {
                count += 6;
            } else if (value >= 12 && value <= 14) {
                count += 7;
            } else if (value >= 15 && value <= 18) {
                count += 8;
            } else if (value >= 19 && value <= 21) {
                count += 9;
            } else if (value >= 22 && value <= 25) {
                count += 10;
            }

        }
        System.out.println(count);
            }
        }