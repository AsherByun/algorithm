package 프로그래머스;

public class 쿠키구입 {
    public static void main(String[] args) {
        int[] cookie = {1,1,2,3};
        int ans=0;

        for (int i=0;i<cookie.length-1;i++){
            int leftsum=cookie[i];
            int leftidx=i;
            int rightsum=cookie[i+1];
            int rightidx=i+1;

            while (true){
                if (leftsum==rightsum){
                    ans=Math.max(ans,leftsum);
                }
                if (leftsum>=rightsum&&rightidx<cookie.length-1){
                    rightidx++;
                    rightsum+=cookie[rightidx];
                }else if (leftsum<rightsum&&leftidx>0){
                    leftidx--;
                    leftsum+=cookie[leftidx];
                }else{
                    break;
                }
            }

        }
        System.out.println(ans);
    }
}
