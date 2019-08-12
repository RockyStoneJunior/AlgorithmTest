package TrapOfRain;

public class TrapOfRain {

    public static void main(String[] args) {
        TrapOfRain trapOfRain = new TrapOfRain();
        //System.out.println(trapOfRain.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapOfRain.trap(new int[]{4,2,3}));
    }


    public int trap(int[] height) {

        int volume = 0;
        int temp = 0;

        int start = 0;
        int end = 0;
        while (end < height.length) {
            if (height[end] < height[start]) {
                temp += height[start] - height[end];
            } else {
                start = end;
                volume += temp;
                temp = 0;
            }
            end++;
        }

        int stop = start;
        start = end = height.length - 1;
        temp = 0;
        while(end >= stop){
            if (height[end] < height[start]) {
                temp += height[start] - height[end];
            } else {
                start = end;
                volume += temp;
                temp = 0;
            }
            end--;
        }

        return volume;
    }
}
