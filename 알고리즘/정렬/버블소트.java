package 알고리즘.정렬;
// https://github.com/GimunLee/tech-refrigerator/blob/master/Algorithm/%EC%84%A0%ED%83%9D%20%EC%A0%95%EB%A0%AC%20(Selection%20Sort).md
public class 버블소트 {

    public static void main(String[] args) {
        int list[]=new int[]{5,1,6,7,3,2,11,4,9,8,10};

        for (int i=list.length-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if (list[j]>list[j+1]){
                    int temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
        for (int i=0;i<list.length;i++){
            System.out.printf("%d ",list[i]);
        }
    }
}
