package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class algo2250 {
    static Node[] nodes;
    static int n;
    static int level;
    static int col;
    static ArrayList<Node>[] levelNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        nodes=new Node[n+1];
        for (int i=1;i<=n;i++)nodes[i]=new Node(i);

        for (int i=1;i<=n;i++){
            String[] str=br.readLine().split(" ");
            int s=Integer.parseInt(str[0]);
            int e1=Integer.parseInt(str[1]);
            int e2=Integer.parseInt(str[2]);

            if (e1!=-1) {
                nodes[s].childs.add(nodes[e1]);
                nodes[e1].parent = nodes[s];
                nodes[s].left=nodes[e1];
            }
            if (e2!=-1) {
                nodes[s].right=nodes[e2];
                nodes[e2].parent = nodes[s];
                nodes[s].childs.add(nodes[e2]);
            }
        }
        int rootIdx=0;
        for (int i=1;i<=n;i++)if (nodes[i].parent==null)rootIdx=i;
        findLevel(rootIdx);
        col=1;
        findCol(nodes[rootIdx]);

        int max=0;
        int maxidx=0;
        for (int i=1;i<=level;i++){
            int a=levelNode[i].get(0).x;
            int b=levelNode[i].get(levelNode[i].size()-1).x;
            int temp=b-a+1;
            if (temp>max){
                max=temp;
                maxidx=i;
            }
        }
        System.out.println(maxidx+" "+max);
    }
    static void findCol(Node node){

        if (node.left!=null){
            findCol(node.left);
        }
        node.x=col++;
        if (node.right!=null){
            findCol(node.right);
        }

    }
    static void findLevel(int rootIdx){
        level=0;
        levelNode=new ArrayList[10001];
        Queue<Node> q=new LinkedList<>();
        q.offer(nodes[rootIdx]);

        while (!q.isEmpty()){
            level++;
            levelNode[level]=new ArrayList<>();

            int size=q.size();
            for (int i=0;i<size;i++){
                Node node=q.poll();
                node.y=level;
                levelNode[level].add(node);
                for (int j=0;j<node.childs.size();j++){
                    q.offer(node.childs.get(j));
                }
            }
            Collections.sort(levelNode[level]);
        }

    }
    static class Node implements Comparable<Node>{
        int idx;
        int x,y;
        ArrayList<Node> childs=new ArrayList<>();
        Node left;
        Node right;
        Node parent;
        Node(int idx){
            this.idx=idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.x<o.x?-1:1;
        }
    }
}
