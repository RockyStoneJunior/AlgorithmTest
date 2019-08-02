package LengthOfLongestSubString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @Author: Rocky Stone
 * @Date: 2019-08-01
 * @Description: This problem is from leetcode
 *               The original problem is as follows:
 *
 *               给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 */

public class LengthOfLongestSubString {
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("hello"));
        System.out.println(lengthOfLongestSubstringBetterSlidingWindow("helloworld"));

        Map<String, String> map = new HashMap<>();
        map.put("stone", "hello");
        map.put("stone", "world");

        System.out.println("stone: " + map.get("stone"));
    }


    /******************** Brute Force Solution ***********************/
    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        int ans =  0;
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        }

        return ans;
    }

    public static boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            Character ch = s.charAt(i);
            if(set.contains(ch))
                return false;
            set.add(ch);
        }

        return true;
    }
    /******************** Brute Force Solution ***********************/


    /******************** Sliding Window Solution  *******************/

//    public  int lengthOfLongestSubstringSlidingWindow(String s){
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while(i < n && j < n){
//            if(!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans =
//            }
//        }
//    }

    /******************** Sliding Window Solution  *******************/

    /******************** Better Sliding Window Solution  *******************/

    public static int lengthOfLongestSubstringBetterSlidingWindow(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0, j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }

            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    /******************** Better Sliding Window Solution  *******************/
}
