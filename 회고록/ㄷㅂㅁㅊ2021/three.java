package 데브매칭2021;

import java.util.HashMap;

public class three {
    static HashMap<String,Node> map;
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral ={"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        map=new HashMap<>();

        for (int i=0;i<enroll.length;i++){
            map.put(enroll[i],new Node(enroll[i]));
        }

        for (int i=0;i<referral.length;i++){
            String parent=referral[i];
            String name = enroll[i];
            if (parent.equals("-"))continue;

            Node node = map.get(name);
            node.parent = map.get(parent);
        }


        for (int i=0;i<seller.length;i++){
            String sell = seller[i];
            int money = amount[i] * 100;
            find(map.get(sell),money);
        }
        int[] result = new int[enroll.length];

        for (int i=0;i<enroll.length;i++){
            result[i]=map.get(enroll[i]).total;
        }

    }
    static void find(Node node,int money){
        int splitCost = (int)(money*0.1);
        node.total += (money-splitCost);

        if (node.parent==null)return;
        if (splitCost==0)return;

        find(node.parent,splitCost);
    }

    static class Node{
        Node parent;
        String name;
        int total;
        Node(String name){
            this.name=name;
        }
    }
}
