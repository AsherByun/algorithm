package algo;
import java.util.*;
import java.io.*;
public class algo1302 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		HashMap h=new HashMap();
		int max=1;
		for(int i=0;i<n;i++) {
			String in=br.readLine();
			if(h.containsKey(in)) {
				int t=(int)h.get(in);
				t++;h.put(in,t);
				if(t>max)max=t;
			}else {
				h.put(in, 1);
			}
		}
		
		ArrayList a=new ArrayList();
		
		Iterator keys=h.keySet().iterator();
		while(keys.hasNext()) {
			String key=(String) keys.next();
			if((int)h.get(key)==max) {
				a.add(key);
			}
		}
		Collections.sort(a);
		System.out.println(a.get(0));
		
	}

}
