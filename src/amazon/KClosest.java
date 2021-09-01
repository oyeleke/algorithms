package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KClosest {


    public int[][] kClosest(int[][] points, int k) {

        int[][] ans = new int[k][2];
        double[] distances = new double[points.length];
        HashMap<Double, List<Integer>> hashMap = new HashMap<>();

        for (int a = 0; a < points.length; a++) {
            double dist = calcDistance(points[a][0], points[a][1]);
            distances[a] = dist;
            if (hashMap.containsKey(dist)) {
                hashMap.get(dist).add(a);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                hashMap.put(dist, temp);
            }
        }

        Arrays.sort(distances);

        for (int i = 0; i <= k; i++) {
            List<Integer> temp = hashMap.get(distances[i]);
            if (temp.size() > 1) {
                int j = temp.get(0);
                ans[i] = points[j];
                temp.remove(0);
                hashMap.put(distances[i], temp);
            } else {
                ans[i] = points[hashMap.get(distances[i]).get(0)];
            }
        }

        return ans;
    }

    public double calcDistance(int x, int y) {
        return (Math.sqrt(x * x + y * y));
    }

    public int calculateDis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public void swap(int [][] points, int a, int b){
        int [] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }

    public int partition(int [][] points, int left, int right){
        int pivot = left;
        int dis = calculateDis(points[left]);
        left++;

        while (left <= right){
            if (calculateDis(points[left])<= dis ){
                left++;
            } else if (calculateDis(points[right]) >= dis){
                right--;
            } else {
                swap(points, left, right);
            }
        }

        swap(points, pivot, right);
        return right;
    }

    public int[][] kClosestf(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;

        while (left <= right){
            int pivot = partition(points, left, right);
            if (pivot == k){
                break;
            } else if(pivot > k){
                right = pivot - 1;
            } else {
                right = pivot + 1;
            }
        }

        return Arrays.copyOfRange(points, 0, k);
    }
    }
