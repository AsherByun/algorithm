package algo;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo1339_1 {
	static int n;
	static ArrayList a=new ArrayList();
	static String[] map;
	static int max=0;
	static int m;
	static ArrayList res=new ArrayList();
	static boolean visit[]=new boolean[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		int sc[]=new int[50];
		boolean alpa[]=new boolean[50];
		map=new String[n];
		for(int i=0;i<n;i++) {
			map[i]=br.readLine();
			char in[]=map[i].toCharArray();
			int k=1;
			for(int j=in.length-1;j>=0;j--) {
				if(!alpa[in[j]-'0']) {
					a.add(in[j]);alpa[in[j]-'0']=true;
				}
				sc[in[j]-'0']+=1*((int)Math.pow(10, k));
//				System.out.println(sc[in[j]-'0']);
				k++;
			}
		}
		ArrayList ta=new ArrayList();
		for(int i=0;i<a.size();i++) {
			if(alpa[(char)a.get(i)-'0']) {
				ta.add(sc[(char)a.get(i)-'0']);
			}
		}
		Collections.sort(ta);
		HashMap h=new HashMap();
		int num=9;
		
		for(int i=0;i<ta.size();i++) {
//			System.out.println(ta.get(i));
		}
		boolean tb[]=new boolean[50];
		for(int i=ta.size()-1;i>=0;i--) {
			int temp=(int)ta.get(i);
			for(int j=0;j<a.size();j++) {
				if(sc[(char)a.get(j)-'0']==temp&&!tb[(char)a.get(j)-'0']) {
					h.put((char)a.get(j), num);tb[(char)a.get(j)-'0']=true;
					num--;
				}
			}
		}
		
		
		int tmap[]=new int[n];
		String smap[]=new String[n];
		Arrays.fill(smap, "");
		int tot=0;
		for(int i=0;i<map.length;i++) {
			char[] ts=map[i].toCharArray();
			for(int j=0;j<ts.length;j++) {
				smap[i]+=h.get(ts[j]);
			}
			tot+=Integer.parseInt(smap[i]);
		}
		
		
		System.out.println(tot);
		
		
	}
	
}
