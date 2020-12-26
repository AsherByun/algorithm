package 알고리즘.정렬;

import java.util.Arrays;

public class 선택정렬 {
    public static void main(String[] args) {
        int list[]=new int[]{5,1,6,7,3,2,11,4,9,8,10};
        for (int i=0;i<list.length-1;i++){
            int minIndex=i;
            for (int j=i+1;j<list.length;j++){
                if (list[j]<list[minIndex]){
                    minIndex=j;
                }
            }
            int temp=list[minIndex];
            list[minIndex]=list[i];
            list[i]=temp;
        }
        System.out.println(Arrays.toString(list));
    }
}
