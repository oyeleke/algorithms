package elements_of_programming_interviews;

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }

        System.gc();
    }

    public void mergeSlo(int[] nums1, int m, int[] nums2, int n) {
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
