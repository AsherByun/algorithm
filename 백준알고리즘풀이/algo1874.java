package 백준;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class algo1874 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();

        Stack<Integer> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();

        HashSet<Integer> removed=new HashSet<>();
        int now=1;

        for (int i=0;i<n;i++){
            int target = scan.nextInt();
            if (removed.contains(target)){
                System.out.println("NO");
                return;
            }

            while (now<=target){
                stack.push(now++);
                sb.append("+"+"\n");
            }
            
            boolean isFind=false;
            while (!stack.isEmpty()){
                sb.append("-"+"\n");
                int get=stack.pop();
                removed.add(get);
                if (get==target){
                    isFind=true;
                    break;
                }
            }
            if (!isFind){
                System.out.println("NO");
                return;
            }
        }
        System.out.print(sb);
    }
}
