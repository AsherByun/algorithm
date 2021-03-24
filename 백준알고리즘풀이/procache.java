package algo;
import java.util.*;
public class procache {
	static int cacheSize=3;
	static String[] cities= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList cache=new ArrayList();
		int tot=0;
		for(int i=0;i<cities.length;i++) {
			String temp=cities[i].toUpperCase();
			
			if(cache.contains(temp)) {
				tot+=1;
				int idx=cache.indexOf(temp);
				cache.remove(idx);
				cache.add(temp);
				
			}else {
				tot+=5;
				if(cacheSize==0) {
					
				}
				else if(cache.size()==cacheSize) {
					cache.remove(0);
					cache.add(temp);
				}else {
					cache.add(temp);
				}
				
				
			}
			
			
			
		}
		System.out.println("asdfasdf".toUpperCase());
		System.out.println(tot);
		
	}

}
