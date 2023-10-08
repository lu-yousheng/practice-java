import java.util.Arrays;
//88. 合并两个有序数组
// 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
// 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (n == 0) {
//            return;
//        }
//        if (m == 0) {
//            for (int i = 0; i < n; i++) {
//                nums1[i] =nums2[i];
//            }
//            return;
//        }
//        int end = m + n - 1;
//        int[] tmp = new int[m+n];
//        while (end != 0 & m > 0 && n >0) {
//            if (nums1[m-1] <= nums2[n-1]) {
//                tmp[end] = nums2[n-1];
//                n--;
//            } else {
//                tmp[end] = nums1[m-1];
//                m--;
//            }
//            end--;
//        }
//
//            while ( end >= 0 && m > 0) {
//                tmp[end] = nums1[m-1];
//                m--;
//                end--;
//            }
//            while (end >= 0 && n > 0) {
//                tmp[end] = nums2[n-1];
//                n--;
//                end--;
//            }
//        for(int i = 0;i < tmp.length; i++) {
//            nums1[i] = tmp[i];
//        }
//        return;
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1,3,nums2,nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}