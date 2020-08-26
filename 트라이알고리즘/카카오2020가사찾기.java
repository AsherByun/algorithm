package kakao;
import java.util.*;
public class kakao_blind_recru_2020_searching_word {
	static String[] words= {"frodo", "front", "frost", "frozen", "frame", "kakao"};
	static String[] queries= {"fro??", "????o", "fr???", "fro???", "pro?"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trie backtri=new trie();
		trie fronttri=new trie();
		for(int i=0;i<words.length;i++) {
			String temp=words[i].trim();
			fronttri.insert(temp);
			backtri.insert(new StringBuffer(temp).reverse().toString());
		}
		int answer[] = new int[queries.length];
		for(int i=0;i<queries.length;i++) {
			fronttri.can=0;
			backtri.can=0;
			if(queries[i].charAt(0)=='?') {
				//back
				backtri.find(new StringBuffer(queries[i]).reverse().toString(),0,backtri.rootNode);
				answer[i]=backtri.can;
			}else {
				//front
				fronttri.find(queries[i],0,fronttri.rootNode);
				answer[i]=fronttri.can;
			}
			System.out.println(answer[i]);
		}
//		for(int i=0;i<answer.length;i++)System.out.println(answer[i]);
		
	}
	
}
class trieNode{
	private Map<Character,trieNode> childNodes=new HashMap<>();
	private boolean islastNode;
	Map<Integer,Integer> down=new HashMap<>();
	
	Map getchildNodes() {
		return this.childNodes;
	}
	boolean islastNode() {
		return this.islastNode;
	}
	void setislastNode(boolean islastNode) {
		this.islastNode=islastNode;
	}
}
class trie{
	trieNode rootNode;
	int can=0;
	trie(){
		rootNode=new trieNode();
	}
	void insert(String word) {
		trieNode thisNode=rootNode;
		
		for(int i=0;i<word.length();i++) {
			thisNode=(trieNode)thisNode.getchildNodes().computeIfAbsent(word.charAt(i), c->new trieNode());
			int len=word.length()-i-1;
			if(thisNode.down.containsKey(len)) {
				int temp=thisNode.down.get(len);
				thisNode.down.put(len,temp+1);
			}else {
				thisNode.down.put(len, 1);
			}
		}
		thisNode.setislastNode(true);
	}
	
	void find(String word,int idx,trieNode tnode) {
		if(tnode.islastNode()&&word.length()==idx) {
			can++;return;
		}else if(word.length()>idx) {
		char tc=word.charAt(idx);
		
		if(tc=='?') {
			if(tnode.down.containsKey(word.length()-idx))
			can+=(int)tnode.down.get(word.length()-idx);
			return;
		}else {
			HashMap tmap=(HashMap)tnode.getchildNodes();
			if(tmap.containsKey(tc)) {
			trieNode nextnode=(trieNode)tmap.get(tc);
			find(word,idx+1,nextnode);
			}
		}
		}
	}
	
}
// 앞뒤로 순회할수 있게 앞뒤로 만듬
