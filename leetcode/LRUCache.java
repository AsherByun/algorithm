package leetcode;
/*
 * 1.<key , value> ���� �ؽ��ʻ��
 * 2.�ֱٿ� ���� key ���� ť�� �־���� ���
 * 3.key���� �����־��ٸ� �ؽ����� ���� ��ü�ϰ� ť���� �װ��� �������� �ǵڷ� �־���
 * 4.������ �ʰ�+���� ���� Ű���� ������ �ؽ��ʿ� �־��ְ�, ť���� ���� �տ��ִ� ���� ���ְ� �� Ű���� �ؽ��ʿ��� ����
 */
import java.util.*;
public class LRUCache {
	HashMap map=new HashMap();
	Queue q=new LinkedList();
	int max;
	int nowc=0;
	public LRUCache(int capacity) {
		max=capacity;
	}
    
    public int get(int key) {
    	
    	if(map.containsKey(key)) {
    		q.remove((Integer)key);
        	q.add(key);
    		return (int)map.get(key);
    	}
    	else return -1;
    }
    
    public void put(int key, int value) {
    	if(nowc==max) {
    		if(map.containsKey(key)) {
    			map.put(key, value);
        		q.remove((Integer)key);
        		q.add(key);
    		}else {
    			map.put(key, value);
    			int temp=(int) q.poll();
    			map.remove(temp);
    			q.add(key);
    		}
    	}else {
    		map.put(key, value);
    		q.remove((Integer)key);
    		q.add(key);
    		nowc=q.size();
    	}
//    	System.out.println("���� ����ִ� ũ��:  "+nowc);
    }
}
