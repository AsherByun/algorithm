package nhn2020;

public class nhn1 {
    public static void main(String[] args) {
        int day=2;
        int width=6;
        int [][] blocks={{6,2,11,0,3,5},{6,3,0,9,0,5}};


        int[] map=new int[width];
        int total=0;
        int temp[]=new int[width];
        for (int tc=0;tc<day;tc++) {

            for (int i=0;i<width;i++){
                map[i]+=blocks[tc][i];
            }

            int dp[] = new int[width];
            int max = 0;
            for (int i=1;i<width;i++){
                max=Math.max(max,map[i-1]);
                dp[i]=max;
            }
            max=0;
            temp=new int[101];
            for (int i=width-2;i>=0;i--){
                max=Math.max(max,map[i+1]);
                int gap=Math.min(max,dp[i])-map[i];
                if (gap>0){
                    total+=gap;
                    temp[i]=gap;
                }
            }
            for (int i=0;i<width;i++){
                map[i]+=temp[i];
            }
        }
        System.out.println(total);
    }
}
