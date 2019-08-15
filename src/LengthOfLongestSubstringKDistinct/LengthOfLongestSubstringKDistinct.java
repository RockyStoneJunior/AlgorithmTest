package LengthOfLongestSubstringKDistinct;

import LargestRightangleArea.LargestRightangleArea;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstringKDistinct {

    public static void main(String[] args){
        LengthOfLongestSubstringKDistinct lengthOfLongestSubstringKDistinct = new LengthOfLongestSubstringKDistinct();
        System.out.println(lengthOfLongestSubstringKDistinct.solution("eceba", 2));

        int j = 0;
        while (j++ < 10){
            int i = 1;
            System.out.print(i++ + " ");
        }
    }

    public int solution(String s, int k){

        // s = "eceba" k = 2
        // out = 3 "ece"

        int len = s.length();
        int result = 0;
        int i, j;
        for (i = 0; i < len; i++) {

            Set<Character> set = new HashSet<>();

            for (j = i; j < len; j++) {
                set.add(s.charAt(j));

                if (set.size() > k) {
                    break;
                }
            }

            result = Math.max(result, j - i);
        }

        return result;
    }

    public int slideWindow(String s, int k){

        int len = s.length();
        int left = 0;
        int right = 0;

        while(right < len){

//            Set<Character> set = new HashSet<>();
//
//            if(){
//
//            }
        }

        return 0;
    }

}
