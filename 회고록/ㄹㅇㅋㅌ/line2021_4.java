package 라인코테;
import java.util.*;
import java.awt.*;
public class line2021_4 {
    static int card[];
    static boolean winner;
    static int getmoney=0;
    static boolean isblackjack=false;
    public static void main(String[] args) {
        int cards[]={12, 7, 11, 6, 2, 12};
        card=cards;
        int i=0;
        int k=cards.length;
            while (true) {
                isblackjack=false;
              try {
                  player player = new player();
                  dealer dealer = new dealer();

                  player.adding(card[i++]);
                  dealer.adding(card[i++]);
                  player.adding(card[i++]);
                  dealer.adding(card[i]);
                  dealer.open = card[i++];


                  if (player.max == 21) isblackjack = true;

                  if (isblackjack) {
                      if (dealer.max != 21) {
                          getmoney += 3;
                      }
                  }else if (dealer.max==21){
                        getmoney-=2;
                  }else if (dealer.open == 1 || dealer.open >= 7) {
                      while (player.max <= 17 && player.finish) {
                          player.adding(card[i++]);
                      }
                      if (!player.finish) getmoney += -2;
                      else {
                          while (dealer.max <= 17 && dealer.finish) {
                              dealer.adding(card[i++]);
                          }
                          if (!dealer.finish) getmoney += 2;
                          else {
                              if (player.max > dealer.max) getmoney += 2;
                              else if (player.max < dealer.max) getmoney += -2;
                              else getmoney += 0;
                          }
                      }
                  } else if (dealer.open == 4 || dealer.open == 5 || dealer.open == 6) {
                      while (dealer.max <= 17 && dealer.finish) {
                          dealer.adding(card[i++]);
                      }
                      if (!dealer.finish) getmoney += 2;
                      else {
                          if (player.max > dealer.max) getmoney += 2;
                          else if (player.max < dealer.max) getmoney += -2;
                          else getmoney = 0;
                      }
                  } else if (dealer.open == 2 || dealer.open == 3) {
                      while (player.max <= 12 && player.finish) {
                          player.adding(card[i++]);
                      }
                      if (!player.finish) getmoney += -2;
                      else {
                          while (dealer.max <= 17 && dealer.finish) {
                              dealer.adding(card[i++]);
                          }
                          if (!dealer.finish) getmoney += 2;
                          else {
                              if (player.max > dealer.max) getmoney += 2;
                              else if (player.max < dealer.max) getmoney += -2;
                              else getmoney += 0;
                          }
                      }
                  }
              }catch (Exception e){
                  break;
              }
            }
    System.out.println(getmoney);

    }
}
class player{
    ArrayList<Integer> sum=new ArrayList<>();
    player(){
        sum=new ArrayList<>();
        sum.add(0);
    }
    int max=0;
    boolean finish=true;
    void adding(int n){
        ArrayList<Integer> arr=new ArrayList();
        if(n>10){
            for (int i=0;i<sum.size();i++){
                int tsum=sum.get(i);
                if (tsum+10<=21) {
                    arr.add(tsum + 10);
                    max=Math.max(tsum+10,max);
                }
            }
            sum= (ArrayList<Integer>) arr.clone();
        }else if(n==1){
            for (int i=0;i<sum.size();i++){
                int tsum=sum.get(i);
                if (tsum+1<=21) {
                    arr.add(tsum+1);
                    max=Math.max(tsum+1,max);
                }
                if (tsum+11<=21){
                    arr.add(tsum+11);
                    max=Math.max(tsum+11,max);
                }
            }
            sum= (ArrayList<Integer>) arr.clone();
        }else{
            for (int i=0;i<sum.size();i++){
                int tsum=sum.get(i);
                if (tsum+n<=21){
                    arr.add(tsum+n);
                    max=Math.max(tsum+10,n);
                }
            }
            sum= (ArrayList<Integer>) arr.clone();
        }
        finish=finish();
    }
    boolean finish(){
        for (int i=0;i<sum.size();i++){
            if(sum.get(i)<=21)return true;
        }
        return false;
    }
}


class dealer{
    ArrayList<Integer> sum=new ArrayList<>();
    int max=0;
    int open=0;
    dealer(){
        sum=new ArrayList<>();
        sum.add(0);
        max=0;
    }
    boolean finish=true;
    void adding(int n){
        ArrayList<Integer> arr=new ArrayList();
        if(n>10){
            for (int i=0;i<sum.size();i++){
                int tsum=sum.get(i);
                if (tsum+10<=21) {
                    arr.add(tsum + 10);
                    max=Math.max(tsum+10,max);
                }
            }
            sum= (ArrayList<Integer>) arr.clone();
        }else if(n==1){
            for (int i=0;i<sum.size();i++){
                int tsum=sum.get(i);
                if (tsum+1<=21) {
                    arr.add(tsum+1);
                    max=Math.max(tsum+1,max);
                }
                if (tsum+11<=21){
                    arr.add(tsum+11);
                    max=Math.max(tsum+11,max);
                }
            }
            sum= (ArrayList<Integer>) arr.clone();
        }else{
            for (int i=0;i<sum.size();i++){
                int tsum=sum.get(i);
                if (tsum+n<=21){
                    arr.add(tsum+n);
                    max=Math.max(tsum+n,max);
                }
            }
            sum= (ArrayList<Integer>) arr.clone();
        }
        finish=finish();
    }
    boolean finish(){
        for (int i=0;i<sum.size();i++){
            if(sum.get(i)<=21)return true;
        }
        return false;
    }
}