package algo;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class algo9184 {
	static ArrayList res= new ArrayList();
	static int dp[][][] ;
	static int w(int a,int b,int c) {
		if(a<=0||b<=0||c<=0) {
			if(dp[a][b][c]==0) {
				dp[a][b][c]=1;
			}
			return 1;
		}
		else if(a<b&&b<c) {
			if(dp[a][b][c]==0) {
				dp[a][b][c]=w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
			}
			return dp[a][b][c];
		}
		else {
			if(dp[a][b][c]==0) {
				dp[a][b][c]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
			}
			return  dp[a][b][c];
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		boolean qwe=true;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
		while(qwe) {
			String in=br.readLine();
			String str[]=in.split(" ");
			int a=Integer.parseInt(str[0]);
			int b=Integer.parseInt(str[1]);
			int c=Integer.parseInt(str[2]);
			int result=0;
			if(a==-1&&b==-1&&c==-1) {
				qwe=false;
				break;
			}else {
			if(a==b&&b==c) {
				if(a>20||b>20||c>20) {
					dp=new int[21][21][21];
					result=w(20,20,20);
				}else {
					dp=new int[a+1][b+1][c+1];
					result=w(a,b,c);
				}
			}else {
				dp=new int[a+1][b+1][c+1];
				result=w(a,b,c);
			}
			
			String s="w("+a+", "+b+", "+c+") = "+result;
			res.add(s);
			
		}
			}}
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
		
	
	}
	
	

}
