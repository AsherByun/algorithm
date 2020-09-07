package kakao;
/*
  1. 투포인터를 사용 모든 문자를 set에 넣음
  2. 앞에서부터 큐에 넣으면서 맨앞자리 문자가 현재 2개이상이라면 빼주고 startpoint를 올림
  3. 모든문자가 있고(셋과 맵 사이즈비교) 큐의길이가 최소길이보다 작다면 시작지점과 길이를 바꿔준다.
*/
import java.util.*;
import java.awt.*;
public class kakao2020_3 {
	static String[] gems= {"XYZ", "XYZ", "XYZ"};
	static HashSet set=new HashSet();
	static HashMap h=new HashMap();
	static int start=0;
	static int startpoint=0;
	static int length=Integer.MAX_VALUE;
	static Queue q=new LinkedList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String s:gems) {
			set.add(s);
		}
		
		for(int i=0;i<gems.length;i++) {
			String str=gems[i];
			if(!h.containsKey(str)) {
				h.put(str,1);
			}else {
				h.put(str, (int)h.get(str)+1);
			}
			
			q.add(str);
			
			while(true) {
				str=(String)q.peek();
				if((int)h.get(str)>1) {
					q.poll();
					startpoint++;
					h.put(str, (int)h.get(str)-1);
				}else {
					break;
				}
			}
			if(h.size()==set.size()&&length>q.size()) {
				start=startpoint;
				length=q.size();
			}
		}
		System.out.println(start+1+" "+(start+length));
		
	}
	static boolean allin(HashSet a, HashSet b) {
		return (a.size()==b.size())?true:false;
	}
}
