package nhn2020;

import java.util.HashMap;
import java.util.HashSet;

public class nhn2 {
    public static void main(String[] args) {
        int numOfAllPlayers =17;
        int numOfQuickPlayers = 5;
        char[] namesOfQuickPlayers ={'B','D','I','M','P'};
        int numOfGames = 11;
        int[] numOfMovesPerGame = {3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23};


        HashMap<Character,Integer> hash=new HashMap<>();
        HashSet<Character> fast=new HashSet();
        hash.put('A',1);
        char[] map=new char[numOfAllPlayers-1];
        for(int i=0;i<numOfAllPlayers-1;i++){
            map[i]= (char) (66+i);
        }

        for (int i=0;i<numOfQuickPlayers;i++)fast.add(namesOfQuickPlayers[i]);

        char nowTurn='A';
        int nowGoal=0;
        for (int tc=0;tc<numOfGames;tc++){
            nowGoal+=numOfMovesPerGame[tc];

            if (nowGoal>=numOfAllPlayers-1) {
                int cnt = nowGoal / (numOfAllPlayers - 1);
                nowGoal = nowGoal - (numOfAllPlayers - 1) * cnt;
            }
            if (nowGoal<0){
                int cnt = Math.abs(nowGoal)/(numOfAllPlayers-1);
                if (Math.abs(nowGoal)%(numOfAllPlayers-1)==0){
                    nowGoal=0;
                }else{
                    nowGoal=nowGoal+(cnt+1)*(numOfAllPlayers-1);
                }
            }

//            while (nowGoal<0)nowGoal+=numOfAllPlayers-1;
//            while (nowGoal>=numOfAllPlayers-1)nowGoal-=numOfAllPlayers-1;

            char target=map[nowGoal];
            if(!fast.contains(target)){
                if (hash.containsKey(target)){
                    hash.put(target,hash.get(target)+1);
                }else{
                    hash.put(target,1);
                }
                char temp=map[nowGoal];
                map[nowGoal]=nowTurn;
                nowTurn=temp;
            }else{
                hash.put(nowTurn,hash.get(nowTurn)+1);
            }
        }
        for (int i=0;i<numOfAllPlayers-1;i++){
            if (hash.get(map[i])==null)System.out.println(map[i]+" "+0);
            else System.out.println(map[i]+" "+hash.get(map[i]));
        }System.out.println(nowTurn+" "+hash.get(nowTurn));

    }
    static class Member{
        char name;
        Member next,prev;
        Member(char name,Member next,Member prev){
            this.name=name;
            this.next=next;
            this.prev=prev;
        }
    }
}
