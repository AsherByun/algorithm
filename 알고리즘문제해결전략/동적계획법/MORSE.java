package 알고리즘문제해결전략.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MORSE {
    static int skip;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testc=Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc=0;tc<testc;tc++){
            String[] str = br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int m=Integer.parseInt(str[1]);
            int k=Integer.parseInt(str[2]);
            skip=k-1;


        }

    }
}
