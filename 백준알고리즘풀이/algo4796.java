package 백준;

import java.util.Scanner;

public class algo4796 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int s = 1;
        StringBuilder sb=new StringBuilder();
        while (true){
            int l=scan.nextInt();
            int p=scan.nextInt();
            int v=scan.nextInt();

            if (l==0&&p==0&&v==0){
                break;
            }
            int opt = (v%p)>l?l:v%p;
            int res = (v/p)*l + opt;
            sb.append("Case "+s+": "+res+"\n");
            s++;
        }
        System.out.print(sb.toString());
    }
}
