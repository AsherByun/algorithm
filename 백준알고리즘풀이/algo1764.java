package algo;
import java.util.*;
import java.io.*;
public class algo1764 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		int n=Integer.parseInt(in[0]);
		int m=Integer.parseInt(in[1]);
		
		
		HashMap<String,Integer> h=new HashMap<String,Integer>();
		
		for(int i=0;i<n;i++) {
			String name=br.readLine();
			h.put(name,1);
		}
		
		for(int i=0;i<n;i++) {
			String name=br.readLine();
			if(h.containsKey(name)) {
				h.put(name,2);
			}
		}
		
		ArrayList res=new ArrayList();
		
		for(String nam:h.keySet()) {
			if(h.get(nam)>1) {
			res.add(nam);
		}
		}
		Collections.sort(res);
		System.out.println(res.size());
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
	}

}
