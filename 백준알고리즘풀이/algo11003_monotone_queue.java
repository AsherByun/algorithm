package 백준;

import java.awt.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class algo11003_monotone_queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[] map = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)map[i] = Integer.parseInt(st.nextToken());

        Deque<Point> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<n;i++){
            Point p=new Point(i,map[i]);

            if (deque.isEmpty()){
                deque.offerLast(p);
                sb.append(map[i]+" ");
            }else{
                while (!deque.isEmpty()&&deque.peekFirst().x<i-k+1){
                    deque.pollFirst();
                }
                while (!deque.isEmpty()&&deque.peekLast().y>map[i]){
                    deque.pollLast();
                }
                deque.offerLast(p);
                sb.append(deque.peekFirst().y+" ");
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
