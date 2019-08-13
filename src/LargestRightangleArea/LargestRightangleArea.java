package LargestRightangleArea;

public class LargestRightangleArea {

    public static void main(String[] args){

        LargestRightangleArea largestRightangleArea = new LargestRightangleArea();

        System.out.println(largestRightangleArea.solution(new int[]{2,1,2}));
    }

    public int solution(int[] heights){

        int len = heights.length;
        int maxArea = 0;
        int i,j,k;

        for(i = 0; i < len; i++){

            for(j = i - 1; j >= 0; j--){
                if(heights[j] < heights[i]){
                    break;
                }
            }

            for(k = i + 1; k < len; k++){
                if(heights[k] < heights[i]){
                    break;
                }
            }

            maxArea = Math.max(maxArea, heights[i] * (k - j - 1));
        }

        return maxArea;
    }
}