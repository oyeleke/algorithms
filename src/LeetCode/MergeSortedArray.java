package LeetCode;

public class MergeSortedArray {
    public void mergeSortedArrayMinimalMem(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int finalPtr = m + n - 1;

        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] > nums2[ptr2]) {
                nums1[finalPtr] = nums1[ptr1];
                --finalPtr;
                --ptr1;
            }
            else {
                nums1[finalPtr] = nums2[ptr2];
                --finalPtr;
                --ptr2;
            }
        }

        while (ptr1 >= 0) {
            nums1[finalPtr] = nums1[ptr1];
            --finalPtr;
            --ptr1;
        }
        while (ptr2 >= 0) {
            nums1[finalPtr] = nums2[ptr2];
            --finalPtr;
            --ptr2;
        }

        return;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] result = new int[m+n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m){
            result[k] = nums1[i];
            i++;
            k++;
        }

        while(j < n){
            result[k] = nums2[j];
            j++;
            k++;
        }

        for(int d = 0; d< result.length; d++){
            nums1[d] = result[d];
        }
    }
}

