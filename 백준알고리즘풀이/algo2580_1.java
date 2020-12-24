package algo;
import java.util.*;
public class algo2580_1 {
	
	static int[][] map=new int[9][9];
	static boolean[] col1=new boolean[10];
	static boolean[] row1=new boolean[10];
	static ArrayList col=new ArrayList();
	static ArrayList row=new ArrayList();
	static ArrayList<ArrayList<Integer>> box=new ArrayList<ArrayList<Integer>>();
	static Stack savep =new Stack();
	static int fc;
	static int[][] fmap=new int[9][9];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		//i/3 *3 +j/3
		/*for(int i=1;i<=9;i++) {
			//ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j=1;j<=9;j++) {
			
			}
			col.add(col1);
			row.add(row1);
			//box.add(temp);
		}*/
		
		
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				int temp=scan.nextInt();
				map[i][j]=temp;
				  if(temp!=0) {
				col.get(i)[temp]=true;
				row.get(j).remove((Integer)i);
			//	boxing(i,j,temp);
				}
				else if(temp==0) {
					point p=new point(i,j);
					savep.push(p);
				}
				
			}
		}
		fc=savep.size();
		int c=0;
		find(c);
		System.out.println(savep.size());
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.printf("%d", fmap[i][j]);
			}
				System.out.printf("\n");
		}
		
		
	}

	static void find(int c) {
		point p=new point(0,0);
		
		if(c==-1&&savep==null) {
			fmap=map;
			//System.out.println("gogo");
		}
		else {
			if(!savep.isEmpty()) {
			p = (point) savep.pop();
			}
			for(int i=1;i<=9;i++) {
				if(col.get(p.x).get((Integer)i)!=null&&row.get(p.y).get((Integer)i)!=null) {
					col.get(p.x).remove((Integer)i);
					row.get(p.y).remove((Integer)i);
					map[p.x][p.y]=i;
					find(c+1);
					map[p.x][p.y]=0;
					col.get(p.x).add(i);
					row.get(p.y).add(i);
				
				}
				
			}
			savep.push(p);
			
		}
		
		
		
		
		
	}
	
	

	
	
	
	
	
	
	static void boxing(int i,int j,int t) {
		if(i<3&&j<3) {box.get(0).remove((Integer)t);}
		else if(2<i&&i<6&&j<3) {box.get(1).remove((Integer)t);}
		else if(5<i&&i<9&&j<3) {box.get(2).remove((Integer)t);}
		else if(i<3&&2<j&&j<6) {box.get(3).remove((Integer)t);}
		else if(2<i&&i<6&&2<j&&j<6) {box.get(4).remove((Integer)t);}
		else if(5<i&&i<9&&2<j&&j<6) {box.get(5).remove((Integer)t);}
		else if(i<3&&5<j&&j<9) {box.get(6).remove((Integer)t);}
		else if(2<i&&i<6&&5<j&&j<9) {box.get(7).remove((Integer)t);}
		else if(5<i&&i<9&&5<j&&j<9) {box.get(8).remove((Integer)t);}
	}
	
	
	
}


class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}
