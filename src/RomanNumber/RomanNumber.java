package RomanNumber;

import java.lang.reflect.Array;
import java.util.*;

public class RomanNumber {

    public static void main(String[] args){
        //System.out.println(intToRoman(3999));

        //System.out.println(calPoints(new String[]{"5","2","C","D","+"}));

        //System.out.println(titleToNumber("ZY"));
    }

    public static String intToRoman(int num){
        int [] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10 ,9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C" , "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;

        while (index < 13){
            while(num >= nums[index]){
                stringBuilder.append(romans[index] + " ");
                num -= nums[index];
            }

            index++;
        }

        return stringBuilder.toString();
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for(int i = 0; i < len1; i++){
            set.add(nums1[i]);
        }

        for(int j = 0; j < len2; j++){
            if(set.contains(nums2[j])){
                resultSet.add(nums2[j]);
            }
        }

        int size = resultSet.size();
        int[] result = new int[size];

        int k = 0;
        for(int num : resultSet){
            result[k++] = num;
        }

        return result;
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for(String score : ops){

            if(score.equals("+")){
                stack.push(stack.peek() + stack.get(stack.size() - 2));
            }else if(score.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(score.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(score));
            }
        }

        int result = 0;
        for(int score : stack){
            result += score;
        }

        return result;
    }

    public static int titleToNumber(String s) {

        int len = s.length();

        int result = 0;
        for(int i = 0; i < len; i++){
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
        }

        return result;
    }

    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        if(map.containsKey(target)){
            return map.get(target);
        }else {
            return -1;
        }
    }
}
