package javastudy;
import java.util.*;
public class trie_study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TrieNode{
	
	private Map<Character,TrieNode>childNodes=new HashMap<>();
	
	private boolean isLastChar;
	
	//getter,setter
	Map getchildNodes() {
		return this.childNodes;
	}
	
	boolean isLastChar() {
		return isLastChar;
	}
	
	void setisLastChar(boolean isLastChar) {
		this.isLastChar=isLastChar;
	}
}

class Trie{
	
	private TrieNode rootNode;
	
	Trie(){
		rootNode=new TrieNode();
	}
	
	void insert(String word) {
		TrieNode thisNode = this.rootNode;
		
		for(int i=0;i<word.length();i++) {
			thisNode=(TrieNode) thisNode.getchildNodes().computeIfAbsent(word.charAt(i),c->new TrieNode());
		}
		thisNode.setisLastChar(true);
	}
	
}
