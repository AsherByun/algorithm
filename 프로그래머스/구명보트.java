package 프로그래머스;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        int[] people = {30,40,50,70};
        int limit = 100;

        int ans =0;

        Arrays.sort(people);
        boolean[] visit = new boolean[people.length];

        int left =0; int right=visit.length-1;

        while (left<right) {
            int p = limit - people[left];
            if (!visit[left]) {
                while (people[right] > p) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                ans++;
                visit[left]=true;
                visit[right]=true;

                left++;
                right--;
            }
        }
        for (int i=0;i<visit.length;i++){
            if (!visit[i])ans++;
        }
        System.out.println(ans);
    }
}
