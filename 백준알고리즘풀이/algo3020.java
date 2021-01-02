package algo;
import java.util.*;
import java.io.*;
public class algo3020 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		int l=Integer.parseInt(in[0]);
		int h=Integer.parseInt(in[1]);
		
		int hmap[]=new int[h+1];
		
		for(int i=1;i<=l;i++) {
				int t=Integer.parseInt(br.readLine());
			if(i%2==1) {
				for(int j=1;j<=t;j++)hmap[j]++;
				
			}else {
				for(int j=h;j>h-t;j--)hmap[j]++;	
			}
		}
		for(int i=1;i<=h;i++)System.out.println(hmap[i]);
		
		int min=Integer.MAX_VALUE-1;
		int num=0;
		for(int i=1;i<=h;i++) {
			if(hmap[i]<min) {
				min=hmap[i];num=i;
			}
		}
		
		System.out.println(min+" "+num);
		
	}

}
