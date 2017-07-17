/**
 * Created by ljx on 17-7-17.
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

   For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

   Note:
     1. You must do this in-place without making a copy of the array.
     2. Minimize the total number of operations.
 */
public class Move_Zeros_283 {

    /**
     * 设置变量j来记录非零值前面的0的位置（若存在0值的话），则遇到非０值时，交换两者
     */
    public void moveZeros(int[] nums) {
        int j = 0;
        int temp;
        for (int i=0; i<nums.length; ++i) {
            if (nums[i] != 0) {
                if (i == j) {
                    ++j;
                    continue;
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public void printList(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        Move_Zeros_283 mz = new Move_Zeros_283();
        mz.moveZeros(nums);
        mz.printList(nums);
    }
}
