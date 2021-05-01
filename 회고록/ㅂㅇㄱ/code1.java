package 베이글;
public class code1 {
    static int last=0;
    static int m;
    static boolean visit[][];
    public static void main(String[] args) {
        int n=4;
        m=n;
        int[][] ladder = {{1,0,1},{0,1,0},{0,0,1},{0,0,0},{1,0,0}};
        int ans[] = new int[4];

        for (int i=0;i<n;i++){
            last=0;
            visit=new boolean[ladder.length+1][n];
            visit[0][i]=true;
            find(i,0, ladder.length,ladder);
            ans[i]=last;
        }

    }
    static void find(int x,int y,int len,int[][] ladder){
       if (y == len){
           last = x+1;
           return;
       }

       if(x-1>=0){
           if (ladder[y][x-1]==1&&!visit[y][x-1]){
               visit[y][x-1]=true;
               find(x-1,y,len,ladder);
               return;
           }
       }
       if (x<ladder[0].length){
           if (ladder[y][x]==1&&!visit[y][x+1]){
               visit[y][x+1]=true;
               find(x+1,y,len,ladder);
               return;
           }
       }
       visit[y+1][x]=true;
       find(x,y+1,len,ladder);

    }
}
