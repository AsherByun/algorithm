package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1058 {
	static int n;
	static int map[][];
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String s=br.readLine();
			for(int j=1;j<=s.length();j++) {
				char temp=s.charAt(j-1);
				if(temp=='Y') {
					map[i][j]=1;
				}
			}
		}
		ArrayList res=new ArrayList();
		for(int i=1;i<=n;i++) {
			visit=new boolean[n+1];
			visit[i]=true;
			int c=0;
			ArrayList tem=new ArrayList();
			for(int j=1;j<=n;j++) {
				if(map[i][j]==1&&!visit[j]&&i!=j) {
					visit[j]=true;
					tem.add(j);
					c++;
				}
			}
			for(int j=0;j<tem.size();j++) {
				int k=(int)tem.get(j);
				c+=find(k);
			}
			res.add(c);
			
		}
		Collections.sort(res);
		
		System.out.println(res.get(res.size()-1));
		
		
		
	}
	static int find(int num) {
		int t=0;
		for(int i=1;i<=n;i++) {
			if(map[num][i]==1&&!visit[i]&&i!=num) {
				t++;visit[i]=true;
			}
			
		}
		
		return t;
		
	}
	

}
