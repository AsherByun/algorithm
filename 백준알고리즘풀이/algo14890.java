package algo;
import java.util.*;
public class algo14890 {
	static int n;
	static int l;
	static ArrayList res =new ArrayList();
	static int count=0;
	static int map[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		l=scan.nextInt();
		map=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		//가로
		for(int i=1;i<=n;i++) {
			int[] tmap = new int[n+1];
			tmap=map[i];
			find(tmap,i);
		}
		//세로
		for(int i=1;i<=n;i++) {
			int[] tmap = new int[n+1];
			for(int j=1;j<=n;j++) {
				tmap[j]=map[j][i];
			}
			find(tmap,i);
		}
		System.out.println(count);
	}

	static void find(int[] tmap,int x) {
		int now = tmap[1];
		boolean clean=true;
		boolean visit[]= new boolean[n+1];
		visit[0]=true;
		for(int i=2;i<=n;i++) {
			if(Math.abs(now-tmap[i])>1) {
				clean=false;
				break;
			}else {
				if(now>tmap[i]) {
					now=tmap[i];
					for(int j=i;j<i+l;j++) {
						if(j>n) {clean=false;break;}
						else {
						if(visit[j]||now!=tmap[j]||j>n) {
							clean=false;break;
						}
						visit[j]=true;
						}
					}
				}
				else if(now<tmap[i]) {
					for(int j=i-1;j>=i-l;j--) {
						if(visit[j]||now!=tmap[j]||j<=0) {
							clean=false;break;
						}
						visit[j]=true;
					}
					now=tmap[i];
				}
			}
		
	}
	if(clean) {count++;}
  }
}