package 코테복기;

public class back11062 {
    static int[][][] dp;
    public static void main(String[] args) {
        int n = 9;
        int[] arr = {1,1,1,1,2,2,2,2,2};

        dp=new int[n][n][2];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
            }
        }
        System.out.println(find(0,n-1,0,arr));
    }
    static int find(int left,int right,int turn,int[] arr){
        if (left>right)return 0;
        if (dp[left][right][turn]!=-1)return dp[left][right][turn];

        if (turn==0){
            return dp[left][right][0] = Math.max(arr[left]+find(left+1,right,1,arr)
                    ,arr[right]+find(left,right-1,1,arr));
        }else {
            dp[left][right][1]=Math.min(find(left+1,right,0,arr),find(left,right-1,0,arr));
            return dp[left][right][turn];
        }

    }
}
