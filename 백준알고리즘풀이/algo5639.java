package algo;
import java.util.*;
public class algo5639 {
	
	static int n;
	static int[] num;
	static node[] node;
	
	static HashMap h=new HashMap(); 
	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		Scanner scan = new Scanner(System.in);
 		
 		n=scan.nextInt();
 		node=new node[n];
 		node[0]=new node();
 		int a=scan.nextInt();
		node[0].now=a;	
 		h.put(a,node[0]);
 		for(int i=1;i<n;i++) {
 			node[i] = new node();
 			
 			int temp=scan.nextInt();
 			h.put(temp,node[i]);
 			
 			if(node[0].now>temp){
 			left(temp,node[0].left);
 			}else {
 			right(temp,node[0].right);
 			}
 			
 		}
 		
 		
 		inorder(node[0]);
 		
 		

	}
 	
 	static void left(int t,int a) {
 		
 		if(h.get(a)!=null) {
 			node tn=(node)h.get(a);
 			if(tn.now<t) {
 				right(t,tn.now);
 			}else {left(t,tn.now);}
 		}else {
 			node rn = new node();
 			rn.now=t;
 			rn.prev=a;
 			h.put(t,rn);
 		}
  		

}
	static void right(int t,int a) {
 		
		if(h.get(a)!=null) {
 			node tn=(node)h.get(a);
 			if(tn.now>t) {
 				right(t,tn.now);
 			}else {left(t,tn.now);}
 		}else {
 			node rn = new node();
 			rn.now=t;
 			rn.prev=a;
 			h.put(t,rn);
 		}
	 	
	 	

}
	static void inorder(node root){
        if(root!=null){
            inorder((node)h.get(root.left));
            System.out.print(root.now + " ");
            inorder((node)h.get(root.right));
        }
    }



}


class node {
	static int now=0;
	static int prev=0;
	static int right=0;
	static int left=0;

	node(){
		
	}
	
	
}