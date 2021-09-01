package amazon;

import java.util.Stack;

public class TrapWater {

    public int trap(int[] height) {
        int current = 0, ans = 0;
        Stack<Integer> stack = new Stack<>();
        while(current < height.length){

            while(!stack.isEmpty() && height[current] > height[stack.peek()]){

                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }

                int distance = current - stack.peek() - 1;

                int calheight = Math.min(height[current], height[stack.peek()]);
                ans += distance*calheight;
            }

            stack.push(current++);
        }

        return ans;
    }
}
