package 백준;

import java.util.Scanner;

public class algo1747 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();

        while (true){
            boolean isF=false;
            if (checkPrime(n)){
                if (checkPal(n))isF=true;
            }

            if (isF)break;
            n++;
        }
        System.out.println(n);
    }
    static boolean checkPrime(int num){

        if (num==1)return false;

        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i==0)return false;
        }
        return true;
    }
    static boolean checkPal(int num){
        String s=String.valueOf(num);

        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i))return false;
        }
        return true;
    }
}
