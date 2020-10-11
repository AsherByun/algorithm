package algo;
import java.util.*;
public class algo1931 {
	static ArrayList save=new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();

		int map[][]=new int[n][2];
		
		for(int i=0;i<n;i++) {
			
			map[i][0]=scan.nextInt();
			map[i][1]=scan.nextInt();
	
		}
		
		Arrays.sort(map,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				else {
				return o1[1]-o2[1];
				}
			}
		
		});
		int end=-1;
		int count=0;
		
		for(int i=0;i<n;i++) {
			if(map[i][0]>=end) {
				end=map[i][1];
				count++;
			}
			
			
		}
		
		
		System.out.println(count);
		
		
	}

}
class time{
	int st;
	int end;
	time(int st,int end){
		this.st=st;
		this.end=end;
	}
	
}