package algo;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;
public class algo11725_2{
	
	static boolean[] visit;
	static int n;
	static node[] nd;
	static HashMap h = new HashMap();
	static HashMap ch = new HashMap();
	static HashMap rh = new HashMap();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		h=new HashMap();
		ch=new HashMap();
		rh=new HashMap();
		Scanner scan = new Scanner(System.in);
		n= scan.nextInt();
		visit=new boolean[n+1];
		nd = new node[n+1];
		for(int i=1;i<=n;i++) {
			nd[i]=new node();
		}
		
		for(int i=1;i<n;i++) {
			int par=scan.nextInt();
			int son=scan.nextInt();
			nd[par].add(son);
			nd[son].add(son);
		}
		find(1);
		for(int i=2;i<=n;i++) {
			System.out.println(h.get(i));
		}
	}
		
		static void find(int st) {
			visit[st]=true;
			for(int i=1;i<=n;i++) {
				if(nd[st].arr.get(i)!=null&&!visit[i]) {
					h.put(i,st);
					find(i);
				}
				
				
			}
			
			
		}

}
