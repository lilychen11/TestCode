package cn.lily.example;

public class Test4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Array can not be null");
        }
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int iMin =  0, iMax = m, i = 0, j = 0;
        int halflength = (m + n + 1) / 2;
        while (iMax >= iMin) {
            i = (iMax + iMin) / 2;
            j = halflength - i;
            if (i < iMax && nums1[i] < nums2[j - 1]){
                iMin++;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax--;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if(j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
