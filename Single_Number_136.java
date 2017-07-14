import java.util.HashSet;
import java.util.Set;

/**

   问题描述：

   Given an array of integers, every element appears twice except for one. Find that single one.

   Note:
   Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 */
public class Single_Number_136 {
    public Single_Number_136() {}

    /**
     * 方案１（该方案需要额外的memory）:
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

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,3,0,4,4};
        int single = new Single_Number_136().singleNumber(nums);
        System.out.println(single);
    }
}
