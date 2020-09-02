package test;
/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 *
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 	尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 	要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * */
public class rotate_array_189 {
    public void rotate1(int[] nums, int k) {


        /**
         * 暴力求解：
         * 1.递归遍历循环K次数组，将每个元素后移，将尾元素放到首位
         * 旋转 k 次，每次将数组旋转 1 个元素
         * 时间复杂度 O（k*n),空间复杂度 O(1)
         * */
        int temp, end;
        for (int i = 0; i < k; i++) {
            end = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = end;
                end = temp;

            }
        }
    }

    public void rotate2(int[] nums, int k) {
        /**
         * 放进一个新数组,我们可以用一个额外的数组来将每个元素放到正确的位置上，
         * 也就是原本数组里下标为 i 的我们把它放到 (i+k)%数组长度的位置。
         * 然后把新的数组拷贝到原数组中。
         *
         * 时间复杂度O(n),空间复杂度O(n)
         * */
        int[] a = new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            a[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0;i<nums.length;i++){
            nums[i] = a[i];
        }

    }



        /**
         * 用一个下标索引p，下标元素移动K个位置，进行遍历
         * 如果p+k>nums.length,赋值nums[p+k-nums.length] = nums[p]
         * */
        public void rotate3(int[] nums, int k) {
            int length = nums.length;
            k = k%length;
            int count = 0;
            for (int start = 0;count<length;start++){
                int cur = start;
                int pre = nums[cur];
                do{
                    int next = (cur+k)%length;
                    int temp = nums[next];
                    nums[next] = pre;
                    pre = temp;
                    cur = next;
                    count++;
                }while (start != cur);
            }
        }



}
