package 알고리즘.그래프;

import java.util.PriorityQueue;

public class 크루스칼 {
    static int[] parent;

    public static void main(String[] args) {
        int n=6;
        int[][] w=new int[n+1][n+1];
        w[3][6] = 1;w[3][4] = 1;w[2][3] = 4;w[3][1] = 3;w[1][2] = 2;w[2][4] = 5;w[2][5] = 3;
        System.out.println(크루스칼(w,n));
    }
    static public int 크루스칼(int[][] weight,int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i=1;i<=n;i++){ //실제로 받을때는 이렇게안하고 연결된것만 찾아서 만들어줌
            for (int j=1;j<=n;j++){
                if (weight[i][j]!=0){
                    pq.offer(new Node(i,j,weight[i][j]));
                }
            }
        }
        int sum=0;
        parent=new int[n+1];
        for (int i=1;i<=n;i++)parent[i]=i;
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if (isSameParent(now.s,now.e))continue;

            sum+= now.cost;
            union(now.s,now.e);
        }
        return sum;
    }
    static class Node implements Comparable<Node>{
        int s,e,cost;

        Node(int s,int e,int cost){
            this.s=s;
            this.e=e;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return (this.cost<o.cost)?-1:1;
        }
    }
    public static int find(int x){
        if (x==parent[x]){
            return x;       // 현재의 부모가 현재값과 같다면 이번 x가 루트
        }else{
            return parent[x]=find(parent[x]);       // 현재의 부모를 업데이트 해줘야한다
        }
    }

    public static void union(int x, int y){
        x=find(x);
        y=find(y);

        // 더작은값으로 루트를 지정시
        if (x<y) parent[y] = x;
        else parent[x] = y;
    }

    public static boolean isSameParent(int x,int y){
        x=find(x);
        y=find(y);
        return x==y;
    }
}
