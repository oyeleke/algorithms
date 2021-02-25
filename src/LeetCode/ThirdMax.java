package LeetCode;


import java.util.HashSet;
import java.util.Set;

public class ThirdMax {

    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        if (set.size() == 1) {
            return nums[0];
        } else if (set.size() == 2) {
            int max = Integer.MIN_VALUE;
            for (int d : set) {
                if (d > max) {
                    max = d;
                }
            }
            return max;
        } else {
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

            for (int n : nums) {

                if (n > max1 && max1 != n) {
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                    System.out.println("max1 " + max1 + " : " + max2 + " : " + max3);
                } else if (n > max2 && max2 != n && max1 != n) {
                    max3 = max2;
                    max2 = n;
                    System.out.println("max2 " + max1 + " : " + max2 + " : " + max3);
                } else if ((n > max3 || n == Integer.MIN_VALUE) && max2 != n && max1 != n) {
                    max3 = n;
                    System.out.println("max3 " + max1 + " : " + max2 + " : " + max3);
                }
            }
            System.out.println("test " + findElement(nums, Integer.MIN_VALUE));
            if (max3 == Integer.MIN_VALUE && findElement(nums, Integer.MIN_VALUE) != -1) {
                return max3;
            } else if (max3 != Integer.MIN_VALUE) {
                return max3;
            } else {
                return max1;
            }
        }
    }

    public int findElement(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int thirdMax2(int[] nums) {
        double max1 = Double.NEGATIVE_INFINITY, max2 = Double.NEGATIVE_INFINITY, max3 = Double.NEGATIVE_INFINITY;

        for (int n : nums) {

            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;

            } else if (n < max1 && n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n < max2 && n > max3) {
                max3 = n;
            }
        }
        System.out.println("test " + findElement(nums, Integer.MIN_VALUE));
        if (max3 == Double.NEGATIVE_INFINITY) {
            return (int) max3;
        } else {
            return (int) max1;
        }
    }
}
