package 코테복기;

import java.math.BigInteger;

public class back최대최소 {
    public static void main(String[] args) {
        BigInteger b1=new BigInteger("12");
        BigInteger b2=new BigInteger("9");

        BigInteger gcd=b1.gcd(b2);
        System.out.println(gcd);
        BigInteger temp = b1.divide(gcd);
        System.out.println(b2.multiply(temp));
    }
}
