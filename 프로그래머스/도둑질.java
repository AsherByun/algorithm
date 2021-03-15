package 프로그래머스;

public class 도둑질 {
    static int[][] dp;
    public static void main(String[] args) {
        int[] money = {90, 0, 0, 95, 1, 1};
        dp=new int[2][money.length];
        int ans = Math.max(find2(money,0),find2(money,1));
        System.out.println(ans);
    }
    static int find(int idx,int s,int[] money,int m){
        if (idx>m)return 0;
        if (dp[s][idx]!=0)return dp[s][idx];

        dp[s][idx] = Math.max(money[idx]+find(idx+2,s,money,m),
                find(idx+1,s,money,m));
        return dp[s][idx];
    }
    static int find2(int[] money,int s){
        int[] d=new int[money.length];

        if (money.length==3){
            return Math.max(money[0]+money[2],money[1]);
        }
        d[s]=money[s];
        d[s+1]=Math.max(money[s+1],money[s]);
        d[s+2]=Math.max(money[s]+money[s+2],money[s+1]);

        for (int i=s+3;i<money.length-1+s;i++){
            d[i] = Math.max(d[i-2]+money[i],d[i-1]);
        }
        return d[money.length-2+s];
    }
}
