package 프로그래머스;

import java.util.ArrayList;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] days = new int[speeds.length];
        for (int i=0;i<progress.length;i++){
            int remain = 100-progress[i];
            if (remain%speeds[i]>0){
                days[i] = remain/speeds[i] +1;
            }else{
                days[i] = remain/speeds[i];
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int c=0;int day=0;
        while (c<days.length){
            day = days[c];
            int total=1;c++;
            while (c<days.length){
                if (days[c]>day)break;
                total++;c++;
            }
            arr.add(total);
        }
        int[] ans = new int[arr.size()];
        for (int i=0;i<arr.size();i++){
            ans[i] = arr.get(i);
        }
    }
}
