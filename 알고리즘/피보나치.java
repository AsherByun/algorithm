package 알고리즘;

public class 피보나치 {
    public static void main(String[] args) {
        System.out.println(fibo(8));
    }
    static int fibo(int n){
        if (n<=1)return 1;
        else{
            return fibo(n-1)+fibo(n-2);
        }
    }
}
