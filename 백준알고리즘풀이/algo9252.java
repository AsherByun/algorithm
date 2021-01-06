package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class algo9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for (int i=1;i<=s1.length();i++){
            char c1=s1.charAt(i-1);
            for (int j=1;j<=s2.length();j++){
                char c2=s2.charAt(j-1);
                if (c1==c2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int row =s1.length();
        int col =s2.length();

        Stack<Character> stack = new Stack<>();

        while (row>=1&&col>=1){
            char c1 = s1.charAt(row-1);
            char c2 = s2.charAt(col-1);

            if (c1==c2){
                stack.push(c1);
                row--;col--;
                continue;
            }
            if (dp[row][col-1]<=dp[row-1][col]){
                row--;
            }else
                col--;
        }
        System.out.println(dp[s1.length()][s2.length()]);
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
/*
    뒤에서부터 경로를 되집어 올라오는방식으로 해결
 */