package 프로그래머스;
import java.util.*;
public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        Stack<Integer> bucket = new Stack<>();
        Stack<Integer>[] map = makeMap(board);

        int ans = move(map,moves,bucket);

        System.out.print(ans);
    }
    static int move(Stack<Integer>[] map, int[] moves,Stack<Integer> bucket){
        int cnt=0;
        for (int i=0;i<moves.length;i++){
            if (map[moves[i]].isEmpty())continue;
            int output = map[moves[i]].pop();

            if(!bucket.isEmpty()) {
                if (bucket.peek() == output) {
                    bucket.pop();
                    cnt += 2;
                    continue;
                }
            }
            bucket.push(output);

        }
        return cnt;
    }
    static Stack<Integer>[] makeMap(int[][] board){
        Stack<Integer> map[] = new Stack[board[0].length+1];

        for (int i=0;i<=board[0].length;i++){
            map[i] = new Stack<>();
        }

        for (int i=board.length-1;i>=0;i--){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j] == 0)continue;
                map[j+1].push(board[i][j]);
            }
        }

        return map;
    }
}
