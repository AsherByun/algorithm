package nhn2020;

public class nhn3 {
    public static void main(String[] args) {
        int numOfOrder=3;
        String[] orderArr={"3(BR2(R))","B(RGB(RG))","1B2R3G"};

        for (int i=0;i<numOfOrder;i++){
            char[] cmap=orderArr[i].toCharArray();
            Str str=dfs(cmap,0);
            System.out.println(str.s);
        }

    }
    static Str dfs(char[] cmap,int idx){
        StringBuilder sb=new StringBuilder();
        int n=-1;
        int returnIdx=0;
        int len=0;

        for (int i=idx;i<cmap.length;i++){
            char nextChar=cmap[i];
            if (Character.isDigit(nextChar)){
                n=nextChar-'0';
            }else if(n!=-1&&Character.isAlphabetic(nextChar)){
                for (int j=0;j<n;j++){
                    sb.append(nextChar);
                }
            }else if(nextChar=='('){
                Str str=dfs(cmap,i+1);

                if (n==-1){
                    char lastStr=cmap[i-1];
                    for (int j=0;j<str.s.length();j++){
                        if(j!=0)sb.append(lastStr);
                        sb.append(str.s.charAt(j));
                    }
                }
                else {
                    for (int j = 0; j < n; j++) {
                        sb.append(str.s);
                    }
                }
                i=str.idx;
                n=0;

            }else if (Character.isAlphabetic(nextChar)){
                sb.append(nextChar);
                len++;
            }else if (nextChar==')'){
                returnIdx=i;
                break;
            }
        }
        return new Str(returnIdx,sb.toString());
    }

    static class Str{
        int idx;
        String s;
        Str(int idx,String s){
            this.idx=idx;
            this.s=s;
        }
    }
}
