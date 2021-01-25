package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;

public class 순위검색 {
    static final HashMap<String,Integer> idx = new HashMap<>(){
        {
            put("java",0);put("python",1);put("cpp",2);
            put("backend",0);put("frontend",1);
            put("junior",0);put("senior",1);
            put("pizza",0);put("chicken",1);
        }
    };

    static int idxs[][] = {{0,1,2},{0,1},{0,1},{0,1}};
    static int[][][][][] map;
    public static void main(String[] args) {
        String[] info ={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query={"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        map = new int[3][2][2][2][100001];


        for (int i=0;i<info.length;i++){
            String str[] = info[i].split(" ");
            int a = idx.get(str[0]);
            int b = idx.get(str[1]);
            int c = idx.get(str[2]);
            int d = idx.get(str[3]);
            int score = Integer.parseInt(str[4]);
            map[a][b][c][d][score]++;
        }
        for (int i=0;i<=2;i++){
            for (int j=0;j<=1;j++){
                for (int k=0;k<=1;k++){
                    for (int l=0;l<=1;l++){
                        int sum=0;
                        for (int s=100000;s>=1;s--){
                            sum+=map[i][j][k][l][s];
                            map[i][j][k][l][s]=sum;
                        }
                    }
                }
            }
        }
        int ans[] = new int[query.length];
        for (int i=0;i<query.length;i++){
            String str[] = query[i].split(" and ");
            ArrayList<String> arr = new ArrayList<>();
            String sps[] = str[3].split(" ");
            arr.add(str[0]);arr.add(str[1]);arr.add(str[2]);arr.add(sps[0]);arr.add(sps[1]);

            ans[i] = find(arr,new int[4],0);
        }
    }
    static int find(ArrayList<String> str,int nums[],int index){
        if (index==4){
            return map[nums[0]][nums[1]][nums[2]][nums[3]][Integer.parseInt(str.get(4))];
        }
        int sum=0;
        if (str.get(index).equals("-")){
            for (int i=0;i<idxs[index].length;i++){
                nums[index]=i;
                sum += find(str,nums,index+1);
            }
        }else{
            nums[index] = idx.get(str.get(index));
            sum += find(str,nums,index+1);
        }
        return sum;
    }
}
/*
    노가다 + 쿼리 최적화 -> 미리 점수를 맨위에서부터 맨아래로 가면서 점수를 누적시킨다 (~점수 이상 => 바로 배열의 값으로 접근가능)
 */