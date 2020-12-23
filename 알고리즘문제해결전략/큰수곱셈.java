package 알고리즘문제해결전략;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 큰수를 곱할때 사용할 수 있는방법 ->A[i]*B[j] = c[i+j]번째에 입력을 받는다
// 그후 c를 밑에서부터 돌면서 carry를 따져준다
public class 큰수곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[] c = new int[a.length()+b.length()];

        String s="";
        for (int i=a.length()-1;i>=0;i--){
            s+=a.charAt(i);
        }
        a=s.toString();
        s="";
        for (int i=b.length()-1;i>=0;i--){
            s+=b.charAt(i);
        }
        b=s.toString();

        for (int i=0;i<a.length();i++){
            for (int j=0;j<b.length();j++){
                int ta = a.charAt(i) - '0';
                int tb = b.charAt(j) - '0';
                c[i+j] += ta*tb;
            }
        }
        nomalization(c);
        for (int i=c.length-2;i>=0;i--){
            System.out.print(c[i]);
        }
    }
    static void nomalization(int[] c){
        int carry=0;
        for (int i=0;i<c.length;i++){
            c[i]+=carry;
            carry = c[i]/10;
            c[i] = c[i]%10;
        }
    }
}
