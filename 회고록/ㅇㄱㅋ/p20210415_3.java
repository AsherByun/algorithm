package 월간코;

import java.util.*;

public class p20210415_3 {
    static Node[] nodes;
    static Queue<Integer> last;
    static long res;
    static int start;
    public static void main(String[] args) {
       int[] a= {-5,0,2,1,2};
       int[][] edges = {{0,1},{3,4},{2,3},{0,3}};

       int sum=Arrays.stream(a).sum();
       if(sum!=0){
            System.out.println(-1);
       }
        nodes=new Node[a.length];
        last=new LinkedList<>();

       for(int i=0;i<a.length;i++){
           nodes[i]=new Node(a[i],i);
       }
       for (int i=0;i<edges.length;i++){
           int s=edges[i][0];
           int e=edges[i][1];
            nodes[s].arr.add(e);
            nodes[e].arr.add(s);
       }

       for (int i=0;i<nodes.length;i++){
           if (nodes[i].arr.size()==1){
               last.add(i);
           }
       }
        boolean[] visit=new boolean[a.length];
        res=0;
        start=1;
        visit[1]=true;
        find(1,visit);
        System.out.println(res);

        for (int i=0;i<nodes.length;i++){
            System.out.println(nodes[i].val);
        }

//       while (!last.isEmpty()){
//           Node now = nodes[last.poll()];
//           if (visit[now.idx])continue;
//           visit[now.idx]=true;
//
//           for (int i=0;i<now.arr.size();i++){
//               int next = now.arr.get(i);
//               if (visit[next])continue;
//               if(now.val>0){
//                   nodes[next].val+=now.val;
//                   res+=now.val;
//               }else if (now.val<0){
//                   nodes[next].val+=now.val;
//                   res-=now.val;
//               }
//               now.val=0;
//               last.offer(next);
//           }
//
//       }
    }
    static long find(int now,boolean[] visit){
        if(nodes[now].arr.size()==1&&now!=start){
            long temp=nodes[now].val;
            nodes[now].val=0;
            return temp;
        }else{
            long temp=0;

            for (int i=0;i<nodes[now].arr.size();i++){
                int next=nodes[now].arr.get(i);
                if (visit[next])continue;
                visit[next]=true;
                long l=find(next,visit);
                if (l>0)res+=l;
                else res-=l;
                temp+=l;
            }
            temp += nodes[now].val;
            nodes[now].val=0;
            return temp;
        }
    }

    static class Node{
        long val;
        int idx;
        List<Integer> arr;
        Node(long val,int idx){
            this.idx=idx;
            this.val=val;
            this.arr=new ArrayList<>();
        }
    }
}
