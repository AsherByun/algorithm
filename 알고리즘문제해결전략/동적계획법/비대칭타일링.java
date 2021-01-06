package 알고리즘문제해결전략.동적계획법;

public class 비대칭타일링 {
    static int dp[];
    public static void main(String[] args) {
        dp=new int[101];
        System.out.println(tilling(4));
        System.out.println(asymmetric(4));
    }
    static int asymmetric(int width){
        if (width%2==1){
            return (tilling(width) - tilling(width/2)) % 1000000007;
        }
        return (tilling(width)-tilling(width/2-1)-tilling(width/2)) % 1000000007;
    }
    static int tilling(int width){
        if (width==1){
            return 1;
        }
        if (width==2){
            return 2;
        }
        if (dp[width]!=0)return dp[width];

        return dp[width] = tilling(width-1)+tilling(width-2);
    }
}
