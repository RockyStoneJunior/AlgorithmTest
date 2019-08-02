package LongestPalindrome;

/*
 * @Author: Rocky Stone
 * @Date:   2019-08-02
 * @Description: This problem is from leetcode
 *               The original problem is as follows:
 *
 *               给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *               示例 1:
 *               输入: "babad"
 *               输出: "bab"
 *               注意: "aba" 也是一个有效答案。
 */
public class LongestPalindrome {
    public static void main(String[] args){
        System.out.println(solution("abcda"));
    }

    public static String solution(String s){

        int n = s.length();
        boolean table[][] = new boolean[n][n];

        print_table(table, n);

        System.out.println();
        print_table(table, n);

        for(int i = 0; i < n; i++)
        {
            table[i][i] = true;

            int j = 1;
            int left,right;

            while(((left = i - j) >= 0) && ((right = i + j)< n)){
                if(s.charAt(left) == s.charAt(right)){
                    table[left][right] = true;
                    j++;
                }else{
                    j++;
                    break;
                }
            }

            if((i + 1 < n) && (s.charAt(i) == s.charAt(i + 1))) {
                j = 1;
                while (((left = i - j + 1) >= 0) && ((right = i + j) < n)) {
                    if (s.charAt(left) == s.charAt(right)) {
                        table[left][right] = true;
                        j++;
                    }else{
                        j++;
                        break;
                    }
                }
            }
        }

        System.out.println();
        print_table(table, n);

        int start = 0;
        int end = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(table[i][j] == true){
                    if(j - i + 1 >= max){
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        System.out.println(start + " " + end + " " + max);

        return s.substring(start, start + max);
    }

    public static void print_table(boolean table[][], int n){
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
            {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
