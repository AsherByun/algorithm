package 알고리즘.그래프;

public class 유니온파인드 {
    private static int[] parent = new int[100001]; // 부모를 저장하는 변수배열 초기화시 모두 parent[i]=i로 해야함

    public static int find(int x){
        if (x==parent[x]){
            return x;       // 현재의 부모가 현재값과 같다면 이번 x가 루트
        }else{
            return parent[x]=find(parent[x]);       // 현재의 부모를 업데이트 해줘야한다
        }
    }

    public static void union(int x, int y){
        x=find(x);
        y=find(y);

        // 더작은값으로 루트를 지정시
        if (x<y) parent[y] = x;
        else parent[x] = y;
    }

    public static boolean isSameParent(int x,int y){
        x=find(x);
        y=find(y);
        return x==y;
    }
}
