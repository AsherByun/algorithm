package algo;
import java.util.*;
public class algo12100 {
	static boolean visit[][];
	static int n,m;
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		int map[][]=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
			map[i][j]=scan.nextInt();
			}
		}
		
		for(int t1=0;t1<4;t1++) {
			for(int t2=0;t2<4;t2++) {
				for(int t3=0;t3<4;t3++) {
					for(int t4=0;t4<4;t4++) {
						for(int t5=0;t5<4;t5++) {
							ArrayList a=new ArrayList();
							int tmap[][]=new int[n+1][n+1];
							for(int i=1;i<=n;i++) {
								for(int j=1;j<=n;j++) {
									tmap[i][j]=map[i][j];
								}
							}
							a.add(t1);a.add(t2);a.add(t3);a.add(t4);a.add(t5);
							find(tmap,a);
						}
					}
				}
			}
		}
		

		System.out.println(max);
		
		
		
	}
	static void find(int[][] map,ArrayList a) {
		
		for(int i=0;i<a.size();i++) {
			int temp=(int)a.get(i);
			map=check(map,temp);
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
			if(max<map[i][j])max=map[i][j];
		}
	}
		
	}
	
	static int[][] check(int[][] map,int d){
		
		if(d==0) {
			for(int j=1;j<=n;j++) {
				int t=1;int tmap[]=new int[n+2];
				for(int i=1;i<=n;i++) {
					if(map[i][j]!=0) {
						tmap[t]=map[i][j];t++;
					}
				}
				for(int i=1;i<=n;i++) {
					if(tmap[i]==tmap[i+1]) {
						tmap[i]=tmap[i]*2;tmap[i+1]=0;
					}
				}
				/*while(true) {
					boolean f=true;
					for(int i=1;i<=t;i++) {
						if(tmap[i-1]==tmap[i]) {
							tmap[i-1]*=2;tmap[i]=0;f=false;
						}else if(tmap[i-1]==0&&i!=1) {
							tmap[i-1]=tmap[i];f=false;
						}
					}
					if(f=true)break;
					
				}*/
				int k=1;
				for(int i=1;i<=n;i++) {
					if(tmap[i]!=0) {
						map[k][j]=tmap[i];k++;
					}
				}
				for(int i=k;i<=n;i++) {
					map[i][j]=0;
				}
				
			}
			
			
		}else if(d==1) {
			for(int i=1;i<=n;i++) {
				int t=n;int tmap[]=new int[n+2];
				for(int j=n;j>=1;j--) {
					if(map[i][j]!=0) {
						tmap[t]=map[i][j];t--;
					}
				}
				for(int j=n;j>=1;j--) {
					if(tmap[j]==tmap[j-1]) {
						tmap[j]*=2;tmap[j-1]=0;
					}
				}
				int k=n;
				for(int j=n;j>=1;j--) {
					if(tmap[j]!=0) {
						map[i][k]=tmap[j];k--;
					}
				}
				for(int j=k;j>=1;j--)map[i][j]=0;
				
				
				/*while(true) {
					boolean f=true;
					for(int j=1;j<=t;j++) {
						if(tmap[j+1]==tmap[j]) {
							tmap[j+1]*=2;tmap[j]=0;f=false;
						}else if(tmap[j+1]==0) {
							tmap[j+1]=tmap[j];f=false;
						}
					}
					if(f=true)break;
					
				}*/
				
			}
		}else if(d==2) {
			for(int j=1;j<=n;j++) {
				int t=n;int tmap[]=new int[n+2];
				for(int i=n;i>=1;i--) {
					if(map[i][j]!=0) {
						tmap[t]=map[i][j];t--;
					}
				}
				for(int i=n;i>=1;i--) {
					if(tmap[i]==tmap[i-1]) {
						tmap[i]=tmap[i]*2;tmap[i-1]=0;
					}
				}
				int k=n;
				for(int i=n;i>=1;i--) {
					if(tmap[i]!=0) {
						map[k][j]=tmap[i];k--;
					}
				}
				for(int i=k;i>=1;i--) {
					map[i][j]=0;
				}
				
			}
			
				/*while(true) {
					boolean f=true;
					for(int i=n;i>=1;i--) {
						if(tmap[i+1]==tmap[i]) {
							tmap[i+1]*=2;tmap[i]=0;f=false;
						}else if(tmap[i+1]==0) {
							tmap[i+1]=tmap[i];f=false;
						}
					}
					if(f=true)break;
					
				}*/
				
			
		}else if(d==3) {
			for(int i=1;i<=n;i++) {
				int t=1;int tmap[]=new int[n+2];
				for(int j=1;j<=n;j++) {
					if(map[i][j]!=0) {
						tmap[t]=map[i][j];t++;
					}
				}
				for(int j=1;j<=n;j++) {
					if(tmap[j]==tmap[j+1]) {
						tmap[j]*=2;tmap[j+1]=0;
					}
				}
				int k=1;
				for(int j=1;j<=n;j++) {
					if(tmap[j]!=0) {
						map[i][k]=tmap[j];k++;
					}
				}
				for(int j=k;j<=n;j++)map[i][j]=0;
				
				
				/*while(true) {
					boolean f=true;
					for(int j=1;j<=t;j++) {
						if(tmap[j-1]==tmap[j]) {
							tmap[j-1]*=2;tmap[j]=0;f=false;
						}else if(tmap[j-1]==0) {
							tmap[j-1]=tmap[j];f=false;
						}
					}
					if(f=true)break;
					
				}*/
				
			}
			
		}
		
		
		
		
		return map;
	}
}
