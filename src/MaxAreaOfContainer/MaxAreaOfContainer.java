package MaxAreaOfContainer;

public class MaxAreaOfContainer {

    public static void main(String[] args){

        MaxAreaOfContainer maxAreaOfContainer = new MaxAreaOfContainer();

        System.out.println(maxAreaOfContainer.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxAreaOfContainer.maxAreaByOnePass(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height){

        int area = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = 1; j < height.length; j++){
                int curr_area = Math.min(height[i],height[j]) * (j - i);
                if(curr_area > area){
                    area = curr_area;
                }
            }
        }

        return area;
    }

    public int maxAreaByOnePass(int[] height){
        int maxArea = 0;

        int start = 0;
        int end = height.length - 1;

        while(start < end){
            int currArea = Math.min(height[start], height[end]) * (end - start);
            if(currArea > maxArea){
                maxArea = currArea;
            }

            if(height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }

        return maxArea;
    }
}
