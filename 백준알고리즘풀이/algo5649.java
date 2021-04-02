package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class algo5649 {
    static ArrayList<Integer> map;
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        Node rootNode = new Node(Integer.parseInt(br.readLine()));

        String str="";
        while ((str=br.readLine())!=null&& str.length()!=0){
            Node node = new Node(Integer.parseInt(str));
            push(rootNode,node);
        }
        find(rootNode);
        System.out.println(sb);
    }
    static void find(Node node){
        if (node.left!=null){
            find(node.left);
        }
        if (node.right!=null){
            find(node.right);
        }
        sb.append(node.val+"\n");
    }
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    static void push(Node now,Node insertNode){
        if (now.val>insertNode.val){
            if (now.left==null)now.left=insertNode;
            else push(now.left,insertNode);
        }else{
            if (now.right==null)now.right=insertNode;
            else push(now.right,insertNode);
        }

    }
}
