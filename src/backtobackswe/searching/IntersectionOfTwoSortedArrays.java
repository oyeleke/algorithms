package backtobackswe.searching;

import java.util.*;

public class IntersectionOfTwoSortedArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intList = new HashSet<>();
        HashMap<Integer, Boolean> longerArrayMap = new HashMap<>();
        int[] numList = nums1.length >= nums2.length ? nums1 : nums2;
        int[] otherArray = nums1.length < nums2.length ? nums1 : nums2;
        // insert longer array into hashmap
        for (int num : numList) {
            longerArrayMap.put(num, true);
        }
        // if key exists in hashMap add to list
        for (int num : otherArray) {
            if (longerArrayMap.containsKey(num)) {
                intList.add(num);
            }
        }

        return intList.stream().filter(Objects::nonNull).mapToInt(e -> e).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> intList = new HashSet<>();
        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < nums1.length && ptr2 < nums2.length){
            if (nums1[ptr1] == nums2[ptr2]){
                intList.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] < nums2[ptr2]){
                ptr1++;
            } else {
                ptr2++;
            }
        }

        return intList.stream().filter(Objects::nonNull).mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoSortedArrays intersectionOfTwoSortedArrays = new IntersectionOfTwoSortedArrays();
        System.out.println("Ans " + Arrays.toString(intersectionOfTwoSortedArrays.intersection2(new int[]{1, 2, 3, 4}, new int[]{1, 2})));
    }
}
