package 백준;

import java.util.*;

public class algo12904 {
    static boolean isF;
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        StringBuilder tar = new StringBuilder(scan.nextLine());

        while (s.length()!=tar.length()){
            if (tar.charAt(tar.length()-1)=='A'){
                tar.deleteCharAt(tar.length()-1);
            }else{
                tar.deleteCharAt(tar.length()-1);
                tar.reverse();
            }
        }
        if (s.equals(tar.toString())){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
