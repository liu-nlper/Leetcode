import java.util.HashSet;
import java.util.Set;

/**
   Created by ljx on 17-7-14.
   Given an array of integers, every element appears twice except for one. Find that single one.

   Note:
   Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number_136 {
    public Single_Number_136() {}

    /**
     * 方案１（需要额外空间）:
     * 由于数组中除了一个元素是single之外，其余元素均出现两次，
     * 这里设置一个set，对于每个元素判断是否在集合中，若不存在，则添加；若存在，则删除。
     * 那么，集合中剩余的最后一个元素就是single。
     */
    public int singleNumber(int[] nums) {
        Set set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return (int)set.iterator().next();
    }

    /***
     * 方案２：
     * 利用异或：
     * ((1^1)^(2^2)^(3^3)^(4^4)^(9)) = 9
     */
    public int singleNumber_2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,3,9,4,4};
        int single = new Single_Number_136().singleNumber_2(nums);
        System.out.println(single);
    }
}
