package ShorestEditDistance;

public class ShortestEditDistance {

    public static void main(String[] args){

        ShortestEditDistance shortestEditDistance = new ShortestEditDistance();

        System.out.println(shortestEditDistance.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2){

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i < len1 + 1; i++){
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for(int j = 1; j < len2 + 1; j++){
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        for(int i = 0; i < len1 + 1; i++){
            for(int j = 0; j < len2 + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }

        return dp[len1][len2];
    }
}