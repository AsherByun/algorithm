package algo;
import java.util.*;
public class algo2666 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n=scan.nextInt();
		int map[]=new int[n+1];
		int td;
		int op1=scan.nextInt();
		int op2=scan.nextInt();
		int testc=scan.nextInt();
		map[op1]=1;map[op2]=1;
		Queue q = new LinkedList();
		for(int i=1;i<=testc;i++) {
			td=scan.nextInt();
			q.add(td);
		}
		
		int count=0;int dis[][][]=new int[n+1][n+1][n+1];
		while(!q.isEmpty()) {
			int num =(int)q.poll();
			if(dis[][][]!=0)
			if(Math.abs(op1-num)>Math.abs(op2-num)) {
				count=count+Math.abs(op2-num);
				op2=num;dis[op1][op2][num]=Math.abs(op2-num);
				//System.out.println(1);
			}else if(Math.abs(op1-num)<Math.abs(op2-num)) {
				count=count+Math.abs(op1-num);
				op1=num;
				//System.out.println(2);
			}else {
				int temp=(int)q.peek();
				if(Math.abs(op1-temp)>Math.abs(op2-temp)) {
					count=count+Math.abs(op2-num);
					op2=num;	
					//System.out.println(3);
				}else {
					count=count+Math.abs(op1-num);
					op1=num;
					//System.out.println(4);
				}
			}
			
			
		}
		
		System.out.println(count);
		
	}

}
