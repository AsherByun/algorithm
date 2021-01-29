package 알고리즘.특수알고리즘;
//평균필터 알고리즘
public class 평균최적화 {

    public static double 평균구하기최적화(double preAvg,double newScore,double len){
        double oldWeight = (len-1)/len ; //지난것들의 가중치
        double newWeight = 1/len ; //새로운것의 가중치

        return (oldWeight*preAvg) + (newScore*newWeight);
    }

    public static void main(String[] args) {
        double avg = 0;
        for (int i=1;i<=1000;i++){
            avg = 평균구하기최적화(avg,i,i);
            System.out.println(avg);
        }
    }
}
