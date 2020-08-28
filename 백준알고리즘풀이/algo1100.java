package algo;
import java.util.*;
import java.io.*;
public class algo1100 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String map[][]=new String[8][8];
		int tot=0;
		for(int i=0;i<8;i++) {
			String in[]=br.readLine().split("");
			for(int j=0;j<8;j++) {
				map[i][j]=in[j];
				if(i%2==0&&j%2==0&&map[i][j].equals("F"))tot++;
				if(i%2==1&&j%2==1&&map[i][j].equals("F"))tot++;
			}
		}
		System.out.println(tot);
	}

}
