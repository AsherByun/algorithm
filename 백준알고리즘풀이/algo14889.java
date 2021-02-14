package algo;
import java.util.*;
public class algo14889 {
	static int n;
	static int limit;
	static int[][] map;
	static boolean[] visit;
	static ArrayList res ;
	static ArrayList temp = new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		visit=new boolean[n+1];
		map=new int[n+1][n+1];
		limit=n/2;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j]=scan.nextInt();	
			}
		}
		int min=9999;
		int count=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i!=j) {
					res=new ArrayList();
					find(i,j);
					
					System.out.println(count++);
					for(int k=0;k<res.size()/2;k=k+2) {
						System.out.println(res.get(k)+""+res.get(k+1));
						}
					
					
					int result=0;
					for(int k=0;k<res.size()/2;k=k+2) {
						result=result-(int)res.get(k)+(int)res.get(k+1);
					}
					result=Math.abs(result);
					temp.add(result);
					
					for(int k=1;k<=n;k++) {
						visit[k]=false;
					}
					
					
				}
				
				
			}
		}
		
		
		
		Collections.sort(temp);
		
		for(int i=0;i<temp.size();i++) {
		// System.out.println(temp.get(i));
		}
		
		
	}
	
	static void find(int x,int y) {
		
		visit[x]=true;
		visit[y]=true;
		res.add(x);
		res.add(y);
		
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if((i!=j)&&!visit[i]&&!visit[j]) {
					find(i,j);
				}
				
			}
		}
		
		
		}
		
	}
	
	
	
	
	


