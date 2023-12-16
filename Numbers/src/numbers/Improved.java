package numbers;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Improved {
    private static final int MAX_VALUE = 12;
    private static final int OPERATOR_COUNT = 4;

    public static void main(String[] args) {
        ThreadLocalRandom generator = ThreadLocalRandom.current();
        Scanner input = new Scanner(System.in);

        int num1;
        int num2;
        int sign;
        double result = 0;
        double ans;
        char theSign = '+';

        while (true) {
            num1 = generator.nextInt(1, MAX_VALUE + 1);
            num2 = generator.nextInt(1, MAX_VALUE + 1);
            sign = generator.nextInt(OPERATOR_COUNT);

            switch (sign) {
                case 0:
                    theSign = '+';
                    result = num1 + num2;
                    break;
                case 1:
                    theSign = '-';
                    result = (num1 >= num2) ? num1 - num2 : num2 - num1;
                    break;
                case 2:
                    theSign = '/';
                    while (num2 == 0 || num1 % num2 != 0) {
                        num1 = generator.nextInt(1, MAX_VALUE + 1);
                        num2 = generator.nextInt(1, MAX_VALUE + 1);
                    }
                    result = (double) num1 / num2;
                    break;
                case 3:
                    theSign = '*';
                    result = num1 * num2;
                    break;
            }

            System.out.println(num1 + "" + theSign + "" + num2);
            ans = input.nextDouble();

            if (ans == result) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
                break;
            }
        }
    }
}
