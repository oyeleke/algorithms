package amazon;

public class MaxArea {
    public int maxArea(int[] height) {
        int area = 0;
        int last = height.length -1;
        int i = 0;
        int j = last;
        while (i < j){
            int temp = (height[j] - height[i]) *   (j - i);
            if (temp > area){
                area = temp;
            }

            if (i+1 < j && height[i+1] > height[i] ){
                i++;
            } else if(j-1 > i && height[j-1] > height[j]){
                j++;
            } else if(height[j] > height[i]){
                i++;
            } else if (height[i] > height[j]){
                j++;
            } else {
                j++;
                i++;
            }
        }

        return area;
    }
}
