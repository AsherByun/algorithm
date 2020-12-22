package 알고리즘문제해결전략;

import java.util.Scanner;

public class 순환소수찾기_비둘기집원리 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        int iter = 0;

        while (a>0){
            if (iter++ == 1)System.out.print(".");
            System.out.print(a/b);
            a = (a%b)*10;
        }

    }
}
