package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;

public class 파일명정렬 {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        ArrayList<File> arr=new ArrayList<>();
        for (int i=0;i<files.length;i++){
            arr.add(new File(files[i],i));
        }
        Collections.sort(arr);
        String[] answer = new String[arr.size()];
        for (int i=0;i<arr.size();i++)answer[i]=arr.get(i).total;

    }
    static class File implements Comparable<File>{
        int idx;
        int number;
        String total;
        String head;

        File(String file,int idx){
            this.idx=idx;
            this.total=file;

            int headp=0,nump=0;
            for (int i=0;i<file.length();i++){
                if (Character.isDigit(file.charAt(i))){
                    headp=i;break;
                }
            }
            for (int i=headp;i<file.length();i++){
                if (Character.isDigit(file.charAt(i))){
                    nump=i;
                }else{
                    break;
                }
            }
            this.head = file.substring(0,headp).toLowerCase();
            this.number = Integer.parseInt(file.substring(headp,nump+1));

        }



        @Override
        public int compareTo(File o) {
            if (!this.head.equals(o.head))return this.head.compareTo(o.head);
            else{
                if (this.number<o.number)return -1;
                else if (this.number>o.number)return 1;
                else {
                    return this.idx<o.idx?-1:1;
                }
            }
        }
    }
}
