package 백준;

import java.math.BigInteger;
import java.util.Scanner;

public class algo1188 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        BigInteger a=BigInteger.valueOf(n);
        BigInteger b=BigInteger.valueOf(m);

        int ans = m - a.gcd(b).intValue();
        System.out.println(ans);
    }
}
