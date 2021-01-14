package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호목록 {
    public static void main(String[] args) {
        String[] phone_book={"119", "97674223", "1195524421"};

        Arrays.sort(phone_book);

        boolean can = true;
        Trie trie = new Trie();
        for (int i=0;i<phone_book.length;i++){
            can = trie.insert(phone_book[i]);
            if (!can)break;
        }
        System.out.println(can);
    }
    static class Node{
        HashMap<Character,Node> childNodes = new HashMap<>();
        boolean isFinish =false;
    }
    static class Trie{
        private Node root = new Node();

        boolean insert(String word){
            Node now = root;

            for (int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if (now.childNodes.containsKey(c)){
                    now = now.childNodes.get(c);
                    if (now.isFinish)return false;
                }else{
                    now.childNodes.put(c,new Node());
                    now = now.childNodes.get(c);
                }
            }
            now.isFinish = true;
            return true;
        }
    }
}
