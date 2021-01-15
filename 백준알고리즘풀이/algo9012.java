package algo;
import java.util.*;
import java.io.*;
public class algo9012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		ArrayList res=new ArrayList();
		
		for(int tc=0;tc<n;tc++) {
			int r=0;
			char map[]=br.readLine().toCharArray();
			boolean can=true;
			for(int i=0;i<map.length;i++) {
				if(map[i]=='(') {
					r++;
				}else {
					r--;
					if(r<0) {
						can=false;break;
					}
				}
			}
			if(r!=0)can=false;

			if(can)res.add("YES");
			else res.add("NO");
			
		}
		for(int i=0;i<res.size();i++)System.out.println(res.get(i));
	}

}
