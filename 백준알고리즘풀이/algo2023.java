package 백준;

import java.util.Scanner;

public class algo2023 {
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();

        find(0,0);
    }
    static void find(int num,int c){

        if (!isPrim(num)){
            return;
        }
        if (c==n&&leng(num)==n){
            System.out.println(num);
            return;
        }else if (c==n){
            return;
        }
        for (int i=0;i<=9;i++){
            if (i==0&&c==0)continue;
            find(num*10+i,c+1);
        }

    }
    static int leng(int num){
        return (int)Math.log10(num)+1;
    }

    static boolean isPrim(int num){
        if (num==1)return false;
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i==0)return false;
        }
        return true;
    }
}
