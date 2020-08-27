package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1068 {
	static node1 node[];
	static int n;
	static int c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		String in[]=br.readLine().split(" ");
		
		int tar=Integer.parseInt(br.readLine());
		node=new node1[n];

		for(int i=0;i<n;i++) {
			node[i]=new node1();
		}
		
		int root=0;
		for(int i=0;i<n;i++) {
			int temp=Integer.parseInt(in[i]);
			if(temp!=-1) {
				node[i].parent=temp;
				node[temp].son.add(i);
			}else {
				root=i;
			}
		}
		
		int kill=node[tar].parent;
		node[kill].son.remove((Integer)tar);
		node[tar].son=new ArrayList();
		if(node[root].son.size()==0) {
			if(tar==root) {c=0;}
			else c=1;
		}else {
		
		for(int i=0;i<node[root].son.size();i++) {
			int t=(int)node[root].son.get(i);
			find(t);
		}
		}
		
		System.out.println(c);
		
	}

	static void find(int t) {
		
		if(node[t].son.size()==0) {
			c++;
		}
			else {
		for(int i=0;i<node[t].son.size();i++) {
			int l=(int)node[t].son.get(i);
			find(l);
			}
		}
	}
}

class node1{
	
	int parent=0;
	ArrayList son = new ArrayList();
	node1(){
		
	}

}