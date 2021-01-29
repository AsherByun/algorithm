package 알고리즘.그래프;

public class 플로이드_와샬 {
    static public int[][] 플로이드와샬(int distance[][],int n){
        // 0~ n-1
        for (int k=0;k<n;k++){      //k를 지나는 것
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    distance[i][j] = Math.max(distance[i][k]+distance[k][i],distance[i][j]);
                }
            }
        }
        return distance;
    }
}
