package KMPMatch;

public class KMPMatch {

    public static void main(String[] args){

        KMPMatch kmpMatch = new KMPMatch();
        kmpMatch.getNext("AACDAAD");
    }

    public int[] getNext(String s){

        int[] next = new int[s.length()];
        next[0] = -1;
        next[1] = 0;

        for(int i = 2; i < s.length(); i++){
            int count = 0;
            for(int j = 0; i - j >= 0; j++){
                if(s.charAt(j) == s.charAt(i - j)){
                    count++;
                }
            }
            next[i] = count;
        }

        for(int i = 0; i < s.length(); i++){
            System.out.print(next[i] + " ");
        }

        System.out.println();

        return next;
    }
}
