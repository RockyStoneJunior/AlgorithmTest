package SubsequenceNumber;

public class SubsequenceNumber {

    public static void main(String[] args){

        SubsequenceNumber subsequenceNumber = new SubsequenceNumber();

        System.out.println(subsequenceNumber.solution("babgbag","bag"));
    }

    public int solution(String s, String t){

        int len_s = s.length();
        int len_t = t.length();
        int[][] dp = new int[len_t + 1][len_s + 1];

        for(int i = 0; i <= len_s; i++)
            dp[0][i] = 1;

        for(int i = 1; i <= len_t; i++)
            dp[i][0] = 0;

        for(int i = 1; i <= len_t; i++){
            for(int j = 1; j <= len_s; j++){
                if(s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        for(int i = 0; i <= len_t; i++){
            for(int j = 0; j <= len_s; j++){
                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }

        return dp[len_t][len_s];
    }
}