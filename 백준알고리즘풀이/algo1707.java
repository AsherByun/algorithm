package algo;
import java.util.*;
public class algo1707 {

	static int n,m;
	//static anode node[];
	static boolean visit[];
	static boolean can;
	static int red=1,blue=2;
	static ArrayList node[];
	static ArrayList link;
	static int color[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		ArrayList res=new ArrayList();
		int testc=scan.nextInt();
		
		
		for(int i=0;i<testc;i++) {
			link=new ArrayList();
			n=scan.nextInt();
			m=scan.nextInt();
			node=new ArrayList[n+1];
			color=new int[n+1];
			Arrays.fill(color, -1);
			for(int j=1;j<=n;j++) {
				node[j]=new ArrayList();
			}
			
			
			for(int j=0;j<m;j++) {
				int s=scan.nextInt();
				int e=scan.nextInt();
				
				node[s].add(e);
				node[e].add(s);
			}
			visit=new boolean[n+1];
			can=true;
			Stack<Integer> s=new <Integer>Stack();
			s.push(1);
			visit[1]=true;
			find(s,1);
			
			if(can) {
				res.add("YES");
			}else res.add("NO");
			
		}
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
		
	}
	
	
	static void find(Stack<Integer> s,int c) {
		int cl=c%2;  //0일때는 red 1일때 blue
		int num=s.size();
		while(num>0) {
			
			int t=(int) s.pop();
			//visit[t]=true;
			
			if(color[t]==-1) {
				color[t]=cl;
			}
			else if(color[t]!=cl) {
				can=false;return;
			}
			
				for(int i=0;i<node[t].size();i++) {
					int temp=(int)node[t].get(i);
					if(!visit[temp]) {
						visit[temp]=true;
					s.push(temp);
					}
				}
				
				
				num--;
			}
		find(s,c+1);
			
			
		for(int i=1;i<=n;i++) {
			System.out.printf("%d ",color[i]);
			
		}System.out.println("");
		
		
		
		
	}

}
class anode{
	ArrayList p=new ArrayList();
	int col=-1;
		anode(){}
}