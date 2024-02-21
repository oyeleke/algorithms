package backtobackswe.trees;

public class MinHeightBst {

    public TreeNode sortedArrayToBST(int[] nums) {
        int half = nums.length / 2;

        TreeNode root = new TreeNode(nums[half]);
        boolean isEven = lengthIsEven(nums.length);
        int[] left = new int[half];
        int[] right;
        if (isEven) {
            right = new int[half - 1];
        } else {
            right = new int[half];
        }
        System.arraycopy(nums, 0, left, 0, half);
        System.arraycopy(nums, half + 1, right, 0,  isEven ? half-1 : half);
        root.left = returnChildren(left);
        root.right = returnChildren(right);
        return root;
    }

    private TreeNode returnChildren(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else if (nums.length > 1) {
            int half = nums.length / 2;
            boolean isEven = lengthIsEven(nums.length);
            int[] left = new int[half];
            int [] right;
            if (isEven) {
                right = new int[half - 1];
            } else {
                right = new int[half];
            }
            int copyAmountEnd = nums.length - (half - 1);
            System.out.println("half " + half);
            System.arraycopy(nums, 0, left, 0, half);
            if (copyAmountEnd != 0) {
                System.arraycopy(nums, half + 1, right, 0, isEven ? half-1 : half);
            }
            TreeNode root = new TreeNode(nums[half]);
            printArray(left, "left");
            printArray(right, "right");
            root.left = returnChildren(left);
            root.right = returnChildren(right);
            return root;
        } else {
            return null;
        }
    }

    private boolean lengthIsEven(int lenght) {
        return lenght % 2 == 0;
    }

    private void printArray(int[] nums, String name) {
        System.out.println(name);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        return buildMinHeighBST(nums, 0, nums.length);
    }

    private TreeNode buildMinHeighBST(int [] nums, int start, int end){
        if (start >= end){
            return null;
        }

        int midpoint = start + ((end - start)/2);
        TreeNode n = new TreeNode(nums[midpoint]);

        n.left = buildMinHeighBST(nums, start, midpoint);
        n.right = buildMinHeighBST(nums, midpoint+1, end);
        return n;
    }

    public static void main(String[] args) {
        int[] arry = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        MinHeightBst minHeightBst = new MinHeightBst();
        TreeNode node = minHeightBst.sortedArrayToBST(arry);
    }
}

//5,3,2,1,4,7,6,8