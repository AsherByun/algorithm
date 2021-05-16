package 알고리즘;

public class 이진트리만들기 {
    static Node head;
    public static void main(String[] args) {

        int[] arr= {5,7,1,3,4,9,6,2};
        head = null;
        for (int i:arr){
//            if (head==null){
//                head=new Node(i);
//                continue;
//            }
            insert2(i);
        }
        inorder(head);
    }
    public static void inorder(Node node){
        if (node==null)return;

        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }
    public static void insert(Node now,Node node){
        if (now.val<node.val){
            if (now.right==null){
                now.right=node;
                return;
            }else{
                insert(now.right,node);
            }
        }else{
            if (now.left==null){
                now.left=node;
                return;
            }else{
                insert(now.left,node);
            }
        }
    }
    public static void insert2(int val){
        Node node = new Node(val);

        if (head==null){
            head=node;
            return;
        }

        Node now = head;
        Node last = null;

        while (true){
            last=now;

            if (now.val<val){
                if (now.right==null){
                    now.right=node;
                    return;
                }else{
                    now=now.right;
                }
            }else{
                if (now.left==null){
                    now.left=node;
                    return;
                }else{
                    now=now.left;
                }
            }
        }

    }
    static class Node{
        int val;
        Node left,right;

        Node(int val){
            this.val=val;
        }
    }
}
