import java.io.*;
import java.util.*;
public class brand2_3 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str[]=br.readLine().split(" ");
    	int n=Integer.parseInt(str[0]);
    	int k=Integer.parseInt(str[1]);
    	int map[]=new int[n+1];

    	StringBuilder sb=new StringBuilder();
    	
    	str=br.readLine().split(" ");
    	for(int i=1;i<=n;i++) {
    		map[i]=Integer.parseInt(str[i-1]);
    	}
    	
    	for(int tc=1;tc<=k;tc++) {
    		str=br.readLine().split(" ");
    		int s=Integer.parseInt(str[0]);
    		int e=Integer.parseInt(str[1]);
    		int sum=0;
    		HashMap h=new HashMap<Integer,Integer>();
    		
    		for(int i=s;i<=e;i++) {
    			
    			if(!h.containsKey(map[i])) {
    				h.put(map[i], 1);
    			}else {
    				int temp=(int)h.get(map[i])+1;
    				h.put(map[i], temp);
    			}
    			
    		}
    		Set<Integer> key=h.keySet();
			for(int a:key) {
				int t=(int)h.get(a);
				sum+=(t*(t+1)/2)*a;
			}
    		sb.append(sum+"\n");
    	}
    	System.out.println(sb);
    	
    }
}
