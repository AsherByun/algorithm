package algo;
import java.util.*;
import java.io.*;
public class algo5046 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		int man=Integer.parseInt(in[0]);
		int tot=Integer.parseInt(in[1]);
		int hot=Integer.parseInt(in[2]);
		int week=Integer.parseInt(in[3]);
		
		int min=Integer.MAX_VALUE-1;
		
		for(int i=0;i<hot;i++) {
			int in1=Integer.parseInt(br.readLine());
			String mony[]=br.readLine().split(" ");
			int tar=in1*man;
			if(tar>tot)continue;
			for(int j=0;j<mony.length;j++) {
				if(Integer.parseInt(mony[j])>=man) {
					if(tar<min)min=tar;
					break;
				}
			}
			
		}
		if(min==Integer.MAX_VALUE-1)System.out.println("stay home");
		else System.out.println(min);
	}

}
