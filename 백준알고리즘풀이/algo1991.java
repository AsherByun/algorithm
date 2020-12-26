package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class algo1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node nodes[]=new Node[n];

        for (int i=0;i<n;i++){
            nodes[i] = new Node((char)('A'+i));
        }

        for (int i=0;i<n;i++){
            String str[] = br.readLine().split(" ");
            char now = str[0].charAt(0);
            char leftval = str[1].charAt(0);
            char rightval = str[2].charAt(0);
            if (leftval!='.')
                nodes[now-'A'].left = nodes[leftval-'A'];
            if (rightval!='.')
                nodes[now-'A'].right = nodes[rightval-'A'];
        }
        preOrder(nodes[0]);System.out.println();
        midOrder(nodes[0]);System.out.println();
        postOrder(nodes[0]);

    }
    static void preOrder(Node next){
        if (next==null)return;
        System.out.print(next.val);
        preOrder(next.left);
        preOrder(next.right);
    }
    static void midOrder(Node next){
        if (next==null)return;
        midOrder(next.left);
        System.out.print(next.val);
        midOrder(next.right);
    }
    static void postOrder(Node next){
        if (next==null)return;
        postOrder(next.left);
        postOrder(next.right);
        System.out.print(next.val);
    }

    static class Node{
        Node left,right;
        char val;
        Node(char val){
            this.val=val;
        }
    }
}
