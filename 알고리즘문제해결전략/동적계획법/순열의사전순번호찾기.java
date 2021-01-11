package 알고리즘문제해결전략.동적계획법;
//페이지 317 문제해결전략1
public class 순열의사전순번호찾기 {
    static int factorials[]=new int[12];
    public static void main(String[] args) {
        factorials[0]=1;
        for (int i=1;i<factorials.length;i++){
            factorials[i]=factorials[i-1]*i;
        }
        System.out.print(getIndex(new int[]{1,2,4,3}));

    }
    static int getIndex(int[] map){
        int idx=1;

        for (int i=0;i<map.length;i++){
            int less=0;
            for (int j=i+1;j<map.length;j++){
                if (map[i]>map[j])less++;
            }
            idx+=factorials[map.length-i-1]*less;
        }
        return idx;
    }
}
