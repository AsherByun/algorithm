import java.io.*;
import java.util.*;
public class brand2_4 {
	static int n;
	static ArrayList map[];
	static ArrayList road[];
	static boolean can=true;
	static ArrayList line; 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n=Integer.parseInt(br.readLine());
    	map=new ArrayList[n+1];
    	StringBuilder sb=new StringBuilder();
    	road=new ArrayList[n+1];
    	for(int i=1;i<=n;i++) {
    		map[i]=new ArrayList();
    		road[i]=new ArrayList();
    	}
    	
    	for(int i=0;i<n;i++) {
    		String str[]=br.readLine().split(" ");
    		int a=Integer.parseInt(str[0]);
    		int b=Integer.parseInt(str[1]);
    		map[a].add(b);
    		map[b].add(a);
    	}
    	for(int i=1;i<=n;i++) {
    		Collections.sort(map[i]);
    	}
    	int k=Integer.parseInt(br.readLine());
    	for(int tc=1;tc<=k;tc++) {
    		String str[]=br.readLine().split(" ");
    		int a=Integer.parseInt(str[0]);
    		int b=Integer.parseInt(str[1]);
    		if(a>b){
    			int te=a;
    			a=b;
    			b=te;
    		}
    		
    		boolean visit[]=new boolean[n+1];
    		line = new ArrayList();
    		visit[a]=true;
    		for(int i=0;i<map[a].size();i++) {
    			int next=(int) map[a].get(i);
    				ArrayList arr=new ArrayList();
    				arr.add(a);
    				visit[next]=true;
    				arr.add(next);
    				find(next,a,b,visit,arr);
        			visit[next]=false;
    		}
    		
    		ArrayList res=(ArrayList) line.get(0);
    		
    		if(res.size()>1) {
    			int next=(int)res.get(1);
    			change(next,a,1,res);
    		}
    		int sum=0;
    		for(int i=1;i<=n;i++) {
    			sum+=road[i].size();
    		}
    		int result=n-(sum/2);
    		
    		sb.append(result+"\n");
    		
    	}
    	System.out.println(sb);
    }
    static void change(int now,int last,int c,ArrayList arr) {
    	
    	
    	if(road[last].contains(now)) {
    		road[last].remove((Integer)now);
    		road[now].remove((Integer)last);
    	}else {
    		road[last].add(now);
    		road[now].add(last);
    	}
    	if(c+1<arr.size()) {
    		int next =(int)arr.get(c+1);
    		change(next,now,c+1,arr);
    	}

    }
    
    
    static void find(int now,int last,int tar,boolean visit[],ArrayList arr) {
    	
    	if(now==tar) {
    		if(line.size()>0) {
    			ArrayList temp=(ArrayList)line.get(0);
    			if(temp.size()>arr.size()) {
    				line.remove(0);line.add(arr);
    			}else if(temp.size()<arr.size()) {
    				
    			}else {
    				
    			}
    		}else {
    			line.add(arr);
    		}
    	}
    	
    	for(int i=0;i<map[now].size();i++) {
    		int next=(int)map[now].get(i);
    		if(!visit[next]) {
    			ArrayList tarr=(ArrayList) arr.clone();
    			visit[next]=true;
    			tarr.add(next);
    			find(next,now,tar,visit,tarr);
    			visit[next]=false;
    		}
    	}
    	
    	
    }
}


    
    
