package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 매칭점수 {
    public static void main(String[] args) {

        String word = "Muzi";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        HashMap<String,Integer> hash=new HashMap<>();
        word = word.toLowerCase();
        Page[] page = new Page[pages.length];


        for (int i=0;i<pages.length;i++){
            page[i]=new Page();
            page[i].idx=i;
            String head = pages[i].split("</head>")[0];
            String namestr = head.split("<meta property=\"og:url\" content=\"https://")[1].split("\"")[0];
            page[i].name=namestr;
            hash.put(namestr,i);

            String body = pages[i].split("</head>")[1].split("</body>")[0];
            String tempstr = body.substring(9);

            StringBuilder[] sb = spliting(tempstr);

            page[i].base = findBase(sb[0].toString().toLowerCase(),word);
            page[i].total += page[i].base;
            findExternal(sb[1].toString(),page[i]);
            page[i].linkPoint = page[i].base / page[i].external.size();
        }
        PriorityQueue<Page> pq = new PriorityQueue<>();
            for (int i=0;i<page.length;i++){
                for (int j=0;j<page[i].external.size();j++) {
                    String name = page[i].external.get(j);
                    if (hash.containsKey(name)) {
                        int idx = hash.get(name);
                        page[idx].total += page[i].linkPoint;
                    }
                }
            }
            for (int i=0;i<page.length;i++){
                pq.offer(page[i]);
            }

            System.out.println(pq.poll().idx);
    }
    static void findExternal(String link,Page page){
        String[] links = link.split("<a href=\"https://");
        for (int i=1;i<links.length;i++){
            String str = links[i].split("\"")[0];
            page.external.add(str);
        }

    }
    static StringBuilder[] spliting(String tempstr){
        StringBuilder sb[] =new StringBuilder[2];
        sb[0] =new StringBuilder(); sb[1]=new StringBuilder();

        int what=0;

        for (int i=0;i<tempstr.length();i++){
            char now = tempstr.charAt(i);

            if (now=='<'&&what==0){
                what=2;
                sb[1].append(now);continue;
            }
            if (now=='>'){
                what--;
                sb[1].append(now);continue;
            }

            if (what==0){
                if(Character.isLetter(now)){
                    sb[0].append(now);
                }else{
                    sb[0].append(" ");
                }
            }else{
                sb[1].append(now);
            }

        }
        return sb;

    }
    static double findBase(String contents,String word){
        double base = 0;

        String[] contentsCounting = contents.split(" ");
        for (int j=0;j<contentsCounting.length;j++){
            if (contentsCounting[j].equals(word))base++;
        }

        return base;
    }
    static class Page implements Comparable<Page>{
        double linkPoint;
        int idx;
        String name;
        ArrayList<String> inlink= new ArrayList<>();
        double base;
        double total;
        ArrayList<String> external = new ArrayList<>();

        @Override
        public int compareTo(Page o) {
            if (this.total>o.total)return -1;
            else if (this.total<o.total)return 1;
            else{
                if (this.idx<o.idx)return -1;
                else return 1;
            }
        }
    }
}
