package 프로그래머스;

import java.util.PriorityQueue;
//파라메트릭 서치
public class 선입선출스케줄링 {
    public static void main(String[] args) {
        int n=6;
        int[] cores = {1,2,3};

        int coreMax = cores[0];
        int coreMin = cores[0];
        for (int i=0;i<cores.length;i++){
            coreMax=Math.max(coreMax,cores[i]);
            coreMin=Math.min(coreMin,cores[i]);
        }
        int midtime;
        int mintime=(coreMin*n)/cores.length - coreMin;
        int maxtime=(coreMax*n)/cores.length - coreMax;

        while (mintime<=maxtime){
            midtime=(mintime+maxtime)/2;
            int workDone = cores.length;
            int currentWork = 0;
            for (int core: cores){
                workDone+=(midtime/core);
                if (midtime%core==0)currentWork++;
            }
            if (n>workDone){
                mintime = midtime + 1;
            }else if (n<=workDone-currentWork){
                maxtime = midtime-1;
            }else{
                int count =0 ;
                for (int i=0;i<cores.length;i++){
                    if ((midtime%cores[i]==0))count++;
                    if (count==n-(workDone-currentWork)){
                        System.out.println(i+1);
                        return;
                    }
                }
            }

        }

    }

}
