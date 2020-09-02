package test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class merge_sorted_array_88 {
    /**
     * 88. 合并两个有序数组
     *
     * 给你两个有序整数数组 nums1 和 nums2，
     * 请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     * 说明:
     * 	初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     * */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 暴力解法：
         * 合并后排序
         *
         * 时间复杂度较差，为O((n+m)log(n+m))
         * 这是由于这种方法没有利用两个数组本身已经有序这一点。
         *
         * */
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);

    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        /**
         * 法二：双指针 / 从后往前
         *  三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p3、最终数组尾部
         *  1.当，p1>=0时，nums[p1],nums[p2]对比
         *  1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
         *  1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
         *  2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
         *  循环结束条件：p2<0
         * */
        int p1 = m-1;
        int p2 = n-1;
        int p3 = m+n-1;
        while (p2>=0){
            if (p1>=0 && nums1[p1]>nums2[p2]){
                nums1[p3--] = nums1[p1--];
            }else {
                nums1[p3--] =nums2[p2--];
            }
        }
    }
}
