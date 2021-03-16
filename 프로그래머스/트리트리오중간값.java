package 프로그래머스;

import java.util.ArrayList;

public class 트리트리오중간값 {
    static ArrayList<Integer>[] arr;
    static int[] dist;
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,5},{2,5},{3,5},{4,5}};

        arr=new ArrayList[n+1];
        for (int i=0;i<=n;i++)arr[i]=new ArrayList<>();

        for (int i=0;i<edges.length;i++){
            int s=edges[i][0];
            int e=edges[i][1];
            arr[s].add(e);
            arr[e].add(s);
        }
        dist=new int[n+1];
        boolean[] visit = new boolean[n+1];
        visit[1]=true;
        find(0,1,visit);

        int f=1;int flen=0;
        for (int i=1;i<=n;i++){
            if(flen<dist[i]){
                f=i;flen=dist[i];
            }
        }
        dist=new int[n+1];
        visit = new boolean[n+1];
        visit[f]=true;
        find(0,f,visit);
        int s=0;int slen=0;
        for (int i=1;i<=n;i++){
            if (slen<dist[i]){
                s=i;slen=dist[i];
            }
        }
        dist=new int[n+1];
        visit=new boolean[n+1];
        visit[s]=true;visit[f]=true;
        find(0,s,visit);
        int l=0;int llen=0;
        for (int i=1;i<=n;i++){
            if (llen<dist[i]){
                llen=dist[i];
                l=i;
            }
        }

        System.out.println(llen);
    }
    static void find(int len,int idx,boolean[] visit){
        dist[idx]=len;
        for (int i=0;i<arr[idx].size();i++){
            int next = arr[idx].get(i);
            if (visit[next])continue;
            visit[next]=true;
            find(len+1,next,visit);
        }
    }
}
