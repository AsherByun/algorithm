package 가비아;

public class one {
    public static void main(String[] args) {
        int n=Integer.MAX_VALUE;

        int five=0;

        while(n>=5){
            five+=n/5;
            n/=5;
        }
        System.out.println(five);

    }
}
