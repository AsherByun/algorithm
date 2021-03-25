import java.util.*;
import java.io.*;
public class brand_1 {
	static int map[]=new int[6];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int age=Integer.parseInt(br.readLine());
		int max=220-age;
		
		while(true) {
			double now;
			try {
				now=Double.parseDouble(br.readLine());
			}catch(Exception e) {
				break;
			}
			double res=(double)(now/max)*100;
			if(res<60) map[5]++;
			else if(res>=60&&res<68) map[4]++;
			else if(res>=68&&res<75) map[3]++;
			else if(res>=75&&res<80) map[2]++;
			else if(res>=80&&res<90) map[1]++;
			else if(res>=90) map[0]++;
		}
		
		for(int i=0;i<6;i++)System.out.printf("%d ", map[i]);
	}

}
