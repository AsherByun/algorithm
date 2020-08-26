package algo;
import java.util.*;
import java.io.*;
public class algo5052 {
		static int n;
		static ArrayList<String> arr;
		static int tc=0;
		static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		tc=Integer.parseInt(br.readLine());
		for(int testc=1;testc<=tc;testc++) {
			arr=new ArrayList();
			n=Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++) {
				String str=br.readLine().trim();
				arr.add(str);
			}
			///////길이순서로 정렬/////////
			Collections.sort(arr, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length()<o2.length())return -1;
					else if(o1.length()>o2.length()) return 1;
					else return 0;
				}
			});
			/////////////////인풋////////////////
			boolean can=true;
			trie tri=new trie();
			for(int i=0;i<arr.size();i++) {
				String str=arr.get(i);
				can=tri.insert(str);
				if(!can) {
					sb.append("NO\n");
					break;
				}
			}
			if(can)sb.append("YES\n");
			
			
		}
	System.out.println(sb);	
	}
	
}
class trieNode{
	private Map<Character,trieNode> childNodes=new HashMap<>();
	private boolean isLastChar;
	
	Map getChildNodes() {
		return this.childNodes;
	}
	boolean isLastChar() {
		return this.isLastChar;
	}
	void setisLastChar(boolean isLastChar) {
		this.isLastChar=isLastChar;
	}
}
class trie{
	private trieNode rootNode;
	trie(){
		rootNode = new trieNode();
	}
	
	boolean insert(String word) {
		trieNode thisNode =this.rootNode;

		for(int i=0;i<word.length();i++) {
			if(thisNode.isLastChar())return false;
			thisNode=(trieNode)thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c->new trieNode());
		}
		thisNode.setisLastChar(true);
		return true;
	}
}
