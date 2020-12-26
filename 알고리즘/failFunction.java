package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class failFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String P = br.readLine();
        int F[] =  new int[P.length()];

        F = getFailFunction(P);

        for (int i=0;i<F.length;i++) {
            System.out.printf("%d ",F[i]);
        }

    }
    static int[] getFailFunction(String str) {
        char[] p = str.toCharArray();
        int[] F = new int[str.length()];

        p = str.toCharArray();

        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && p[i] != p[j]) {
                j = F[j - 1];
            }
            if (p[i] == p[j]) {
                F[i] = ++j;
            }
        }

        return F;
    }
}
