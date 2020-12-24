package 알고리즘문제해결전략.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리뒤집기_algospot_QUADTREE {
    static String[] str;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc=0;tc<testc;tc++){
            str = br.readLine().split("");
            idx=0;
            String ans = reverse();
            sb.append(ans+"\n");
        }
        System.out.print(sb.toString());
    }
    static String reverse(){
        String now = str[idx];
        if (now.equals("w")||now.equals("b"))return now;

        idx++;
        String leftup = reverse();
        idx++;
        String rightup =reverse();
        idx++;
        String leftdown = reverse();
        idx++;
        String rightdown = reverse();

        return "x"+leftdown+rightdown+leftup+rightup;
    }
}
/*
    idx를 전역변수로사용하는게 중요!
    뒤집기는 재귀적으로 다음 함수에게 보냄,
    기저 상태 체크 x가아니면 그냥 그 값을 리턴해주면되는거
 */