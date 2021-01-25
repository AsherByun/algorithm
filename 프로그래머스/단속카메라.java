package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    public static void main(String[] args) {
        int[][] routes = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1])return -1;
                else if (o1[1]>o2[1])return 1;
                else{
                    return (o1[0]<o2[0])?-1:1;
                }
            }
        });
        int cnt=0;
        boolean[] visit = new boolean[routes.length];
        for (int i=0;i<routes.length;i++){
            if (visit[i])continue;
            cnt++;
            visit[i]=true;
            for (int j=i+1;j<routes.length;j++){
                if (routes[i][1]>=routes[j][0]){
                    visit[j] = true;
                }
            }
        }
        System.out.println(cnt);

    }
}
/*
    문제 풀이 -> 모든 배열을 끝나는 시간으로 정렬한다
    정렬후 앞에서부터 순회 -> 끝나는 시간은 현재 순회 차량보다 나중 -> 현재 끝나는 시간보다 시작시간이 작은시간들은 이차를 선택했을때 자동으로 선택된다
 */
