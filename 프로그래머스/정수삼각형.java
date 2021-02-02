package 프로그래머스;

public class 정수삼각형 {
    public static void main(String[] args) {
        int[][] tri = {{7},{3, 8},{8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}};
        int[][] dp = new int[500][500];
        int max = 0;
        dp[0][0] = tri[0][0];
        for (int i=0;i<tri.length-1;i++){
            for (int j=0;j<tri[i].length;j++){
                dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j]+tri[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j]+tri[i+1][j+1]);
                max = Math.max(max,Math.max(dp[i+1][j],dp[i+1][j+1]));
            }
        }
        System.out.println(max);
    }
}
