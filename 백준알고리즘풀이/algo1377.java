package 백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class algo1377 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        List<Node> map = new ArrayList<>();
        for (int i=0;i<n;i++){
            int temp=scan.nextInt();
            Node node = new Node(temp,i);
            map.add(node);
        }
        Collections.sort(map);

        int max=0;
        for (int i=0;i<map.size();i++){
            Node node = map.get(i);
            System.out.println(node.val);
            max = Math.max(node.idx-i,max);
        }
        System.out.println(max+1);
    }
    static class Node implements Comparable<Node>{
        int val,idx;

        Node(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Node o) {
            return this.val<o.val?-1:1;
        }
    }
}
