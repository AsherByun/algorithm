package 백준;

import java.util.Scanner;

public class algo1212 {
    static String map[] ={"000","001","010","011","100","101","110","111"};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] oc = scan.nextLine().split("");
        String rs = "";

        for (int i=0;i<oc.length;i++){
            int now = Integer.parseInt(oc[i]);
            rs += map[now];
        }
        if (rs.charAt(0)=='0')rs = rs.substring(1);
        System.out.println(rs);
    }
}
