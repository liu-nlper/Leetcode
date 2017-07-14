/**
    Created by ljx on 17-7-14.

    问题描述：
    Given a binary array, find the maximum number of consecutive 1s in this array.

    Example 1:
      Input: [1,1,0,1,1,1]
      Output: 3
      Explanation: The first two digits or the last three digits are consecutive 1s.
        The maximum number of consecutive 1s is 3.

    Note:
    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000
 */
public class Max_Consecutive_Ones_485 {
    public Max_Consecutive_Ones_485() {}

    /***
     * 方案１：
     * 思路：维护一个全局的最长长度和一个当前的最长长度，若当前最长长度大于全局的，则更新全局长度。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int golbalMax = 0, currentMax = 0;
        for (int i=0; i<nums.length; ++i) {
            if (nums[i] == 0) {
                currentMax = 0;
                continue;
            } else {
                currentMax += 1;
            }
            if (currentMax > golbalMax) {
                golbalMax = currentMax;
            }
        }
        return golbalMax;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int maxC = new Max_Consecutive_Ones_485().findMaxConsecutiveOnes(nums);
        System.out.println(maxC);
    }
}
