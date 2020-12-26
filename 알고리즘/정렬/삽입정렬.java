package 알고리즘.정렬;

import java.util.Arrays;

public class 삽입정렬 {
    public static void main(String[] args) {
        int list[]=new int[]{5,1,6,7,3,2,11,4,9,8,10};
        for (int i=1;i<list.length;i++){
            int temp=list[i];
            int prev=i-1;
            while (prev>=0&&(list[prev]>temp)){
                list[prev+1]=list[prev];
                prev--;
            }
            list[prev+1]=temp;
        }
        System.out.println(Arrays.toString(list));
    }
}
