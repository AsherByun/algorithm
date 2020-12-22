package 프로그래머스;
import java.util.*;
public class 챌린지2_3 {
    public static void main(String[] args) {
        int n=5;
        int[][] edges={{1,5},{2,5},{3,5},{4,5}};
        boolean visit[]=new boolean[n+1];
        ArrayList<Integer> link[]=new ArrayList[n+1];
        for (int i=0;i<=n;i++)link[i]=new ArrayList<>();
        int start=0;
        for (int i=0;i<edges.length;i++){
            link[edges[i][0]].add(edges[i][1]);
            link[edges[i][1]].add(edges[i][0]);
        }
        for (int i=1;i<=n;i++){
            if (link[i].size()==1){
                start=i;break;
            }
        }
        int map[]=new int[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        int cost=0;
        while (!q.isEmpty()){
            Queue<Integer> tempq=new LinkedList<>();
            while (!q.isEmpty()){
                tempq.add(q.poll());
            }
            while (!tempq.isEmpty()){
                int now=tempq.poll();
                map[now]=cost;
                visit[now]=true;
                for (int i=0;i<link[now].size();i++){
                    if (!visit[link[now].get(i)]){
                        q.offer(link[now].get(i));
                    }
                }
            }
            cost++;
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i=0;i<=n;i++){
            arr.add(map[i]);
        }
        Collections.sort(arr);
        int rest=arr.get(arr.size()-1)+arr.get(arr.size()-2)+arr.get(arr.size()-3);
        rest=rest/3;
        System.out.println(rest);
    }
}
